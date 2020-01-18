
CREATE SCHEMA shortener
CREATE TABLE shortener.SHORT_LINK (
  id serial  primary key,
  short_url varchar(100) DEFAULT NULL,
  long_url varchar(100) DEFAULT NULL
);
