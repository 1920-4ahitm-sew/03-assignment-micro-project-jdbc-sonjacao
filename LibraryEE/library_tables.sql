create table publishing_house (
    publisher_no int,
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