CREATE TABLE contact (
    id_contact int not null AUTO_INCREMENT,
    name varchar(255) null,
    phone_number varchar(22) null,
    active boolean not null
);

insert into contact (name, phone_number, active)
 values ('Adriane', '16987456123', true),
        ('Big Valter', '99999999999', false),
        ('Bruno', '19123456789', true);
