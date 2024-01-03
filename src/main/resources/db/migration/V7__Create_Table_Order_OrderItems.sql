CREATE TABLE tb_orders(
    id SERIAL PRIMARY KEY,
    customer_id BIGINT REFERENCES tb_customers(id),
    shipping_address_id BIGINT REFERENCES tb_addresses(id),
    total_price DOUBLE,
    installment INT,
    order_status VARCHAR(20),
    order_date TIMESTAMP
);

CREATE TABLE tb_order_items(
    id SERIAL PRIMARY KEY,
    order_id BIGINT REFERENCES tb_orders(id),
    product_id BIGINT REFERENCES tb_products(id),
    quantity INTEGER
);

ALTER TABLE tb_customers ADD COLUMN order_id BIGINT REFERENCES tb_orders(id);