CREATE TABLE tt_book
(
    id UUID NOT NULL,
    version BIGINT NOT NULL,
    title VARCHAR NOT NULL,
    author VARCHAR NOT NULL,
    genre VARCHAR NOT NULL,
    publisher VARCHAR NOT NULL,
    publishing_year INTEGER NOT NULL,
    PRIMARY KEY (id)
)