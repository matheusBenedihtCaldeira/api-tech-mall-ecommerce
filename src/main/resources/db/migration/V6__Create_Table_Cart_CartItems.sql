CREATE TABLE tb_carts(
    id SERIAL PRIMARY KEY,
    customer_id BIGINT REFERENCES tb_customers(id),
    total_price DOUBLE
);

CREATE TABLE tb_cart_items(
    id SERIAL PRIMARY KEY,
    cart_id BIGINT REFERENCES tb_carts(id),
    product_id BIGINT REFERENCES tb_products(id),
    quantity INT
);

ALTER TABLE tb_customers ADD COLUMN cart_id BIGINT REFERENCES tb_carts(id);