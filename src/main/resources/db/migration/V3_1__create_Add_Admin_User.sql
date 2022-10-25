create extension if not exists pgcrypto;

insert into user_list (user_name, user_pass, user_role) values
('user_name', crypt('user_password', gen_salt('bf')), 'ROLE_USER'),
('admin', crypt('admin', gen_salt('bf')), 'ROLE_ADMIN'),
('user', crypt('user', gen_salt('bf')), 'ROLE_USER');
