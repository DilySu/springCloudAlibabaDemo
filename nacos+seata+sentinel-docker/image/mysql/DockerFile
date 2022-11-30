FROM mysql:8.0.30
ADD https://raw.githubusercontent.com/alibaba/nacos/develop/distribution/conf/mysql-schema.sql /docker-entrypoint-initdb.d/nacos-mysql-seata.sql
RUN chown -R mysql:mysql /docker-entrypoint-initdb.d/nacos-mysql-seata.sql
EXPOSE 3306
CMD ["mysqld", "--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci"]