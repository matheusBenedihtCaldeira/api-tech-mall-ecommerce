CREATE TABLE tb_categories(
    id SERIAL PRIMARY KEY,
    category_name VARCHAR(255) NOT NULl
);

CREATE TABLE tb_products(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    stock_quantity BIGINT NOT NULL,
    price DOUBLE NOT NULL,
    category_id BIGINT,
    image VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES tb_categories(id)
);