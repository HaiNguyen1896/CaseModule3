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
    customerName varchar(255) not null ,
    address varchar(255) not null,
    tel varchar(255) null ,
    role_id int not null,
    foreign key (role_ID) references role(id)
);
CREATE TABLE category
(
    cID   INT         NOT NULL auto_increment primary key,
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
    size    varchar(255) not null,
    cateID  INT          not null,
    quantity int not null,
    foreign key (cateID) references category (cID)
);

create table orders(
                       name varchar(255) null ,
                       userID int not null,
                       id int auto_increment primary key ,
                       status boolean not null ,
                       foreign key (userID) references account(uID)
);

create table orderDetail
(
    id int auto_increment primary key not null ,
    date       datetime   default CURRENT_TIMESTAMP,
    quantity int not null,
    totalPrice double not null,
    productID  int    not null,
    orderID  int    not null ,
    foreign key (orderID) references orders (id),
    foreign key (productID) references product(id)
);

insert into role(id,name) values (1,'admin');
insert into role(id,name) values (0,'user');
INSERT into category(cname)VALUES ('ÁO THUN');
INSERT into category(cname)VALUES ('ÁO POLOS');
INSERT into category(cname)VALUES ('ÁO SƠ MI');
INSERT into category(cname)VALUES ('ÁO KHOÁC');
INSERT into account (uID, user, pass,customerName,address,tel, role_id)
VALUES (1, 'admin', 'admin','Đoàn Hữu Linh' ,'124A Trương Định','0953253453',1);
INSERT into account (user, pass,customerName, address,tel,role_id)
VALUES ('user', 'user','Trịnh Việt Anh' ,'125A Bà triệu','0924252344',0);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo thun','Áo thun họa tiết Old Sailor - O.S.L Tennis tee',
        'https://oldsailor.com.vn/vnt_upload/product/08_2023/5ad50238abdc788221cd27.jpg',
        325000, 'Màu đen', 'upTo 5XL',10, 1);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo thun','Áo thun họa tiết Old Sailor - O.S.L Tennis tee',
        'https://oldsailor.com.vn/vnt_upload/product/08_2023/5f1613fcba186946300928.jpg',
        325000, 'Màu trắng', 'upTo 5XL',10, 1);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo thun','Áo thun đá nam Old Sailor - O.S.L Washed tee',
        'https://oldsailor.com.vn/vnt_upload/product/07_2023/2.jpg',
        325000, 'Màu ghi', 'upTo 5XL',10, 1);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo thun','Áo thun nam họa tiết Old Sailor - VELVET PRINTED TEE',
        'https://oldsailor.com.vn/vnt_upload/product/06_2023/c8ccde319064413a18756.jpg',
        325000, 'Màu đen', 'upTo 5XL',10, 1);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo Polo','Áo Polo phối màu Old Sailor - O.S.L TRIP POLO',
        'https://oldsailor.com.vn/vnt_upload/product/07_2023/51b14f6a007fd3218a6e14.jpg',
        365000, 'Màu xanh đen', 'upTo 5XL',10, 2);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo Polo','Áo polo phối màu Old Sailor - O.S.L COLOR TRIP POLO',
        'https://oldsailor.com.vn/vnt_upload/product/07_2023/bdac90a81bbdc8e391ac37.jpg',
        325000, 'Màu nâu', 'upTo 5XL',10, 2);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo sơ mi','Áo sơ mi nam tay ngắn OldSailor - O.S.L KAKI SHIRT',
        'https://oldsailor.com.vn/vnt_upload/product/07_2023/bdac90a81bbdc8e391ac37.jpg',
        375000, 'Màu xanh đen', 'upTo 5XL',10, 3);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo sơ mi','Áo sơ mi nam vải bamboo Old Sailor - O.S.L PREMIUM BAMBOO SHIRT',
        'https://oldsailor.com.vn/vnt_upload/product/07_2023/dc90c1bcdd4b0d15545a.jpg',
        310000, 'Màu đen', 'upTo 5XL',10, 3);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo khoác','Áo khoác dù nam Old Sailor - O.S.L PREMIUM WIND BREAKER JACKET',
        'https://oldsailor.com.vn/vnt_upload/product/07_2023/e2d5acf154c98797ded82.jpg',
        310000, 'Màu ghi', 'upTo 5XL',10, 4);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo khoác','Áo khoác blazer Old Sailor - O.S.L PREMIUM BLAZER',
        'https://oldsailor.com.vn/vnt_upload/product/07_2023/e2d5acf154c98797ded82.jpg',
        310000, 'Màu đen', 'upTo 5XL',10, 4);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo khoác','Áo khoác blazer Old Sailor - O.S.L PREMIUM BLAZER',
        'https://oldsailor.com.vn/vnt_upload/product/06_2023/5a8a38deef963fc8668714.jpg',
        310000, 'Màu đen', 'upTo 5XL',10, 4);
INSERT into product (name,detailName, image, price, color, size,quantity, cateID)
VALUES ('Áo khoác','Áo khoác nam lót dù Old Sailor - OSL PREMIUM TICKE BOMBER',
        'https://oldsailor.com.vn/vnt_upload/product/12_2022/57790926f5372d697426.jpg',
        310000, 'Màu nâu', 'upTo 5XL',10, 4);

