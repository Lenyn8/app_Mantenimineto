CREATE TABLE IF NOT EXISTS maquinaria(
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,
  modelo INT NOT NULL,
  PRIMARY KEY (id)
  );

  CREATE TABLE IF NOT EXISTS tecnicos(
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,
  cedula INT NOT NULL,
  PRIMARY KEY (id)
  );

  CREATE TABLE IF NOT EXISTS areas(
  id SERIAL,
  maquinaria_id INT NOT NULL,
  name VARCHAR (100) NOT NULL,
  direccion VARCHAR (50) NOT NULL,
  PRIMARY KEY (id)
  );

  CREATE TABLE IF NOT EXISTS tiempos(
  id SERIAL,
  contador  INT  NOT NULL,
  PRIMARY KEY (id)
  );

