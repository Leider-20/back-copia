CREATE TABLE usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    id_grupo INT,  -- Ajustar esto cuando tenga la tabla grupo
    nombre VARCHAR(255) NOT NULL,
    celular VARCHAR(15),
    email VARCHAR(255),
    cedula VARCHAR(15) NOT NULL,
    rol VARCHAR(50),
    id_tipo_usuario INT, -- Ajustar esto cuando tenga la tabla TipoUsuario
    nro_servicios INT
);

CREATE TABLE conductor (
    id_conductor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    celular VARCHAR(15),
    email VARCHAR(255),
    cedula VARCHAR(15) NOT NULL,
    rol VARCHAR(50),
    id_tipo_usuario INT, -- Ajustar esto cuando tenga la tabla TipoUsuario
    nro_servicios INT,
    placa VARCHAR(15)
);

CREATE TABLE ubicacion (
    id_ubicacion INT PRIMARY KEY AUTO_INCREMENT,
    latitud DOUBLE,
    longitud DOUBLE,
    direccion VARCHAR(255)
);

CREATE TABLE servicio (
    id_servicio INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT,
    id_conductor INT,
    id_ubicacion_origen INT,
    id_ubicacion_destino INT,
    fecha_inicio TIMESTAMP,
    fecha_fin TIMESTAMP,
    id_tipo_servicio INT, -- Ajustar esto cuando tenga la tabla TipoServicio
    estado VARCHAR(50),
    detalles VARCHAR(255),
    id_categoria INT, -- Ajustar esto cuando tenga la tabla Categoria
    estado_pago VARCHAR(50),
    calificacion_conductor VARCHAR(50),
    calificacion_usuario VARCHAR(50),
    id_estrategia INT, -- Ajustar esto cuando tenga la tabla Estrategia
    motivo VARCHAR(255),
    costo DOUBLE,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_conductor) REFERENCES conductor(id_conductor),
    FOREIGN KEY (id_ubicacion_origen) REFERENCES ubicacion(id_ubicacion),
    FOREIGN KEY (id_ubicacion_destino) REFERENCES ubicacion(id_ubicacion)
);
