
--


CREATE TABLE brands (
  id serial,
  brand varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE categories (
  id serial,
  category varchar(45) NOT NULL DEFAULT 'name category',
  description varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
--   UNIQUE KEY category_UNIQUE (category)
);

CREATE TABLE suppliers (
  id serial,
  supplier VARCHAR(50) NOT NULL,
  address VARCHAR(50),
  contacts VARCHAR(50),
  PRIMARY KEY (id)
  );

CREATE TABLE products (
  id serial,
  category_id integer NOT NULL,
  brand_id integer DEFAULT NULL,
  product varchar(45) NOT NULL,
  price decimal(10,2) DEFAULT '0.00',
  description varchar(100) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_brand FOREIGN KEY (brand_id) REFERENCES brands (id) ON UPDATE CASCADE,
  CONSTRAINT FK_category FOREIGN KEY (category_id) REFERENCES categories (id) ON UPDATE CASCADE
);

CREATE TABLE actions (
  id serial,
  action_date timestamp NOT NULL,
  product_id integer NOT NULL,
  supplier_id integer NOT NULL,
  qty decimal(10,3) NOT NULL DEFAULT '0.000',
  price decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (id),
  CONSTRAINT FK_product FOREIGN KEY (product_id) REFERENCES products (id),
  CONSTRAINT FK_supplier FOREIGN KEY (supplier_id) REFERENCES suppliers (id)
);

-- Вставка категорий товаров
INSERT into categories (category, description) VALUES ('HDD', 'Жесткие диски');
INSERT into categories (category, description) VALUES ('Monitors', 'Мониторы');
INSERT into categories (category, description) VALUES ('Motherboards', 'Материнские платы');
INSERT into categories (category, description) VALUES ('DDR', 'Оперативная память');
--INSERT into categories (category, description) VALUES ('Smartphones', 'Смартфоны');

-- Вставка брендов
INSERT into brands (brand) VALUES ('Samsung');
INSERT into brands (brand) VALUES ('ASUS');
INSERT into brands (brand) VALUES ('Acer');

-- Вставка поставщиков
INSERT into suppliers (supplier, address, contacts) VALUES ('Silk Road','Shanghai 6-7/115','mr.Lee p:234-177-123-456-6');
INSERT into suppliers (supplier, address, contacts) VALUES ('Cargo Transfer','Shanghai, Mao av. 899-1201', Null);
INSERT into suppliers (supplier, address, contacts) VALUES ('4U','Urumchi','');
INSERT into suppliers (supplier, address, contacts) VALUES ('IDT','Beijing','');

-- Вставка товара 1
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='HDD'),
(SELECT id FROM brands where brand='Samsung'),
'S1 HDD 1T, 7200 rpm', 125, '');
-- Вставка товара 2
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='HDD'),
(SELECT id FROM brands where brand='Samsung'),
'S2 HDD 500Gb, 7200 rpm', 85, '');
-- Вставка товара 3
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='HDD'),
(SELECT id FROM brands where brand='Samsung'),
'S3 HDD 250Gb, 10000 rpm', 150, '');
-- Вставка товара 4
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='HDD'),
(SELECT id FROM brands where brand='Samsung'),
'S4 HDD 1T, 7200rpm', 127, '');
-- Вставка товара 5
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='HDD'),
(SELECT id FROM brands where brand='Samsung'),
'S5 HDD 500Gb, 7200rpm', 92, '');
-- Вставка товара 6
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='HDD'),
(SELECT id FROM brands where brand='Acer'),
'Z1 HDD 750Gb, 72000rpm', 100, '');
-- Вставка товара 7
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='HDD'),
(SELECT id FROM brands where brand='Acer'),
'Z2 HDD 750Gb, 72000rpm', 110, '');
-- Вставка товара 8
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='HDD'),
NULL, 'UN1 HDD 750Gb, 72000rpm', 105, '');
-- Вставка товара 9
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Monitors'),
(SELECT id FROM brands where brand='Samsung'),
'Monitor B19', 135, '');
-- Вставка товара 10
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Monitors'),
(SELECT id FROM brands where brand='Samsung'),
'Monitor B22', 170, '');
-- Вставка товара 11
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Monitors'),
(SELECT id FROM brands where brand='Samsung'),
'Monitor B25', 320, '');
-- Вставка товара 12
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Monitors'),
(SELECT id FROM brands where brand='Acer'),
'Monitor A20', 150, '');
-- Вставка товара 13
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Monitors'),
(SELECT id FROM brands where brand='Acer'),
'Monitor A21', 170, '');
-- Вставка товара 14
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Monitors'),
(SELECT id FROM brands where brand='ASUS'),
'Monitor DD27', 370, '');
-- Вставка товара 15
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='DDR'),
(SELECT id FROM brands where brand='Samsung'),
'DDR3 SST 2Gb', 25, '');
-- Вставка товара 16
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='DDR'),
(SELECT id FROM brands where brand='Samsung'),
'DDR3 SST 4Gb', 42, '');
-- Вставка товара 17
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='DDR'),
(SELECT id FROM brands where brand='ASUS'),
'DDR3 BTT 4Gb', 48, '');
-- Вставка товара 18
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='DDR'),
(SELECT id FROM brands where brand='ASUS'),
'DDR3 BTT 8Gb', 90, '');
-- Вставка товара 19
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='DDR'),
(SELECT id FROM brands where brand='ASUS'),
'DDR3 ZPP 4Gb', 45, '');
-- Вставка товара 20
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='DDR'),
NULL,'DDR3 UNK 2Gb', 24, '');
-- Вставка товара 21
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='DDR'),
NULL,'DDR2 UNK 1Gb', 17, '');
-- Вставка товара 22
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Motherboards'),
(SELECT id FROM brands where brand='Samsung'),
'MB-1', 75, '');
-- Вставка товара 23
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Motherboards'),
(SELECT id FROM brands where brand='Samsung'),
'MB-2', 76, '');
-- Вставка товара 24
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Motherboards'),
(SELECT id FROM brands where brand='ASUS'),
'MB-3', 80, '');
-- Вставка товара 25
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Motherboards'),
(SELECT id FROM brands where brand='ASUS'),
'MB-4', 95, '');
-- Вставка товара 26
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Motherboards'),
(SELECT id FROM brands where brand='ASUS'),
'MB-5', 160, '');
-- Вставка товара 27
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Motherboards'),
(SELECT id FROM brands where brand='Acer'),
'MB-6', 180, '');
-- Вставка товара 28
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Motherboards'),
(SELECT id FROM brands where brand='Acer'),
'MB-7', 200, '');
-- Вставка товара 29
INSERT into products (category_id, brand_id, product, price, description)
VALUES ((SELECT id FROM categories where category='Motherboards'),
NULL, 'MB-8', 250, '');

