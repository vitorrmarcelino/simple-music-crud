CREATE TABLE artista_musica(
    id SERIAL PRIMARY KEY NOT NULL,
    artista_id INT NOT NULL,
    musica_id INT NOT NULL,
    FOREIGN KEY(artista_id) REFERENCES artista(id),
    FOREIGN KEY(musica_id) REFERENCES musica(id)
);