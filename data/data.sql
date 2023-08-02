create database shopG3;
use shopG3;
create  table role(
                      id int primary key default 0,
                      name varchar(20) check(name='admin' or name='user')
);
CREATE TABLE account
(
    uID     INT AUTO_INCREMENT PRIMARY KEY,
    user    VARCHAR(255) not null ,
    pass    VARCHAR(255) not null ,
    address varchar(255) not null,
    tel int null ,
    role_id int not null,
    foreign key (role_ID) references role(id)
);
CREATE TABLE category
(
    cID   INT         NOT NULL primary key,
    cname VARCHAR(50) NOT NULL
);
CREATE TABLE product
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255) not null,
    detailName varchar(255) not null ,
    image   text         NULL,
    price   double       not null,
    color   VARCHAR(255) not null,
    size    int not null,
    cateID  INT          not null,
    quantity int not null,
    foreign key (cateID) references category (cID)
);
create table cart
(
    accountID int null,
    productID INT NOT NULL,
    amount    int null,
    foreign key (accountID) references account (uID),
    foreign key (productID) references product (id)
);
create table orderDetail
(
    date       DATE   not null,
    totalPrice double not null,
    productID  int    not null,
    accountID  int    null,
    foreign key (accountID) references account (uID),
    foreign key (productID) references product (id)
);
insert into role(id,name) values (1,'admin');
insert into role(id,name) values (0,'user');
INSERT into category(cID, cname)
VALUES (1, N'GIÀY ADIDAS');
INSERT into account (uID, user, pass,address,tel, role_id)
VALUES (1, 'admin', 'admin', '124A Trương Định',0953253453,1);
INSERT into account (user, pass, address,tel,role_id)
VALUES ('user', 'user', '125A Bà triệu',0924252344,0);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Giày thể thao','Giày thể thao nam Adidas Nova Run',
        'https://canary.contestimg.wish.com/api/webimage/5f5ad3f3706bf3003d7acbd3-normal.jpg?cache_buster=10f7d3b88daf4019fa9d8be157793111',
        100.0000, 'Màu đỏ', '39',10, 1);
