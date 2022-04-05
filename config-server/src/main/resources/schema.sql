--Se agrega este archivo porque no existe una entity de properties en este proyecto
CREATE TABLE IF NOT EXISTS properties (
               id IDENTITY PRIMARY KEY,
               application VARCHAR(128),
               profile VARCHAR(128),
               label VARCHAR(128),
               key VARCHAR(512),
               value VARCHAR(512)
           );