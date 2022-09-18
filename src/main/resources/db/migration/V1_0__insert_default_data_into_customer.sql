create extension if not exists "uuid-ossp";

create table if not exists Customer (
    id uuid default uuid_generate_v4 (),
    first_name varchar not null,
    last_name varchar not null,
    phone varchar,
    email varchar,
    payment_id uuid,
    primary key (id)
);

insert into Customer (first_name, last_name, email, phone) values
('Ihor', 'Bibichkov', 'work.bibi4kov@gmail.com', '+380 (784) 454 - 7747'),
('Ivan', 'Susanin', 'ivan.susanin@gmail.com', '+380 (555) 483 - 4746'),
('Abdula', 'Zade', 'abdula.zade@gmail.com', '+380 (088) 475 - 4767'),
('Arinstotel', 'Philosophy', 'aristotel.philosophy@gmail.com', '+380 (072)445 - 4747'),
('Archimed', 'Physics', 'archimed.physics@gmail.com', '+380 (048) 446 - 4777');