create table publishing_house (
    publisher_no int constraint PK_publisher_no primary key ,
    publisher_name varchar(255),
    street varchar(255),
    postal_code int,
    city varchar(255),
    country varchar(255)
);

INSERT INTO publishing_house(publisher_no, publisher_name, street, postal_code, city, country)
VALUES (1,'CARLSEN Verlag GmbH','Völckersstraße 14 - 20', 22765, 'Hamburg', 'Germany');
INSERT INTO publishing_house(publisher_no, publisher_name, street, postal_code, city, country)
VALUES (2,'Trauner Verlag + Buchservice GmbH','Köglstraße 14', 4020, 'Linz', 'Austria');
INSERT INTO publishing_house(publisher_no, publisher_name, street, postal_code, city, country)
VALUES (3, 'Springer-Verlag GmbH', 'Tiergartenstrasse 17', 69121, 'Heidelberg', 'Germany');
INSERT INTO publishing_house(publisher_no, publisher_name, street, postal_code, city, country)
VALUES (4, 'Cornelsen Verlag GmbH', 'Mecklenburgische Straße 53', 14197, 'Berlin', 'Germany');
INSERT INTO publishing_house(publisher_no, publisher_name, street, postal_code, city, country)
VALUES (5, 'Ernst Klett Verlag GmbH', 'Rotebühlstraße 77', 70178, 'Stuttgart', 'Germany');
INSERT INTO publishing_house(publisher_no, publisher_name, street, postal_code, city, country)
VALUES (6, 'Georg Westermann Verlag, Druckerei und Kartographische Anstalt GmbH & Co. KG', 'Georg-Westermann-Allee 66', 38104, 'Braunschweig', 'Germany');
INSERT INTO publishing_house(publisher_no, publisher_name, street, postal_code, city, country)
VALUES (7, 'Weltbild Verlag GmbH', 'Sterneckstraße 33 ', 5020, 'Salzburg', 'Austria');
INSERT INTO publishing_house(publisher_no, publisher_name, street, postal_code, city, country)
VALUES (8, 'WEKA Holding GmbH & Co. KG', 'Römerstraße 4', 86438, 'Kissing', 'Germany');
INSERT INTO publishing_house(publisher_no, publisher_name, street, postal_code, city, country)
VALUES (9, 'Verlagsgruppe Random House GmbH', 'Neumarkter Straße 28', 81673, 'Munich', 'Germany');
INSERT INTO publishing_house(publisher_no, publisher_name, street, postal_code, city, country)
VALUES (10, 'Vogel Communications Group GmbH & Co.KG', 'Max-Planck-Straße 7/9', 97082, 'Würzburg', 'Germany');

drop table publishing_house;