-- Silk Road
--Вставка поступлений товара actions 1
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-25 12:30:33',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
100, -- qty
110);
--Вставка поступлений товара actions 2
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-25 12:30:33',
(select id from products where product='S5 HDD 500Gb, 7200rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
80, -- qty
95);
--Вставка поступлений товара actions 3
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-25 12:30:33',
(select id from products where product='UN1 HDD 750Gb, 72000rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
48, -- qty
84);
--Вставка поступлений товара actions 4
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-25 12:30:33',
(select id from products where product='Monitor B25'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
16, -- qty
340);
--Вставка поступлений товара actions 5
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-30 09:30:00',
(select id from products where product='Monitor B25'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
10, -- qty
345);
--Вставка поступлений товара actions 6
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-30 09:30:00',
(select id from products where product='DDR3 SST 2Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
50, -- qty
40);
--Вставка поступлений товара actions 7
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-30 09:30:00',
(select id from products where product='DDR3 SST 4Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
40, -- qty
55);
--Вставка поступлений товара actions 8
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-14 15:30:00',
(select id from products where product='DDR3 BTT 4Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
50, -- qty
60);
--Вставка поступлений товара actions 9
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-14 15:30:00',
(select id from products where product='S5 HDD 500Gb, 7200rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
50, -- qty
98);
--Вставка поступлений товара actions 10
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-20 10:05:00',
(select id from products where product='Monitor DD27'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
10, -- qty
330);
--13.02.2021
--Вставка поступлений товара actions 11
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-25 12:15:00',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
50, -- qty
115);
--Вставка поступлений товара actions 12
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-25 12:15:00',
(select id from products where product='DDR3 BTT 4Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
15, -- qty
86);
--Вставка поступлений товара actions 13
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-25 12:15:00',
(select id from products where product='S4 HDD 1T, 7200rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
25, -- qty
117);
--Вставка поступлений товара actions 14
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-25 14:33:00',
(select id from products where product='S4 HDD 1T, 7200rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
25, -- qty
117);
--Вставка поступлений товара actions 15
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-10-04 12:50:00',
(select id from products where product='S1 HDD 1T, 7200 rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
30, -- qty
121);
--Вставка поступлений товара actions 16
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-10-27 09:18:00',
(select id from products where product='S4 HDD 1T, 7200rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
5, -- qty
125);
--Вставка поступлений товара actions 17
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-12-11 09:20:00',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
10, -- qty
143);
--Вставка поступлений товара actions 18
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-02-07 09:43:00',
(select id from products where product='DDR3 BTT 4Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
51, -- qty
43);
--Вставка поступлений товара actions 19
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-03-12 09:21:00',
(select id from products where product='DDR3 SST 2Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
70, -- qty
18);
--Вставка поступлений товара actions 20
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-06-28 08:55:00',
(select id from products where product='DDR3 SST 4Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
35, -- qty
36);
--Вставка поступлений товара actions 21
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-07-15 10:02:00',
(select id from products where product='Monitor A20'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
20, -- qty
135);
--Вставка поступлений товара actions 22
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-07-16 09:57:00',
(select id from products where product='S1 HDD 1T, 7200 rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
45, -- qty
116);
--Вставка поступлений товара actions 23
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-09-15 09:15:00',
(select id from products where product='Monitor A20'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
5, -- qty
142);
--Вставка поступлений товара actions 24
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-09-20 10:03:00',
(select id from products where product='S2 HDD 500Gb, 7200 rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
13, -- qty
74);
--Вставка поступлений товара actions 25
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-10-02 11:10:00',
(select id from products where product='Monitor B19'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
24, -- qty
121);
--Вставка поступлений товара actions 26
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-10-23 10:02:00',
(select id from products where product='DDR3 BTT 8Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
55, -- qty
79);
--Вставка поступлений товара actions 27
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-10-23 10:03:00',
(select id from products where product='Monitor B25'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
6, -- qty
295);
--Вставка поступлений товара actions 28
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-10-23 10:04:00',
(select id from products where product='S4 HDD 1T, 7200rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
100, -- qty
108);
--Вставка поступлений товара actions 29
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-11-11 09:44:00',
(select id from products where product='DDR3 ZPP 4Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
75, -- qty
31);
--Вставка поступлений товара actions 30
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-12-17 11:00:00',
(select id from products where product='DDR3 BTT 8Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
20, -- qty
77);
--Вставка поступлений товара actions 31
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-12-20 08:50:00',
(select id from products where product='DDR3 BTT 4Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
12, -- qty
40);
--Вставка поступлений товара actions 32
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-01-12 11:01:00',
(select id from products where product='Monitor DD27'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
10, -- qty
340);
--Вставка поступлений товара actions 33
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-01-12 11:02:00',
(select id from products where product='DDR3 BTT 8Gb'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
25, -- qty
76);
--Вставка поступлений товара actions 34
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-01-12 11:03:00 ',
(select id from products where product='S1 HDD 1T, 7200 rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
37, -- qty
115);
--Вставка поступлений товара actions 35
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-02-25 13:50:00',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
50, -- qty
128);
--Вставка поступлений товара actions 36
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-02-26 09:30:00',
(select id from products where product='Monitor B25'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
19, -- qty
302);
--Вставка поступлений товара actions 37
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-02-27 09:36:00',
(select id from products where product='S4 HDD 1T, 7200rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
11, -- qty
119);
--Вставка поступлений товара actions 38
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-03-02 09:44:00',
(select id from products where product='S5 HDD 500Gb, 7200rpm'), -- product
(select id from suppliers where supplier='Silk Road'), -- supplier
40, -- qty
80);

