
 drop table if exists `sys_book`;  
 create table `sys_book`  ( 
 `id` int(11) not null auto_increment primary key, 
 `bookname` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `author` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `introduction` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `press` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `category` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `coverurl` varchar(255) character set utf8 collate utf8_general_ci default null 
 ) engine = innodb auto_increment = 1 character set = utf8 collate = utf8_general_ci;

 drop table if exists `sys_carousel`;  
 create table `sys_carousel`  ( 
 `id` int(11) not null auto_increment primary key, 
 `admin_id` int, 
 `image_info` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `enable` int, 
 `imageurl` varchar(255) character set utf8 collate utf8_general_ci default null 
 ) engine = innodb auto_increment = 1 character set = utf8 collate = utf8_general_ci;

 drop table if exists `sys_cart`;  
 create table `sys_cart`  ( 
 `id` int(11) not null auto_increment primary key, 
 `buy_id` int, 
 `inventory_id` int, 
 `count` int, 
 `address` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `connection` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `name` varchar(255) character set utf8 collate utf8_general_ci default null 
 ) engine = innodb auto_increment = 1 character set = utf8 collate = utf8_general_ci;

 drop table if exists `sys_file`;  
 create table `sys_file`  ( 
 `id` int(11) not null auto_increment primary key, 
 `filename` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `filetype` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `filesize` integer unsigned, 
 `fileurl` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `md5` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `is_delete` bit, 
 `enable` bit 
 ) engine = innodb auto_increment = 1 character set = utf8 collate = utf8_general_ci;

 drop table if exists `sys_inventory`;  
 create table `sys_inventory`  ( 
 `id` int(11) not null auto_increment primary key, 
 `shop_id` int, 
 `book_id` int, 
 `stock` int, 
 `price` float, 
 `discount` float, 
 `enable` int 
 ) engine = innodb auto_increment = 1 character set = utf8 collate = utf8_general_ci;

 drop table if exists `sys_selldata`;  
 create table `sys_selldata`  ( 
 `id` int(11) not null auto_increment primary key, 
 `shop_id` int, 
 `buy_id` int, 
 `book_id` int, 
 `price` float, 
 `count` int, 
 `is_pay` int, 
 `is_sent` int, 
 `express_id` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `address` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `connection` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `name` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `create_time` datetime 
 ) engine = innodb auto_increment = 1 character set = utf8 collate = utf8_general_ci;

 drop table if exists `test_sys_shop`;  
 create table `test_sys_shop`  ( 
 `id` int(11) not null auto_increment primary key, 
 `username` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `password` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `shopname` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `email` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `phone` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `address` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `pictureurl` varchar(255) character set utf8 collate utf8_general_ci default null 
 ) engine = innodb auto_increment = 1 character set = utf8 collate = utf8_general_ci;

 drop table if exists `sys_user`;  
 create table `sys_user`  ( 
 `id` int(11) not null auto_increment primary key, 
 `username` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `password` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `nickname` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `email` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `phone` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `address` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `avatarurl` varchar(255) character set utf8 collate utf8_general_ci default null, 
 `role` int 
 ) engine = innodb auto_increment = 1 character set = utf8 collate = utf8_general_ci;
