CREATE TABLE user (
  id int PRIMARY KEY NOT NULL,
  username varchar(100) NOT NULL,
  email_address varchar(100) NOT NULL,
  password varchar(4100) DEFAULT NULL
);


CREATE TABLE company (
  id int PRIMARY KEY NOT NULL,
  name varchar(100) NOT NULL,
  added_by_user int NOT NULL
);
ALTER TABLE company ADD CONSTRAINT FK_company_user FOREIGN KEY (added_by_user)
REFERENCES user (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;


CREATE TABLE tea_category (
  id int PRIMARY KEY NOT NULL,
  name varchar(100) NOT NULL
);
CREATE UNIQUE INDEX tea_category_name_UNIQUE ON tea_category (name)
;


CREATE TABLE tea_type (
  id int PRIMARY KEY NOT NULL,
  name varchar(100) NOT NULL,
  id_category int NOT NULL
);
CREATE UNIQUE INDEX tea_type_name_UNIQUE ON tea_type (name)
;
ALTER TABLE tea_type ADD CONSTRAINT FK_type_category FOREIGN KEY (id_category)
REFERENCES tea_category (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;


CREATE TABLE tea (
  id int PRIMARY KEY NOT NULL,
  name varchar(100) NOT NULL,
  id_tea_type int NOT NULL,
  has_caffeine varchar(1) DEFAULT NULL, -- T or F
  temperature_c int DEFAULT NULL,
  infusion_time_s int DEFAULT NULL,
  quantity_g int DEFAULT NULL,
  quantity_water_ml int DEFAULT NULL,
  id_company int DEFAULT NULL
);
ALTER TABLE tea ADD CONSTRAINT FK_tea_company FOREIGN KEY (id_company)
REFERENCES company (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;
ALTER TABLE tea ADD CONSTRAINT FK_tea_type FOREIGN KEY (id_tea_type)
REFERENCES tea_type (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;


CREATE TABLE flavour (
  id int PRIMARY KEY NOT NULL,
  name varchar(100) NOT NULL
);
CREATE TABLE tea_flavour (
  id int PRIMARY KEY NOT NULL,
  id_tea int NOT NULL,
  id_flavour int NOT NULL
);
ALTER TABLE tea_flavour ADD CONSTRAINT FK_flavour FOREIGN KEY (id_flavour)
REFERENCES flavour (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;
ALTER TABLE tea_flavour ADD CONSTRAINT FK_tea_flavour FOREIGN KEY (id_tea)
REFERENCES tea (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;


CREATE TABLE ingredient (
  id int PRIMARY KEY NOT NULL,
  name varchar(100) DEFAULT NULL
);
CREATE TABLE tea_ingredient (
  id int PRIMARY KEY NOT NULL,
  id_tea int NOT NULL,
  id_ingredient int NOT NULL
);
ALTER TABLE tea_ingredient ADD CONSTRAINT FK_tea_ingredients FOREIGN KEY (id_tea)
REFERENCES tea (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;


CREATE TABLE own_tea (
  id int PRIMARY KEY NOT NULL,
  id_tea int NOT NULL,
  id_user int NOT NULL
);
ALTER TABLE own_tea ADD CONSTRAINT FK_own_tea FOREIGN KEY (id_tea)
REFERENCES tea (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;
ALTER TABLE own_tea ADD CONSTRAINT FK_own_user FOREIGN KEY (id_user)
REFERENCES user (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;



CREATE TABLE want_tea (
  id int PRIMARY KEY NOT NULL,
  id_tea int NOT NULL,
  id_user int NOT NULL
);
ALTER TABLE want_tea ADD CONSTRAINT FK_want_tea FOREIGN KEY (id_tea)
REFERENCES tea (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;
ALTER TABLE want_tea ADD CONSTRAINT FK_want_user FOREIGN KEY (id_user)
REFERENCES user (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;


CREATE TABLE ratings_by_user (
  id int PRIMARY KEY NOT NULL,
  id_tea int NOT NULL,
  id_user int NOT NULL,
  rating int NOT NULL
);
ALTER TABLE ratings_by_user ADD CONSTRAINT FK_ratings_tea FOREIGN KEY (id_tea)
REFERENCES tea (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;
ALTER TABLE ratings_by_user ADD CONSTRAINT FK_ratings_user FOREIGN KEY (id_user)
REFERENCES user (id) ON DELETE NO ACTION ON UPDATE NO ACTION
;





