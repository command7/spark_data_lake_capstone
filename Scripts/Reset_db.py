import pandas as pd
import pymysql

df = pd.read_csv("../Data/title_basics.csv",
                  low_memory=False)
unique_tconsts = list(df.tconst.unique())
del df

db_connection = pymysql.connect(host="localhost",
                                user="root",
                                password="student",
                                db="imdb_capstone",
                                autocommit=True)
db_cursor = db_connection.cursor()

drop_table_sql = "DROP TABLE IF EXISTS imdb_stats"
create_table_sql = "CREATE TABLE IF NOT EXISTS imdb_stats (tconst varchar(20) PRIMARY KEY)"
insert_data_sql = "INSERT INTO `imdb_stats` (`tconst`) VALUES (%s)"

db_cursor.execute(drop_table_sql)
db_cursor.execute(create_table_sql)

for each_tconst in unique_tconsts:
    db_cursor.execute(insert_data_sql, (each_tconst))



