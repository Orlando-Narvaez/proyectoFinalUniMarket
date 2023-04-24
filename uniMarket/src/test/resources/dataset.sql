--user (cedula, nombre_completo, telefono, email, nombreusuario, contraseña, estado, direccion)

insert into user values (41896158, "Ligia Ballen Marin", "3207507060", "juliancho.quiroga@hotmail.com",
                            "LigiaBM", "Ligia0811", "ACTIVO", "Br montevideo mz 6 casa 8");
insert into user values (1094941113, "Diana Josefina Gomez Velasco", "3142231245", "dijogovel18@hotmail.com",
                            "DianaGV", "AnaLucia11", "ACTIVO", "Urb Villa Ximena Bloq 1 Apto 301");
insert into user values (1098123651, "Orlando Narvaez Baracaldo", "3168669742", "chachonarvaez@gmail.com",
                            "Chacho", "0987654321", "INACTIVO", "Barrio la pavona mz 11 c # 12");
insert into user values (1094936382, "Julian Andres Quiroga Ballen", "3128190284", "jaquirogab@uqvirtual.edu.co",
                            "JulianQB", "taz123", "ACTIVO", "Br montevideo mz 6 casa 8");
insert into user values (29320442, "Mercedes Marin Benitez", "7349018", "juliancho.quiroga@gmail.com",
                            "MercedesMB", "0oo00123", "INACTIVO", "Br montevideo mz 6 casa 8");


--moderator (cedula, nombre_completo, email, numero_telefono, nombre_usuario, contrasena, estado, direccion)

insert into moderator values (111111111, "Juan Pérez", "juan.perez@gmail.com", "1234567890", "juanperez", "0o0o0o0o", "ACTIVO", "Calle 123, Bogota");
insert into moderator values (222222222, "María González", "maria.gonzalez@gmail.com", "9876543210", "mariagonzalez", "d467dgt", "INACTIVO", "Avenida 44 N  n 33");
insert into moderator values (333333333, "Carlos Ramírez", "carlos.ramirez@gmail.com", "5555555555", "carlosramirez", "112234fg", "ACTIVO", "Calle 12 # 23");
insert into moderator values (444444444, "Ana Torres", "ana.torres@gmail.com", "1111111111", "anatorres", "fg33.lAD", "INACTIVO", "Avenida del rio c # 12 Pereira");
insert into moderator values (555555555, "Pedro Silva", "pedro.silva@gmail.com", "9999999999", "pedrosilva", "lisj230098", "ACTIVO", "Ruta 34, Sector 12");


--producto (codigo, nombre, precio, fechapublicacion, fechavencimiento, descripcion,  estado, cantidad)

insert into product values (1, "Celular Samsung Galaxy A13 128GB", 645000.00, '2023-04-23', '2023-06-30',"Celular Gama Alta", "ACTIVO", 5);
insert into product values (2, "Televisor LG 42 pulgadas", 1200000.00, '2023-04-23', '2023-07-31', "TV con asistente de voz", "ACTIVO", 2);
insert into product values (3, "Nevera Haceb de 400 L no frost", 2200000.00, '2023-04-23', '2023-08-31', "Con la ultima tecnologia para conservar tus alimentos", 'INACTIVO', 1);
insert into product values (4, "freidora de aire Oster 3L", 240000.00, '2023-04-23', '2023-09-30', "Para cocinar tus alimentos libres de grasas", 'ACTIVO', 3);
insert into product values (5, "Computador portatil Hp 14 pulgadas intel core I5 8 GB RAM", 2200000.00, '2023-04-23', '2023-10-31', "Multifuncional y potente para realizar tus trabajos del dia", 'ACTIVO', 4);


--cart (code, buyDate, idUser, totalValue, paymentMethod, user, detailCarList)
insert into Cart values (1,'2023-04-27', 41896158, 3800000, 'TARJETA_CREDITO', "Ligia Ballen Marin",1);
insert into Cart values (2,'2023-04-28', 1094936382, 2300000, 'TARJETA_DEBITO', "Julian Andres Quiroga Ballen",2);
insert into Cart values (3,'2023-04-29', 1094941113, 1800000, 'TRANSFERENCIA_BANCARIA',"Diana Josefina Gomez Velasco",3);
insert into Cart values (4,'2023-04-30', 1098123651, 800000, 'EFECTIVO', "Orlando Narvaez Baracaldo",4);
insert into Cart values (5,'2023-05-01', 29320442, 2000000, 'PAYPAL', "Mercedes Marin Benitez",5);


--comments (id, comment, dateComment, user, product)
insert into Comments values (1, "Excelente producto", '2023-05-18', 41896158, 1);
insert into Comments values (2, "Muy buena calidad", '2023-05-19', 1094936382, 2);
insert into Comments values (3, "Buen Producto", '2023-05-20', 1094941113, 3);
insert into Comments values (4, "Supero mis expectativas", '2023-05-20', 1098123651, 4);
insert into Comments values (5, "No era lo que esperaba", '2023-05-21', 29320442, 5);

--DetailCart (id, value, amount, cart, product)
insert into DetailCart values (1, 645000,3, 1, 1);
insert into DetailCart values (2, 1200000,1, 2, 2);
insert into DetailCart values (3, 2200000,2, 3, 3);
insert into DetailCart values (4, 240000,4, 4, 4);
insert into DetailCart values (5, 2200000,1, 5, 5);

--Favorite (idFavorite, dateAdd, user, product)
insert into Favorite values (1,'2023-04-28', 41896158, 1);
insert into Favorite values (2,'2023-04-29', 1094941113, 2);
insert into Favorite values (3,'2023-04-30', 1098123651, 3);
insert into Favorite values (4,'2023-05-01', 1094936382, 4);
insert into Favorite values (5,'2023-05-02', 29320442, 5);

--Guarantee (idGuarantee, describeGuarantee, dataRequest, image, product, user)
insert into Guarantee values (1, "Falla puerto de carga", '2023-06-01', image, 1, 41896158);
insert into Guarantee values (2, "Franja negra en la pantalla", '2023-06-02', image, 2, 1094941113);
insert into Guarantee values (3, "No enfria", '2023-06-03', image, 3, 1098123651);
insert into Guarantee values (4, "Perilla de temporizador suelta", '2023-06-04', image, 4, 1094936382);
insert into Guarantee values (5, "Problema con el cargador", '2023-06-05', image, 5, 29320442);
