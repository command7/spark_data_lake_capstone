import pandas as pd
import pymysql
#
# df = pd.read_csv("../Data/title_basics.csv",
#                   low_memory=False)
# unique_tconsts = list(df.tconst.unique())
# del df
#
db_connection = pymysql.connect(host="localhost",
                                user="root",
                                password="student",
                                db="imdb_capstone",
                                autocommit=True)
db_cursor = db_connection.cursor()
#
# drop_imdb_stats_sql = "DROP TABLE IF EXISTS imdb_stats"
# create_imdb_stats_sql = "CREATE TABLE IF NOT EXISTS imdb_stats (tconst varchar(20) PRIMARY KEY)"
# insert_imdb_stats_sql = "INSERT INTO `imdb_stats` (`tconst`) VALUES (%s)"
#
# db_cursor.execute(drop_imdb_stats_sql)
# db_cursor.execute(create_imdb_stats_sql)
#
# for each_tconst in unique_tconsts:
#     db_cursor.execute(insert_data_sql, (each_tconst))

drop_name_stats_sql = "DROP TABLE IF EXISTS name_stats"
create_name_stats_sql =  """
CREATE TABLE IF NOT EXISTS name_stats (
    tconst varchar(20),
    nconst varchar(20),
    PRIMARY KEY (tconst, nconst)
)
"""
insert_name_stats_sql = "INSERT INTO `name_stats` (`tconst`, `nconst`) VALUES (%s, %s)"

df = pd.read_csv("../Data/title_principals.csv",
                  low_memory=False)
nconst_tconst_couples = df[["tconst", "nconst"]].to_numpy()

combo_uniques = set()
for each_couple in nconst_tconst_couples:
    combo_uniques.add(tuple(each_couple))

del df

db_cursor.execute(drop_name_stats_sql)
db_cursor.execute(create_name_stats_sql)

for tconst, nconst in combo_uniques:
    db_cursor.execute(insert_name_stats_sql, (tconst, nconst))


