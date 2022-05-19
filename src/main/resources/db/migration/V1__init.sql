 CREATE TABLE IF NOT EXISTS tecnicos(
   id SERIAL,
   nombre VARCHAR (100) NOT NULL,
   cedula INT NOT NULL,
   PRIMARY KEY (id)
   );



 CREATE TABLE IF NOT EXISTS areas(
  id SERIAL,

  name VARCHAR (100) NOT NULL,
  direccion VARCHAR (50) NOT NULL,
  PRIMARY KEY (id)
  );



CREATE TABLE IF NOT EXISTS maquinaria(
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,
  modelo INT NOT NULL,
  areas_id INT NOT NULL,
  tecnicos_id INT NOT NULL,


  PRIMARY KEY (id),
  FOREIGN KEY (areas_id) REFERENCES areas (id),
  FOREIGN KEY (tecnicos_id) REFERENCES tecnicos (id)

  );





  CREATE TABLE IF NOT EXISTS tiempos(
  id SERIAL,
  contador  INT  NOT NULL,
  maquinaria_id INT NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (maquinaria_id) REFERENCES maquinaria (id)
  );

