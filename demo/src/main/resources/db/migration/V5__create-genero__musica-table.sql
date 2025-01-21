CREATE TABLE genero_musica(
    id SERIAL PRIMARY KEY NOT NULL,
    genero_id INT NOT NULL,
    musica_id INT NOT NULL,
    FOREIGN KEY(genero_id) REFERENCES genero(id),
    FOREIGN KEY(musica_id) REFERENCES musica(id)
);