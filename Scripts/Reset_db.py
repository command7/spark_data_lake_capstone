import pymysql
import csv

drop_name_stats_sql = "DROP TABLE IF EXISTS name_stats"
create_name_stats_sql =  """
CREATE TABLE IF NOT EXISTS name_stats (
    tconst varchar(20),
    nconst varchar(20),
    PRIMARY KEY (tconst, nconst)
)
"""
drop_imdb_stats_sql = "DROP TABLE IF EXISTS imdb_stats"
create_imdb_stats_sql = "CREATE TABLE IF NOT EXISTS imdb_stats (tconst varchar(20) PRIMARY KEY)"
insert_imdb_stats_sql = "INSERT INTO `imdb_stats` (`tconst`) VALUES (%s)"
insert_name_stats_sql = "INSERT INTO `name_stats` (`tconst`, `nconst`) VALUES (%s, %s)"


unique_tconsts = set()
with open("../Data/title_basics_sampled.csv") as title_basics_file:
    title_basics_reader = csv.reader(title_basics_file, delimiter=",")
    for each_id_row in title_basics_reader:
        unique_tconsts.add(each_id_row[0])

print("Unique tconsts gathered")


db_connection = pymysql.connect(host="localhost",
                                user="root",
                                password="rootstudent",
                                db="imdb_capstone",
                                autocommit=True)
db_cursor = db_connection.cursor()



db_cursor.execute(drop_imdb_stats_sql)
db_cursor.execute(create_imdb_stats_sql)

for each_tconst in unique_tconsts:
    db_cursor.execute(insert_imdb_stats_sql, (each_tconst))

print("Filled imdb_stats table")



print("\n\n Starting to fill name_stats")

unique_principal_rows = set()
with open("../Data/title_principals_sampled.csv") as title_principals_file:
    title_principals_reader = csv.reader(title_principals_file, delimiter=",")
    for each_id_row in title_principals_reader:
        unique_principal_rows.add((each_id_row[0], each_id_row[2]))

print("Found unique tconst nconst rows")

db_cursor.execute(drop_name_stats_sql)
db_cursor.execute(create_name_stats_sql)

for tconst, nconst in unique_principal_rows:
    db_cursor.execute(insert_name_stats_sql, (tconst, nconst))

print("Filled name_stats table")
