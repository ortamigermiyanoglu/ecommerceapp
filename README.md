# dolapcodecase

-- CREATE DATABASE, TABLES AND INITIAL DATA MIGRATION --

in mysql server create schema under root user with following:

 --> create schema dolapcodecase default charset utf8 collate utf8_general_ci;

in the project directory run the following command to create tables and migrate initial data:

 --> mvn liquibase:update
