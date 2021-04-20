create sequence contact_id_seq;
create sequence email_id_seq;

CREATE TABLE contact (
    contact_id int not null default nextval('contact_id_seq'),
    name varchar(255) null,
    phone_number varchar(22) null,
    active boolean not null
);

CREATE TABLE email (
    email_id int not null default nextval('email_id_seq'),
    email_address varchar(255) not null,
    contact_id int not null,
    foreign key (contact_id) references contact(contact_id)
);

insert into contact (name, phone_number, active)
 values ('Adriane', '16987456123', true),
        ('Big Valter', '99999999999', false),
        ('Bruno', '19123456789', true);

insert into email (email_address, contact_id)
 values ('adriane@email.com', 1);