--Cargo Transfer
--Вставка поступлений товара actions 39
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-26 08:30:00',
(select id from products where product='MB-1'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
25, -- qty
76);
--Вставка поступлений товара actions 40
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-26 08:30:00',
(select id from products where product='MB-2'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
15, -- qty
79);
--Вставка поступлений товара actions 41
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-26 08:30:00',
(select id from products where product='MB-3'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
20, -- qty
85);
--Вставка поступлений товара actions 42
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-26 08:30:00',
(select id from products where product='MB-4'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
23, -- qty
88);
--Вставка поступлений товара actions 43
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-26 08:30:00',
(select id from products where product='MB-5'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
10, -- qty
94);
--Вставка поступлений товара actions 44
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-28 08:45:00',
(select id from products where product='MB-2'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
10, -- qty
79);
--Вставка поступлений товара actions 45
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-28 08:45:00',
(select id from products where product='MB-4'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
7, -- qty
89);
--Вставка поступлений товара actions 46
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-07 08:45:00',
(select id from products where product='MB-1'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
30, -- qty
76);
--Вставка поступлений товара actions 47
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-07 08:45:00',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
24, -- qty
105);
--Вставка поступлений товара actions 48
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-13 11:12:00',
(select id from products where product='MB-1'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
10, -- qty
75);
--Вставка поступлений товара actions 49
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-13 11:12:00',
(select id from products where product='MB-4'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
25, -- qty
77);
--13.02.2021
--Вставка поступлений товара actions 50
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-11-20 12:30:00',
(select id from products where product='MB-7'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
17, -- qty
181);
--Вставка поступлений товара actions 51
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-11-20 12:31:00',
(select id from products where product='MB-6'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
6, -- qty
168);
--Вставка поступлений товара actions 52
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-04-03 11:25:00',
(select id from products where product='MB-2'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
50, -- qty
57);
--Вставка поступлений товара actions 53
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-04-24 10:35:00',
(select id from products where product='MB-3'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
60, -- qty
63);
--Вставка поступлений товара actions 54
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-07-03 10:45:00',
(select id from products where product='MB-6'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
11, -- qty
169);
--Вставка поступлений товара actions 55
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-07-07 13:07:00',
(select id from products where product='MB-2'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
20, -- qty
70);
--Вставка поступлений товара actions 56
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-07-07 13:08:00',
(select id from products where product='MB-5'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
25, -- qty
144);
--Вставка поступлений товара actions 57
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-07-07 13:09:00',
(select id from products where product='MB-4'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
40, -- qty
81);
--Вставка поступлений товара actions 58
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-07-16 14:02:00',
(select id from products where product='MB-8'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
10, -- qty
236);
--Вставка поступлений товара actions 59
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-08-12 11:37:00',
(select id from products where product='MB-7'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
12, -- qty
180);
--Вставка поступлений товара actions 60
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-08-20 10:04:00',
(select id from products where product='MB-2'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
30, -- qty
68);
--Вставка поступлений товара actions 61
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-09-11 11:14:00',
(select id from products where product='MB-3'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
100, -- qty
62);
--Вставка поступлений товара actions 62
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-10-06 09:57:00',
(select id from products where product='S2 HDD 500Gb, 7200 rpm'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
10, -- qty
74);
--Вставка поступлений товара actions 63
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-10-06 09:59:00',
(select id from products where product='MB-6'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
19, -- qty
159);
--Вставка поступлений товара actions 64
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-10-7 13:20:00',
(select id from products where product='MB-2'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
11, -- qty
77);
--Вставка поступлений товара actions 65
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-10-16 09:48:00',
(select id from products where product='MB-4'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
3, -- qty
91);
--Вставка поступлений товара actions 66
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-10-19 10:06:00',
(select id from products where product='MB-7'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
8, -- qty
188);
--Вставка поступлений товара actions 67
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-10-27 10:45:00',
(select id from products where product='MB-3'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
20, -- qty
72);
--Вставка поступлений товара actions 68
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-02-25 11:12:00',
(select id from products where product='MB-1'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
25, -- qty
63);
--Вставка поступлений товара actions 69
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-03-03 14:25:00',
(select id from products where product='MB-8'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
15, -- qty
234);
--Вставка поступлений товара actions 70
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-03-06 09:52:00',
(select id from products where product='S2 HDD 500Gb, 7200 rpm'), -- product
(select id from suppliers where supplier='Cargo Transfer'), -- supplier
25, -- qty
76);

