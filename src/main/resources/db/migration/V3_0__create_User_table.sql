create table if not exists user_list (
    user_name varchar not null,
    user_pass varchar not null,
    user_role varchar not null,
    primary key(user_name)
);
