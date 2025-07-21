INSERT INTO `categorias`(nombre_categoria) VALUES
('Alimentos'),
('Bebidas'),
('Limpieza'),
('Bazar');

INSERT INTO `productos`(nombre, descripcion, precio, categoria_id, stock, url_imagen) VALUES
('Vino', 'Vino tinto Reserva 1943 x920ml', 2300, 2, 50, ''),
('Limpiador de piso', 'Desinfectante y aromatizante para piso x750ml', 3100, 3, 40, ''),
('Fideos', 'Fideos amasados con huevo x500g', 2500, 1, 72, ''),
('Tupper','Tupper mediano verde capacidad 320ml', 1800, 4, 12,'');

INSERT INTO `usuarios`(nombre_usuario, nombre, apellido, email, numero_telefono) VALUES
('Joseju', 'Jose Juan', 'Flores', 'joseju2302@gmail.com','1198987676');

