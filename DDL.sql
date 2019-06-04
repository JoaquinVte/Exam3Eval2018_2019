#----------------------------------------------------------
#-- Creamos el schema. Previamente lo borramos si ya esta creado
#----------------------------------------------------------
DROP DATABASE IF EXISTS exam;
CREATE DATABASE IF NOT EXISTS exam;
USE exam;

#----------------------------------------------------------
#-- Creamos un usuario para el acceso a la base de datos
#----------------------------------------------------------
DROP USER IF EXISTS 'student'@'%';
CREATE USER 'student'@'%';
GRANT ALL PRIVILEGES ON exam.* TO 'student'@'%' IDENTIFIED BY '1111';
GRANT all PRIVILEGES on mysql.proc TO 'student'@'%' IDENTIFIED BY '1111';

#----------------------------------------------------------
#-- Creamos las tablas
#----------------------------------------------------------

CREATE TABLE category (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  description varchar(45) NOT NULL
);

CREATE TABLE product (
  cod int(11) PRIMARY KEY AUTO_INCREMENT,
  description varchar(50) NOT NULL,
  cost decimal(10,2) NOT NULL,
  stock int(10) unsigned NOT NULL DEFAULT '0',
  categoryId int(11) NOT NULL,
  FOREIGN KEY (categoryId) REFERENCES category (id)
);

#----------------------------------------------------------
#-- Creamos procedimientos
#----------------------------------------------------------
DELIMITER $$
CREATE PROCEDURE add_product (IN description varchar(50), IN cost decimal(10,2), IN stock int(10),IN categoryId int(11))
BEGIN
	
    DECLARE maxId INT;
    DECLARE cantCategoryId INT;
    
	SELECT IFNULL(MAX(cod), 0) INTO maxId FROM product;
    SELECT COUNT(*) INTO cantCategoryId FROM category WHERE id=categoryId;
    
    IF stock<0
    THEN
		SIGNAL SQLSTATE '45000'
        SET message_text='the stock can not be negative',
        mysql_errno=1000;
	END IF;
    
    IF cantCategoryId=0
    THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The category do not exists.',
		MYSQL_ERRNO = 1001;
	END IF;
    
    IF cost<0
    THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The cost can not be negative',
        MYSQL_ERRNO = 1002;
	END IF;
    
    INSERT INTO product VALUES (maxId+1,description,cost,stock, categoryId);

END;$$
DELIMITER ;



#----------------------------------------------------------
#-- Introducimos registros
#----------------------------------------------------------
insert into category (description) values ("HD");
insert into category (description) values ("CPU");
insert into category (description) values ("Monitor");

CALL add_product("Seagate 1TB",45.67,10, 1);
CALL add_product("Seagate 2TB",80,10, 1);
CALL add_product("Seagate 3TB",150.25,10, 1);
CALL add_product("Seagate 4TB",225,10, 2);
CALL add_product("Seagate 6TB",300.25,10, 3);




