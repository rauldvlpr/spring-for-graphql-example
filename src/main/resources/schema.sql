CREATE TABLE IF NOT EXISTS author
(
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS book
(
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(255),
    page_count INTEGER,
    author_id  INTEGER,
    FOREIGN KEY (author_id) REFERENCES author (id)
);

INSERT INTO author (first_name, last_name)
VALUES ('Martin', 'Kleppmann');

INSERT INTO book (name, page_count, author_id)
VALUES ('Designing Data-Intensive Applications', 616, 1);