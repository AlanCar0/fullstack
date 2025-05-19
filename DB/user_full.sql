drop table CLIENTE cascade constraint;
drop table PRODUCTO cascade constraint;
drop table CARRITO cascade constraint;

-- Insertar datos en la tabla CLIENTE
INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('9311334-8', 'Elias', 'Torres', '1993-01-01', 'eli.torres@example.com', 'Calle 1 #123');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('9876543-2', 'Señor', 'Lápiz', '1990-02-02', 'senor.lapiz@example.com', 'Calle 2 #234');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('8765432-1', 'Emilio', 'Soto', '1994-07-04', 'emi.so@example.com', 'Calle 3 #345');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('4566478-9', 'Calcetín', 'Con Rombos Man', '1975-03-03', 'calcetin.conrombos@example.com', 'Calle 4 #456');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('8877883-3', 'Tamara', 'Rubio', '2000-02-03', 'tam.rubio@example.com', 'Calle 5 #567');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('2345678-9', 'Nathalie', 'Fuentes', '1985-02-13', 'na.fuen@example.com', 'Calle 6 #678');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('8733442-1', 'Guillermo', 'Villacura', '1998-04-04', 'guille.villa@example.com', 'Calle 7 #789');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('6765432-1', 'Diente', 'De Oro', '1985-04-04', 'diente.deoro@example.com', 'Calle 8 #890');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('8954321-3', 'Victor', 'Gallardo', '1998-11-28', 'vi.gallard@example.com', 'Calle 9 #901');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('3456789-0', 'Chico', 'Terry', '1992-05-05', 'chico.terry@example.com', 'Calle 10 #101');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('2561890-1', 'Benjamin', 'Mora', '1990-07-07', 'bej.mora@example.com', 'Calle 11 #112');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('7654321-0', 'Taca', 'Taca', '1988-06-06', 'taca.taca@example.com', 'Calle 12 #123');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('8928370-1', 'Jorge', 'Niochtet', '1986-05-17', 'jo.niochtet@example.com', 'Calle 13 #134');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('2222211-1', 'Guaripolo', 'N/A', '1979-07-07', 'guaripolo@example.com', 'Calle 14 #145');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('4517890-1', 'Fernando', 'Silva', '1979-08-07', 'fsilva@example.com', 'Calle 15 #156');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('6543210-9', 'Policarpo', 'Avendaño', '1991-08-08', 'policarpo.avendano@example.com', 'Calle 16 #167');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('3276143-2', 'Abraham', 'Sepulveda', '1990-02-02', 'brama.sep@example.com', 'Calle 17 #178');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('5678901-2', 'Bodoque', 'N/A', '1983-09-09', 'bodoque@example.com', 'Calle 18 #189');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('4567890-1', 'Camilo Alexis', 'Muñoz', '1989-02-07', 'cam.munoz@example.com', 'Calle 19 #190');

INSERT INTO CLIENTE (run, nombre, apellido, fecha_nacimiento, email, direccion)
VALUES ('5432109-8', 'Juanín', 'Juan Harry', '1987-10-10', 'juanin.juanharry@example.com', 'Calle 20 #200');

/* Datos Producto */

INSERT INTO producto (nombre, descripcion, precio, stock)
VALUES ('Perfume Lavanda', 'Aroma suave y relajante de lavanda', 19990, 50);

INSERT INTO producto (nombre, descripcion, precio, stock)
VALUES ('Perfume Cítrico', 'Fragancia fresca de cítricos', 17990, 40);

INSERT INTO producto (nombre, descripcion, precio, stock)
VALUES ('Perfume Amaderado', 'Notas intensas de madera y especias', 24990, 30);

INSERT INTO producto (nombre, descripcion, precio, stock)
VALUES ('Perfume Floral', 'Mezcla delicada de flores silvestres', 18990, 60);

INSERT INTO producto (nombre, descripcion, precio, stock)
VALUES ('Perfume Vainilla', 'Dulce esencia de vainilla con toques cálidos', 20990, 45);

INSERT INTO producto (nombre, descripcion, precio, stock)
VALUES ('Perfume Oceánico', 'Frescura marina y brisa costera', 19990, 70);

INSERT INTO producto (nombre, descripcion, precio, stock)
VALUES ('Perfume Nocturno', 'Fragancia elegante para la noche', 26990, 25);

INSERT INTO producto (nombre, descripcion, precio, stock)
VALUES ('Perfume Veraniego', 'Aroma ligero ideal para el verano', 15990, 80);

INSERT INTO producto (nombre, descripcion, precio, stock)
VALUES ('Perfume Exótico', 'Combinación única de frutas tropicales', 22990, 35);

INSERT INTO producto (nombre, descripcion, precio, stock)
VALUES ('Perfume Clásico', 'Inspirado en fragancias tradicionales europeas', 18990, 55);

/* Datos Carro */
INSERT INTO carrito (CANT_PRODUCTO, descripcion_carrito, precio_carrito) 
VALUES (1, 'Esencia floral de primavera en frasco de cristal', 14990);

INSERT INTO carrito (CANT_PRODUCTO, descripcion_carrito, precio_carrito) 
VALUES (2, 'Aroma intenso de madera oriental y vainilla', 25980);

INSERT INTO carrito (CANT_PRODUCTO, descripcion_carrito, precio_carrito) 
VALUES (1, 'Fragancia cítrica de verano con notas de bergamota', 12990);

INSERT INTO carrito (CANT_PRODUCTO, descripcion_carrito, precio_carrito) 
VALUES (3, 'Colección exclusiva: musk profundo y canela dulce', 44970);

INSERT INTO carrito (CANT_PRODUCTO, descripcion_carrito, precio_carrito) 
VALUES (1, 'Perfume de noche: jazmín oscuro y sándalo', 17990);

INSERT INTO carrito (CANT_PRODUCTO, descripcion_carrito, precio_carrito) 
VALUES (2, 'Dúo aromático de lavanda silvestre y romero', 31980);

INSERT INTO carrito (CANT_PRODUCTO, descripcion_carrito, precio_carrito) 
VALUES (1, 'Edición limitada: perfume de rosas negras', 19990);

INSERT INTO carrito (CANT_PRODUCTO, descripcion_carrito, precio_carrito) 
VALUES (4, 'Set familiar: frescura marina con fondo de ámbar', 59960);

INSERT INTO carrito (CANT_PRODUCTO, descripcion_carrito, precio_carrito) 
VALUES (2, 'Aromas cítricos con notas verdes de bosque húmedo', 26980);

INSERT INTO carrito (CANT_PRODUCTO, descripcion_carrito, precio_carrito) 
VALUES (1, 'Fragancia clásica: elegancia de almizcle y cuero', 15990);


COMMIT;
