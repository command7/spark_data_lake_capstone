import pandas as import pd

def get_file_path(tsv_file_name):
    return f"../../Data.nosync/{tsv_file_name}"

def open_file(tsv_file_name):
    file_df = pd.read_csv(get_file_path(tsv_file_name), sep="\t")
    return file_df

def get_destination_path(tsv_file_name):
    return f"Data.nosync/{tsv_file_name}"

title_basics = open_file("title.basics.tsv")
title_crew = open_file("title.crew.tsv")
name_basics = open_file("name.basics.tsv")
title_ratings = open_file("title.ratings.tsv")

# Merging title names with their director and writer identifiers
final_df = pd.merge(left=title_basics,
                    right=title_crew,
                    how="left",
                    on="tconst")

# Merging to obtain director details
final_df = pd.merge(left=final_df,
                    right=name_basics,
                    how="left",
                    left_on="directors",
                    right_on="nconst",
                    suffixes=("", "_director"))

# Merging to obtain writer details
final_df = pd.merge(left=final_df,
                    right=name_basics,
                    how="left",
                    left_on="writers",
                    right_on="nconst",
                    suffixes=("_director", "_writer"))

# Merging to obtain title ratings
final_df = pd.merge(left=final_df,
                    right=title_ratings,
                    on="tconst",
                    how="left")

# Remove records that do not have a rating
final_df = final_df[final_df.averageRating.notna()]

# Remove rows with missing genres
final_df = final_df[final_df.genres.notna()]

# Remove rows with \\N as value
final_df = final_df[final_df.genres != "\\N"]

# Retrieve primary genre for all genres
final_df["genre"] = df.genres.map(lambda x: x.split(",")[0])
final_df.drop(["genres"], axis=1)

# Write to csv file
final_df.to_csv(get_file_path("consolidated_data.csv"),
                index=False,
                header=True)
