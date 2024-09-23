-- liquibase formatted sql


-- changeset user1:1

CREATE TABLE users1 (
    id SERIAL,
    chatId int,
    message text,
    dataTime text
)