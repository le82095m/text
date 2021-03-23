drop database if exists myServletData;

create database myServletData character set utf8mb4;

use myServletData;

create table user(
    id int primary key auto_increment,
    username varchar(20) not null unique,
    password varchar(20) not null,
    nickname varchar(20),
    head varchar(20),
    sex bit,
    birthday date
);

create table article(
    id int primary key auto_increment,
    title varchar(100) not null,
    content mediumtext not null,
    date timestamp default now(),
    view_count int default 0,
    user_id int,
    foreign key (user_id) references user(id)
);

insert into user(username, password) value
    ('a','1'),
    ('b','2'),
    ('c','3');

insert into article(title,content,user_id) value
    ('插入排序','扑克牌，比较插入',1),
    ('希尔排序','多次分组，组内插入',1),
    ('选择排序','遍历找最值，放到有序端',1),
    ('堆排排序','建堆，找最值，放有序，向下调整',2),
    ('冒泡排序','逐次遍历，两两比较，大的在后，放入有序',2),
    ('快速排序','逐次遍历，与每组第一个数比较，小的在左，大的在有，再次分组',2);


select id, username, password, nickname, head, sex, birthday from user where username = 'abc';

select id,title from article where user_id = 1;