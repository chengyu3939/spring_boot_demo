import pymysql
conn = pymysql.connect(host='redis.space', port=3306, user='root', passwd='machao0701', db='mysql')
cur=conn.cursor()
cur.execute('select * from user')
for r in \
        cur.fetchall():
    print(r)

conn.close()
