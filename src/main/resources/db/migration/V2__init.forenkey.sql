ALTER TABLE areas
   ADD COLUMN maquinaria_id INT NOT NULL;

ALTER TABLE areas
   ADD FOREIGN KEY (maquinaria_id) REFERENCES maquinaria(id);