--4U
--Вставка поступлений товара actions 71
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-25 09:05:00',
(select id from products where product='S1 HDD 1T, 7200 rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
33, -- qty
115);
--Вставка поступлений товара actions 72
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-25 09:05:00',
(select id from products where product='Z1 HDD 750Gb, 72000rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
40, -- qty
90);
--Вставка поступлений товара actions 73
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-26 16:45:00',
(select id from products where product='UN1 HDD 750Gb, 72000rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
100, -- qty
94);
--Вставка поступлений товара actions 74
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-28 09:10:00',
(select id from products where product='S5 HDD 500Gb, 7200rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
80, -- qty
86);
--Вставка поступлений товара actions 75
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-03 14:15:00',
(select id from products where product='DDR3 SST 4Gb'), -- product
(select id from suppliers where supplier='4U'), -- supplier
100, -- qty
34);
--Вставка поступлений товара actions 76
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-03 14:15:00',
(select id from products where product='Monitor DD27'), -- product
(select id from suppliers where supplier='4U'), -- supplier
10, -- qty
345);
--Вставка поступлений товара actions 77
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-13 10:00:00',
(select id from products where product='Monitor DD27'), -- product
(select id from suppliers where supplier='4U'), -- supplier
5, -- qty
345);
--Вставка поступлений товара actions 78
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-13 10:00:00',
(select id from products where product='MB-8'), -- product
(select id from suppliers where supplier='4U'), -- supplier
30, -- qty
235);
--Вставка поступлений товара actions 79
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-15 17:15:00',
(select id from products where product='DDR3 BTT 4Gb'), -- product
(select id from suppliers where supplier='4U'), -- supplier
100, -- qty
39);
--Вставка поступлений товара actions 80
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-16 09:45:00',
(select id from products where product='MB-7'), -- product
(select id from suppliers where supplier='4U'), -- supplier
50, -- qty
180);
--Вставка поступлений товара actions 81
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-16 09:45:00',
(select id from products where product='Monitor DD27'), -- product
(select id from suppliers where supplier='4U'), -- supplier
12, -- qty
350);
--13.02.2021
--Вставка поступлений товара actions 82
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-12-19 09:23:00',
(select id from products where product='Z1 HDD 750Gb, 72000rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
50, -- qty
79);
--Вставка поступлений товара actions 83
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-01-07 10:10:00',
(select id from products where product='Z2 HDD 750Gb, 72000rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
30, -- qty
94);
--Вставка поступлений товара actions 84
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-01-09 10:23:00',
(select id from products where product='DDR3 UNK 2Gb'), -- product
(select id from suppliers where supplier='4U'), -- supplier
25, -- qty
18);
--Вставка поступлений товара actions 85
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-01-23 15:45:00',
(select id from products where product='DDR3 BTT 4Gb'), -- product
(select id from suppliers where supplier='4U'), -- supplier
60, -- qty
39);
--Вставка поступлений товара actions 86
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-01-25 13:17:00',
(select id from products where product='Z1 HDD 750Gb, 72000rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
5, -- qty
101);
--Вставка поступлений товара actions 87
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-02-01 09:45:00',
(select id from products where product='Monitor DD27'), -- product
(select id from suppliers where supplier='4U'), -- supplier
5, -- qty
351);
--Вставка поступлений товара actions 88
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-02-25 09:15:00',
(select id from products where product='MB-8'), -- product
(select id from suppliers where supplier='4U'), -- supplier
20, -- qty
225);
--Вставка поступлений товара actions 89
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-02-25 10:03:00',
(select id from products where product='UN1 HDD 750Gb, 72000rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
16, -- qty
93);
--Вставка поступлений товара actions 90
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-03-09 17:43:00',
(select id from products where product='DDR3 BTT 8Gb'), -- product
(select id from suppliers where supplier='4U'), -- supplier
24, -- qty
75);
--Вставка поступлений товара actions 91
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-03-18 13:06:00',
(select id from products where product='MB-7'), -- product
(select id from suppliers where supplier='4U'), -- supplier
10, -- qty
183);
--Вставка поступлений товара actions 92
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-03-24 11:18:00',
(select id from products where product='Z1 HDD 750Gb, 72000rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
40, -- qty
92);
--Вставка поступлений товара actions 93
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-03-24 11:19:00',
(select id from products where product='Z2 HDD 750Gb, 72000rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
35, -- qty
99);
--Вставка поступлений товара actions 94
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-03-24 11:20:00',
(select id from products where product='DDR3 ZPP 4Gb'), -- product
(select id from suppliers where supplier='4U'), -- supplier
20, -- qty
37);
--Вставка поступлений товара actions 95
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-04-12 15:55:00',
(select id from products where product='UN1 HDD 750Gb, 72000rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
50, -- qty
95);
--Вставка поступлений товара actions 96
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-05-18 13:15:00',
(select id from products where product='MB-8'), -- product
(select id from suppliers where supplier='4U'), -- supplier
1, -- qty
255);
--Вставка поступлений товара actions 97
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-05-18 13:15:00',
(select id from products where product='MB-7'), -- product
(select id from suppliers where supplier='4U'), -- supplier
3, -- qty
196);
--Вставка поступлений товара actions 98
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-06-01 10:05:00',
(select id from products where product='DDR3 ZPP 4Gb'), -- product
(select id from suppliers where supplier='4U'), -- supplier
60, -- qty
34);
--Вставка поступлений товара actions 99
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-07-01 12:21:00',
(select id from products where product='Monitor DD27'), -- product
(select id from suppliers where supplier='4U'), -- supplier
7, -- qty
348);
--Вставка поступлений товара actions 100
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-12-13 09:52:00',
(select id from products where product='DDR3 ZPP 4Gb'), -- product
(select id from suppliers where supplier='4U'), -- supplier
10, -- qty
42);
--Вставка поступлений товара actions 101
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-01-20 15:35:00',
(select id from products where product='S1 HDD 1T, 7200 rpm'), -- product
(select id from suppliers where supplier='4U'), -- supplier
20, -- qty
115);
--Вставка поступлений товара actions 102
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-02-25 16:05:00',
(select id from products where product='DDR3 SST 4Gb'), -- product
(select id from suppliers where supplier='4U'), -- supplier
80, -- qty
36);
--Вставка поступлений товара actions 103
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-03-12 12:45:00',
(select id from products where product='DDR3 BTT 4Gb'), -- product
(select id from suppliers where supplier='4U'), -- supplier
50, -- qty
39);

