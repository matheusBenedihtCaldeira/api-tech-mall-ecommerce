CREATE TABLE tb_addresses(
    id SERIAL PRIMARY KEY,
    street_address VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    complement VARCHAR(255),
    city VARCHAR(255),
    uf VARCHAR(2),
    cep VARCHAR(10),
    number INTEGER
);

CREATE TABLE tb_customers(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    address_id BIGINT REFERENCES tb_addresses(id),
    cell_phone VARCHAR(20) NOT NULL,
    password VARCHAR(255) NOT NULL
);