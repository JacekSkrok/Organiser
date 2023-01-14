create table TODOS (
    ID int unsigned primary key auto_increment,
    content varchar(100) not null,
    status bit
);