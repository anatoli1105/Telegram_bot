-- liquibase formatted sql


-- changeset im:1

CREATE TABLE notification_task (
    id SERIAL,
    chatId integer,
    message text,
    dataTime text
)