-- CREAMOS LA BD

CREATE DATABASE IF NOT EXISTS urbanstride;

-- CAMBIAMOS EL SCHEMA POR DEFECTO

use urbanstride;

-- DROP 
DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario (
    user_id TINYINT(2) PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30),
    contrasena VARCHAR(500),
    nombre VARCHAR(30),
    APELLIDOS VARCHAR (30),
    CORREO_ELEC VARCHAR (30),
    TELEFONO VARCHAR(15),
    DIRECCION VARCHAR(40)


);