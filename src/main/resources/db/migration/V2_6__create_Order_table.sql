create table if not exists order_by (
    customer_id uuid,
    product_id uuid,
    primary key(customer_id, product_id)
);
