FROM postgres:9.6
RUN apt-get update && apt-get install nano

ENV POSTGRES_USER achraf
ENV POSTGRES_PASSWORD achraf
ENV POSTGRES_DB shortenerDB

COPY init_table.sql       /docker-entrypoint-initdb.d/init_table.sql

COPY postgresql.conf      /tmp/postgresql.conf
COPY updateConfig.sh      /docker-entrypoint-initdb.d/_updateConfig.sh