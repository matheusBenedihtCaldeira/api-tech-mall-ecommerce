CREATE TABLE tb_reviews(
    id SERIAL PRIMARY KEY,
    review TEXT NOT NULL,
    note INT NOT NULL,
    customer_id BIGINT REFERENCES tb_customers(id),
    product_id BIGINT REFERENCES tb_products(id)
)