--IDT
--Вставка поступлений товара actions 104
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-29 13:00:00',
(select id from products where product='S5 HDD 500Gb, 7200rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
120, -- qty
78);
--Вставка поступлений товара actions 105
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-07-29 13:00:00',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
80, -- qty
130);
--Вставка поступлений товара actions 106
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-10 09:50:00',
(select id from products where product='S5 HDD 500Gb, 7200rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
60, -- qty
78);
--Вставка поступлений товара actions 107
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2019-08-12 10:10:00',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
85, -- qty
129);
--13.02.2021
--Вставка поступлений товара actions 108
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-02-12 09:15:00',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
100, -- qty
127);
--Вставка поступлений товара actions 109
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-02-25 17:02:00',
(select id from products where product='S2 HDD 500Gb, 7200 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
50, -- qty
73);
--Вставка поступлений товара actions 110
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-02-25 17:03:00',
(select id from products where product='S1 HDD 1T, 7200 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
63, -- qty
99);
--Вставка поступлений товара actions 111
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-02-25 17:03:00',
(select id from products where product='S5 HDD 500Gb, 7200rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
20, -- qty
82);
--Вставка поступлений товара actions 112
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-06-14 16:03:00',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
25, -- qty
127);
--Вставка поступлений товара actions 113
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-07-19 10:25:00',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
20, -- qty
127);
--Вставка поступлений товара actions 114
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-09-01 09:25:00',
(select id from products where product='S1 HDD 1T, 7200 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
30, -- qty
116);
--Вставка поступлений товара actions 115
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-11-01 10:10:00',
(select id from products where product='S2 HDD 500Gb, 7200 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
30, -- qty
73);
--Вставка поступлений товара actions 116
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2020-12-25 13:09:00',
(select id from products where product='S5 HDD 500Gb, 7200rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
20, -- qty
83);
--Вставка поступлений товара actions 117
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-01-11 09:15:00',
(select id from products where product='S4 HDD 1T, 7200rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
15, -- qty
120);
--Вставка поступлений товара actions 118
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-01-14 10:22:00',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
90, -- qty
127);
--Вставка поступлений товара actions 119
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-01-29 10:30:00',
(select id from products where product='S2 HDD 500Gb, 7200 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
40, -- qty
77);
--Вставка поступлений товара actions 120
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-02-10 15:56:00',
(select id from products where product='S4 HDD 1T, 7200rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
20, -- qty
118);
--Вставка поступлений товара actions 121
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-02-10 15:57:00',
(select id from products where product='S1 HDD 1T, 7200 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
25, -- qty
116);
--Вставка поступлений товара actions 122
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-02-22 11:37:00',
(select id from products where product='S5 HDD 500Gb, 7200rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
65, -- qty
80);
--Вставка поступлений товара actions 123
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-02-28 08:47:00',
(select id from products where product='S3 HDD 250Gb, 10000 rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
10, -- qty
145);
--Вставка поступлений товара actions 124
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-03-05 10:45:00',
(select id from products where product='S4 HDD 1T, 7200rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
100, -- qty
109);
--Вставка поступлений товара actions 125
INSERT into actions (action_date, product_id, supplier_id, qty, price)
VALUES ('2021-03-10 13:23:00',
(select id from products where product='S5 HDD 500Gb, 7200rpm'), -- product
(select id from suppliers where supplier='IDT'), -- supplier
45, -- qty
84);



