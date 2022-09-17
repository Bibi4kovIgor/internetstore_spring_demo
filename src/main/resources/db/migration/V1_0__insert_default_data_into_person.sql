create extension if not exists "uuid-ossp";

create table if not exists person (
    id uuid default uuid_generate_v4 (),
    name varchar not null,
    email varchar not null,
    phone varchar,
    primary key (id)
);

insert into person (name, email, phone) values
('Ihor', 'work.bibi4kov@gmail.com', '+380 (784) 454 - 7747'),
('Ivan', 'ivan.susanin@gmail.com', '+380 (555) 483 - 4746'),
('Abdula', 'abdula.zade@gmail.com', '+380 (088) 475 - 4767'),
('Arinstotel', 'aristotel.philosofy@gmail.com', '+380 (072)445 - 4747'),
('Archimed', 'archimed.physics@gmail.com', '+380 (048) 446 - 4777');