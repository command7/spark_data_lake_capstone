import pandas as pd


def get_file_path(tsv_file_name):
    return f"../../Data.nosync/{tsv_file_name}"


def open_file(tsv_file_name):
    file_df = pd.read_csv(get_file_path(tsv_file_name), sep="\t")
    return file_df


def get_destination_path(tsv_file_name):
    return f"Data.nosync/{tsv_file_name}"


def write_df_as_csv(df, file_name):
    df.to_csv(get_destination_path(file_name),
              index=False,
              header=True)


def log(print_msg):
    print(print_msg)


def convert_list_to_dict(input_list):
    converted_dict = {input_list[i]: 1 for i in range(0, len(input_list))}
    return converted_dict


def get_unique_values(df, column_name):
    return list(df[column_name].unique())


def get_column_index(df, req_column_name):
    req_column_index = None
    df_columns = list(df.columns)
    for column_index, each_column in enumerate(df_columns):
        if each_column == req_column_name:
            req_column_index = column_index
            break
    if req_column_index is None:
        raise Exception
    return req_column_index


def remove_invalid_records(valid_df, unclean_df, match_column_index):
    log("Removing invalid indices.")
    invalid_indices = list()
    valid_tconsts = get_unique_values(valid_df, "tconst")
    valid_tconsts_dict = convert_list_to_dict(valid_tconsts)
    total_records = unclean_df.shape[0]
    current_record_number = 0
    for row_index, row_values in unclean_df.iterrows():
        current_record_number += 1
        percentage_completed = (current_record_number/total_records) * 100
        if percentage_completed % 5 == 0:
            log(f"{percentage_completed}% completed.")
        if valid_tconsts_dict.get(row_values[match_column_index]) is None:
            invalid_indices.append(row_index)
        else:
            continue
    return unclean_df.drop(invalid_indices)


def clean_file(valid_df, unclean_df, match_column_index, destination_file_name):
    clean_df = remove_invalid_records(valid_df, unclean_df, match_column_index)
    write_df_as_csv(clean_df, destination_file_name)


title_basics = open_file("title.basics.tsv")
log("Title.basics opened")
title_crew = open_file("title.crew.tsv")
log("Title.Crew opened")
name_basics = open_file("name.basics.tsv")
log("Name.basics opened")
title_ratings = open_file("title.ratings.tsv")
log("Title.ratings opened")
title_akas = open_file("title.akas.tsv")
log("Title.akas opened")


# Merging to obtain title ratings
df = pd.merge(left=title_basics,
              right=title_ratings,
              on="tconst",
              how="left")
log("Merged title.basics with ratings.")

# Remove records that do not have a rating
df = df[df.averageRating.notna()]
log("Removed records with no ratings.")

# Remove rows with missing genres
df = df[df.genres.notna()]
log("Removed records that do not have a genre assigned to it.")

# Remove rows with \\N as value
df = df[df.genres != "\\N"]
log("Removed records that have \"\\\\N\" as value")

# Retrieve primary genre for all genres
df["genre"] = df.genres.map(lambda x: x.split(",")[0])
log("Removed secondary genres and assigned primary genre to genre column.")

df.drop(["genres"], axis=1)
log("Dropped genres column")

df_subset = df.iloc[:5, :]
print(df.tconst.nunique())

# Remove invalid records in title.principals
clean_file(df,
           title_principals,
           get_column_index(title_principals,
                            "tconst"),
           "title_principals.csv")

# Remove invalid records in title.akas
clean_file(df,
           title_akas,
           get_column_index(title_akas,
                            "titleId"),
           "title_akas.csv"
           )

# Split into title.basics from df
title_basics_columns = ["tconst",
                        "titleType",
                        "primaryTitle",
                        "originalTitle",
                        "isAdult",
                        "startYear",
                        "endYear",
                        "runtimeMinutes"]
df_title_basics = df[title_basics_columns]

# Split title.ratings from df
title_rating_columns = ["tconst",
                        "averateRating",
                        "numVotes"]
df_title_ratings = df[title_rating_columns]


# Write to csv file
df.to_csv(get_destination_path("consolidated_data.csv"),
                index=False,
                header=True)
log("Stored clean data as consolidated_data.csv")

df_subset.to_csv(get_destination_path("consolidated_data_subset.csv"),
                                index=False,
                                header=True)
log("Stored clean subset data as consolidated_data_subset.csv")
