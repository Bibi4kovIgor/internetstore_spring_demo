create table if not exists Payment (
    id uuid default uuid_generate_v4 (),
    account varchar,
    primary key (id)
);

create table if not exists Product (
    id uuid default uuid_generate_v4 (),
    name varchar not null,
    price double precision not null,
    description varchar,
    primary key (id)
);

insert into Payment (account) values
('45646546465465'),
('asd47687SXD'),
('564987651qwe31313'),
('457845458qwedqwd13'),
('123123asdasd24234');

insert into Product (name, price, description) values
('powerbank', 450.2, '5000 mAh'),
('Laptop', 50000, 'Think Pad Lenovo'),
('IPhone', 35000, 'IPhone 16'),
('Headphones', 2500, 'Sony Headphones'),
('Keyboard', 1500.11, 'Wireless Keyboard');