-- liquibase formatted sql


-- changelog student5:1
create table Notification_task(
id serial,
chatId int,
dateTime int8,
massage text
)



