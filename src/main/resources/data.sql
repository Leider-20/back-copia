INSERT INTO conductor (nombre, celular, email, cedula, rol, id_tipo_usuario, nro_servicios, placa) VALUES
('Juan', '3001112233', 'juan@email.com', '12345678', 'CONDUCTOR', 1, 10, 'ABC-123'),
('Maria', '3001112234', 'maria@email.com', '12345679', 'CONDUCTOR', 2, 12, 'ABC-124'),
('Pedro', '3001112235', 'pedro@email.com', '12345680', 'CONDUCTOR', 1, 15, 'ABC-125'),
('Laura', '3001112236', 'laura@email.com', '12345681', 'CONDUCTOR', 2, 8, 'ABC-126'),
('Carlos', '3001112237', 'carlos@email.com', '12345682', 'CONDUCTOR', 1, 9, 'ABC-127');

INSERT INTO usuario (id_grupo, nombre, celular, email, cedula, rol, id_tipo_usuario, nro_servicios) VALUES
(1, 'Jose', '3002223344', 'jose@email.com', '23456789', 'USER', 1, 5),
(2, 'Andrea', '3002223345', 'andrea@email.com', '23456790', 'USER', 2, 7),
(1, 'Lucia', '3002223346', 'lucia@email.com', '23456791', 'USER', 1, 4),
(2, 'David', '3002223347', 'david@email.com', '23456792', 'USER', 2, 3),
(1, 'Esteban', '3002223348', 'esteban@email.com', '23456793', 'USER', 1, 6);

INSERT INTO ubicacion (latitud, longitud, direccion) VALUES
(6.235925, -75.575137, 'Calle 10 #32-45, Medellín, Colombia'),
(6.246760, -75.581215, 'Carrera 48 #20-34, Medellín, Colombia'),
(6.248659, -75.563202, 'Avenida 70 #44-22, Medellín, Colombia'),
(6.262042, -75.575996, 'Calle 50 #65-30, Medellín, Colombia'),
(6.257640, -75.591020, 'Carrera 33 #25-60, Medellín, Colombia');

INSERT INTO servicio (id_usuario, id_conductor, id_ubicacion_origen, id_ubicacion_destino, fecha_inicio, id_tipo_servicio, estado, detalles, id_categoria, estado_pago, calificacion_conductor, calificacion_usuario, id_estrategia, motivo, costo) VALUES
(1, 1, 1, 2, '2023-10-22T16:00:00', 1, 'En progreso', 'Llevo equipaje', 1, 'Pagado', '5', '4', 1, 'Viaje normal', 15000.0),
(2, 2, 2, 3, '2023-10-23T10:00:00', 2, 'Completado', 'Viaje tranquilo', 2, 'Pagado', '4', '5', 2, 'Viaje normal', 16000.0),
(3, 3, 3, 1, '2023-10-24T18:00:00', 1, 'En progreso', 'Sin comentarios', 3, 'No Pagado', null, null, 3, 'Viaje normal', 23000.0),
(4, 4, 4, 2, '2023-10-25T12:00:00', 2, 'Cancelado', 'El usuario canceló', 4, 'No Pagado', '1', '5', 4, 'Usuario canceló', 0.0),
(5, 5, 5, 3, '2023-10-26T20:00:00', 1, 'En espera', 'Llevo mascota', 5, 'No Pagado', null, null, 5, 'Viaje normal', 14500.0);

