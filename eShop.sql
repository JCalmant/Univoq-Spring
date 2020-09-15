CREATE TABLE CATEGORY (
    categoryID INT(8) NOT NULL auto_increment,
    CONSTRAINT categoryID_pk PRIMARY KEY (categoryID)
)engine = InnoDB default charset = utf8;
CREATE TABLE LANGUAGES (
    languageID INT(8) NOT NULL auto_increment,
	languageName VARCHAR(200) NOT NULL,
    CONSTRAINT languageID_pk PRIMARY KEY (languageID)
)engine = InnoDB default charset = utf8;
CREATE TABLE TRANSLATIONCATEGORY (
	translateID INT(8) NOT NULL auto_increment,
    idCategory INT(8) NOT NULL,
    idLanguage INT(8) NOT NULL,
    categoryName VARCHAR(50) NOT NULL,
    CONSTRAINT translateCategoryID_pk PRIMARY KEY (translateID),
    CONSTRAINT translateCategory_fk FOREIGN KEY (idCategory)
        REFERENCES CATEGORY (categoryID),
    CONSTRAINT translateCategoryLanguage_fk FOREIGN KEY (idLanguage)
        REFERENCES LANGUAGES (languageID)
)engine = InnoDB default charset = utf8;
CREATE TABLE PRODUCT (
    productID INT(8) NOT NULL auto_increment,
    productPrice DECIMAL(5,2) NOT NULL,
    idCategory INT(8) NOT NULL,
    productImage VARCHAR(200),
	CHECK (productPrice > 0),
    CONSTRAINT productID_pk PRIMARY KEY (productID),
    CONSTRAINT category_fk FOREIGN KEY (idCategory)
        REFERENCES CATEGORY (categoryID)
)engine = InnoDB default charset = utf8;
CREATE TABLE TRANSLATIONPRODUCT (
	translateID INT(8) NOT NULL auto_increment,
    idProduct INT(8) NOT NULL,
    idLanguage INT(8) NOT NULL,
    productName VARCHAR(30) NOT NULL,
    productDescription VARCHAR(200) NOT NULL,
    CONSTRAINT translateProductID_pk PRIMARY KEY (translateID),
    CONSTRAINT translateProduct_fk FOREIGN KEY (idProduct)
        REFERENCES PRODUCT (productID),
    CONSTRAINT translateProductLanguage_fk FOREIGN KEY (idLanguage)
        REFERENCES LANGUAGES (languageID)
)engine = InnoDB default charset = utf8;
CREATE TABLE LOCALITY (
    localityName VARCHAR(60) NOT NULL,
    POcode INT(8) NOT NULL,
    CONSTRAINT localityName_pk PRIMARY KEY (localityName)
)engine = InnoDB default charset = utf8;
CREATE TABLE USERS (
    userName VARCHAR(30) NOT NULL,
    userLocality VARCHAR(30) NOT NULL,
    userFirstName VARCHAR(30) NOT NULL,
    userLastName VARCHAR(30) NOT NULL,
    userMail VARCHAR(100) NOT NULL,
    userPassword VARCHAR(64) NOT NULL,
    userPhoneNumber VARCHAR(12),
    userDeliveryAddress VARCHAR(50) NOT NULL,
    userBillingAddress VARCHAR(50),
    CONSTRAINT userName_pk PRIMARY KEY (userName),
    CONSTRAINT userLocality_fk FOREIGN KEY (userLocality)
        REFERENCES LOCALITY (localityName)
)engine = InnoDB default charset = utf8;
CREATE TABLE ORDERS (
    orderID INT(8) NOT NULL auto_increment,
    orderUser VARCHAR(30) NOT NULL,
    CONSTRAINT orderID_pk PRIMARY KEY (orderID),
    CONSTRAINT orderUser_fk FOREIGN KEY (orderUser)
        REFERENCES USERS (userName)
)engine = InnoDB default charset = utf8;
CREATE TABLE ORDERDETAILS (
    orderDetailsID INT(8) NOT NULL auto_increment,
    idOrder INT(8) NOT NULL,
    idProduct INT(8) NOT NULL,
    quantity INT(2) NOT NULL,
    unitprice DECIMAL(6,2) NOT NULL,
	CHECK (quantity>0),
    CONSTRAINT orderDetailsID_pk PRIMARY KEY (orderDetailsID),
    CONSTRAINT orderDetailsParent_fk FOREIGN KEY (idOrder)
        REFERENCES ORDERS (orderID),
    CONSTRAINT orderDetailsProduct_fk FOREIGN KEY (idProduct)
        REFERENCES PRODUCT (productID)
)engine = InnoDB default charset = utf8;
insert into locality (localityName,POcode) values ('Namur',5000),('Gembloux',5030),('Anvers',2000),('Arlon',6700),('Bouilllon',6830),('Bruxelles',1000),('Charleroi',6000),('Mons',7000),('Liège',4000),('Leuven',3000),('Wavre',1300),('Ottignies/LLN',1340),('Dinant',5500),('Ostende',8400),('Bruges',8000),('Gand',9000),('Hasselt',3500),('Huy',5200),('Knokke',8300),('Tournai',7500),('Waterloo',1410),('Neufchâteau',6620),('Ypres',8900),('Chimay',6460),('Rochefort',5430),('Rixensart',1330);
insert into category (categoryid) values (1),(2),(3);
insert into languages (languageName) values ('Français'),('English');
insert into TRANSLATIONCATEGORY (idCategory, idLanguage, categoryName) values (1, 1, 'Fournitures'), (2, 1, 'Vetements'), (3, 1, 'Accessoire');
insert into TRANSLATIONCATEGORY (idCategory, idLanguage, categoryName) values (1, 2, 'Stationary'), (2, 2, 'Apparel'), (3, 2, 'Accesories');
insert into PRODUCT (productprice, idcategory, productimage)
  values (15.09, 1, '/images/articles/cahier.jpg'),
         (16.09, 1, '/images/articles/classeur.jpg'),
         (19.99, 1,'/images/articles/stylo.jpg');
insert into PRODUCT (productprice, idcategory, productimage)
  values (13.99, 2,'/images/articles/pull.jpg');
insert into PRODUCT (productprice, idcategory, productimage)
  values (16.99, 3,'/images/articles/casquette.jpg');
insert into TRANSLATIONPRODUCT (idProduct, idLanguage, productName, productDescription)
  values (1, 1, 'Cahiers BYU', 'Cahier de marque Oxford à feuille quadrillé de dimension A4.'),
         (2, 1, 'Casquette Oxford University', 'Casquette officielle de l\'équipe sportif de l\'université d\'Oxford'),
         (3, 1, 'Classeur Portland', 'Classeur imperméable de l\'université de Portland'),
         (4, 1, 'Pull Belmont U', 'Pull promotion de l\'année 2018 de l\'université de Belmont'),
         (5, 1, 'Stylo Université de Adelaide', 'Stylos de bureau de AU Aus. (offert à l\'achat d\'un autre article issu du même université)');
insert into TRANSLATIONPRODUCT (idProduct, idLanguage, productName, productDescription)
  values (1, 2, 'BYU notebook', 'Oxford branded notebook with graph paper of dimension A4.'),
         (2, 2, 'Oxford University Sports Cap', 'Official cap of the Oxford University Sports Club'),
         (3, 2, 'PortlandU Binder', 'Water-resistant Binder from the PortlandU Bookstore'),
         (4, 2, 'BelmontU Sweatshirt', 'Grad 2018 Sweatshirt of BelmontU'),
         (5, 2, 'Adelaide University Pen', 'Desk pen of AU Aus. (Gifted after the purchase of an item from the same university)');
