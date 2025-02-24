CREATE DATABASE sentiment_db;
USE sentiment_db;

CREATE TABLE reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text TEXT NOT NULL,
    sentiment VARCHAR(10) NOT NULL
);