select null as year ,null as month, NULL as day , sum(actions.price * actions.qty) as total_sum from actions
union
select date_part('year' , actions.action_date) as year,
       date_part('month' , action_date) as month ,
       date_part('day' , action_date) as day,
       sum(actions.price * actions.qty) as total_sum
from actions
group by date_part('year' , actions.action_date),
         date_part('month' , action_date),
         date_part('day' , action_date)
order by year,month,day, total_sum desc ;


--TASK2
select supplier , date_part('year' , actions.action_date) as year, sum(actions.price * actions.qty) as total_sum from actions
join suppliers on  actions.supplier_id = suppliers.id
group by supplier, date_part('year' , actions.action_date)
order by supplier, year , total_sum;


--task3
select suppliers.supplier, products.product, date_part('year', actions.action_date) as year, sum(actions.price * actions.qty) from actions
join suppliers on  actions.supplier_id = suppliers.id
join products on products.id = actions.product_id
 where extract(year from action_date) = 2020

group by suppliers.supplier, product, date_part('year', actions.action_date)
order by supplier,product,year;


--task4
select category, suppliers.supplier, date_part('year', actions.action_date) as year,
       avg(actions.price * qty),max(actions.price* qty),
       min(actions.price* qty), sum(actions.price * qty) from actions
join products on products.id = actions.product_id
join suppliers on actions.supplier_id = suppliers.id
join categories c on products.category_id = c.id
group by  suppliers.supplier, actions.action_date,category
order by category, year;
