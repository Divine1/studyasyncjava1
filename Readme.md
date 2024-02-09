docker pull mysql

docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag

docker run -e MYSQL_ROOT_PASSWORD=test -p 3306:3306 -d mysql:latest
docker run -e MYSQL_ROOT_PASSWORD=test -p 33060:33060 -p 3306:3306 -d mysql:latest

docker exec -it 71f31c2cec7c bash

mysql -u root -p
test



create database test;
use test;
CREATE TABLE Person(
id INT(6) PRIMARY KEY,
firstname VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL
);

INSERT INTO Person VALUES ( 1,"John","Doe");
INSERT INTO Person VALUES (2, "Daniel","Jones");
INSERT INTO Person VALUES (3, "Cyril", "Gane");
INSERT INTO Person VALUES (4, "Max", "Holl");


mysql x dev api - nonblocking approach
https://dev.mysql.com/doc/x-devapi-userguide/en/

3306 handles blocking connections
33060 handles nonblocking connections - uses x protocol




https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/8.0.33

https://dev.mysql.com/doc/x-devapi-userguide/en/database-connection-example.html

