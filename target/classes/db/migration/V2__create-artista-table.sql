CREATE TABLE artista (
    id SERIAL PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    pais_id INT NULL,
    FOREIGN KEY (pais_id) REFERENCES pais(id)
);