CREATE TABLE tb_reviews(
    id SERIAL PRIMARY KEY,
    review TEXT NOT NULL,
    note INT NOT NULL,
    user_id BIGINT REFERENCES tb_users(id),
    product_id BIGINT REFERENCES tb_products(id)
)