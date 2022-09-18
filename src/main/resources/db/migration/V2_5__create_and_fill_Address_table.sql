create table if not exists Address (
    id uuid default uuid_generate_v4 (),
    country varchar not null,
    city varchar not null,
    street varchar not null,
    house_number integer not null,
    flat_number integer,
    customer_id uuid,
    primary key(id)
);

insert into Address (country, city, street, house_number, flat_number) values
('Ukraine', 'Kharkiv', 'Gagarina Ave', 12, 44),
('Ukraine', 'Lviv', 'Bandery str.', 41, 1);

insert into Address (country, city, street, house_number) values
('Ukraine', 'Kiiv', 'Vokzalna str.', 12);
