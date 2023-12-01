CREATE TABLE IF NOT EXISTS category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    category varchar(30) NOT NULL
); 
INSERT INTO category (category) VALUES ("shirt");
INSERT INTO category (category) VALUES ("pants");
INSERT INTO category (category) VALUES ("shoes");

CREATE TABLE IF NOT EXISTS items(
    id INT PRIMARY KEY AUTO_INCREMENT,
    item_name varchar(255) NOT NULL,
    item_price int NOT NULL,
    category_id int NOT NULL,
    item_image varchar(255) NOT NULL,
    item_description varchar(255),
    FOREIGN KEY (category_id) REFERENCES category(id)
);


INSERT INTO items (item_name,item_price,item_image,category_id,item_description) VALUES ('shirt',200,'assets\images\img-1.jpg',2,'Denim Shirts 2 in 1');
INSERT INTO items (item_name,item_price,item_image,category_id,item_description) VALUES ('shirt',250,'assets\images\img-2.jpg',2,'Casual shirt');
INSERT INTO items (item_name,item_price,item_image,category_id,item_description) VALUES ('shirt',200,'assets\images\img-3.jpg',2,'Leather blue');
INSERT INTO items (item_name,item_price,item_image,category_id,item_description) VALUES ('shirt',200,'assets\images\img-4.jpg',2,'High fashion');
INSERT INTO items (item_name,item_price,item_image,category_id,item_description) VALUES ('shirt',100,'assets\images\img-5.jpg',2,'Dolce and Garbana');
