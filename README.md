Github Publico: https://github.com/Educal72/proyecto

Integrantes:
Calderón Mora Eduardo
Ureña Piedra Dylan Antonio

Ultima Versión del Script para la Base de Datos MySQL
drop schema adopcion;
drop user usuario;
/*Se crea la base de datos */
CREATE SCHEMA adopcion;
/*Se crea un usuario para la base de datos llamado "usuario_practica” y tiene la contraseña “la”_Clave*/
create user 'usuario'@'%' identified by 'clave';
/*Se asignan los prvilegios sobrela base de datos Practica al usuario creado */
grant all privileges on adopcion.* to 'usuario'@'%';
flush privileges;

DROP TABLE ANIMALES;
/*Se crea la tabla de estados llamada estado... igual que la clase Estado */
CREATE TABLE adopcion.animales (
  id_animal INT NOT NULL AUTO_INCREMENT,
  img blob,
  nombre VARCHAR(50) NOT NULL,
  edad int NOT NULL,
  raza VARCHAR(25) NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  ruta_imagen varchar(200),
  PRIMARY KEY (`id_animal`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

INSERT INTO adopcion.animales (img,nombre, edad, raza, descripcion) VALUES
(null,'nombre','12','na','descripcion1');

DROP TABLE ADOPCION.PRODUCTOS;

CREATE TABLE adopcion.productos (
  id_producto INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  categoria VARCHAR(50) NOT NULL,
  precio int NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  existencias int not null,
  activo bool,
  ruta_imagen varchar(200),
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

INSERT INTO adopcion.productos (nombre,categoria,precio, descripcion) VALUES
('nombre','Juguetes','12','descripcion1');


CREATE TABLE adopcion.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,  
  nombre VARCHAR(50) NOT NULL,  
  contrasena VARCHAR(50) NOT NULL,
  puntos INT NOT NULL,  
  calificacion INT NOT NULL,
  admin BIT DEFAULT NULL,
  PRIMARY KEY (`id_usuario`))  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

/*Se insertan 4 registros en la tabla usuario como ejemplo */
INSERT INTO adopcion.usuario (id_usuario, nombre, contrasena,puntos,calificacion,admin) VALUES 
(1, 'Julian','1234',0,85,0),
(2, 'Pedro','4321', 0,89,0),
(3,'Eliel','5678',20,99,1),
(4, 'Marco','9876',10,100,0);

create table adopcion.usuario(  
     id_usuario INT NOT NULL AUTO_INCREMENT,  
     username varchar(40) not null,  
     password varchar(250) not null,  
      
     PRIMARY KEY (id_usuario)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

create table adopcion.rol (  
      id_rol INT NOT NULL AUTO_INCREMENT,  
      nombre varchar(25), 
      id_usuario int not null,  
      PRIMARY KEY (id_rol),  
      foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4 
COLLATE = utf8mb4_eo_0900_ai_ci;

insert into adopcion.usuario values 
(1,'Eduardo','$2a$10$Dyc7XuQ64DX1L6IEok2ppu6h8yl.P4CIz05s3a0NwRjou/yYkGaga'),
(2,'Dylan','$2a$10$SjBZUjBbqOEbfQRTNoy25ed0.4ifd200ngGP.7WBS3/DNFC6YX3cG'),
(3,'cliente','$2a$10$FqDC6/Q9rLcO2MpitecIgeV8RDJcHKDopxk2Qm1eayt6aiOA2v.Wu');
insert into adopcion.rol values 
(1,'ROLE_ADMIN',1),
(2,'ROLE_USER',1),
(3,'ROLE_ADMIN',2),
(4,'ROLE_USER',2),
(5,'ROLE_USER',3);

insert into adopcion.animales (id_animal, nombre, edad,raza,descripcion,ruta_imagen)values 
(1,'Mike',7,'Sin raza','Sociable,Cariñoso','https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages.jpg?alt=media&token=0d8fe7f3-e8be-4770-ab75-515d03910e0a'),
(2,'No poseen nombre',0,'Sin raza','Recien nacidos,Amigables','https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fdownload.jpg?alt=media&token=8d0771c7-7b5b-44ab-bae4-28f371a9eff5'),
(3,'Zeus',1,'Husky','Jugueton,Sociable','https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes2%2Fimages-1.jpg?alt=media&token=fc27c8c1-2939-48bd-a09d-ea081c9038cb'),
(4,'Pepe',1,'Pug','Comelon,Perezoso','https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes2%2Fimages-2.jpg?alt=media&token=bd63ad28-19f0-444a-b4cb-b2b9ca8d4cbe'),
(5,'Bunny',3,'Conejo','Muy bien cuidada,chineada, muerde','https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes2%2Fimages-3.jpg?alt=media&token=2c8dfaf6-4f04-4c2e-a971-a0007b1e6a92');

insert into adopcion.productos (id_producto, nombre, categoria,precio,descripcion,existencias,activo,ruta_imagen)values 
(1,'DOG CHOW','Alimento',20000,'15kg',10,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fdownload-1.jpg?alt=media&token=77ea80e2-c591-4bc0-ba8e-f622b6f01029'),
(2,'PRO PLAN','Alimento',72000,'20kg',6,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fdownload-2.jpg?alt=media&token=7d6678ac-d6d3-4373-a1d6-182e292f4bbe'),
(3,'FIT FORMULA','Alimento',35000,'10kg',12,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages-4.jpg?alt=media&token=666fa88d-f0ab-40a6-93cc-4863ee4cb559'),
(4,'PEDIGREE','Alimento',19000,'16kg',3,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fdownload%2011.58.38%20p.%C2%A0m..jpg?alt=media&token=a2250be2-baff-49b9-bf0d-146a0cec039a'),
(5,'Correa blanca','Correas',8000,'2 metros',5,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages-1.jpg?alt=media&token=77e2220d-ed4d-4f3b-996d-ac02c72a2177'),
(6,'Correa negra','Correas',10000,'2,5 metros',7,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages-2.jpg?alt=media&token=521bc2c1-9733-4c96-ab31-6952447a4a09'),
(7,'Correa extensible','Correas',16000,'5 metros',2,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages-3.jpg?alt=media&token=7059ca6a-695e-4c90-8ce1-6178893c6099'),
(8,'Correa metalica','Correas',8000,'2,3 metros',5,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages%2011.58.38%20p.%C2%A0m..jpg?alt=media&token=bf8fe187-08f7-4b5c-9601-a2c4b4c387f1'),
(9,'Kong','Juguetes',20000,'Perros medianos',6,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages-5.jpg?alt=media&token=fedcf681-de20-4ce5-a908-866ff9dfb932'),
(10,'Juguete azul','Juguetes',5000,'Con sonido',20,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages-6.jpg?alt=media&token=1d9f87ac-9fd5-4d21-a783-9b638d2d813d'),
(11,'Bola celeste','Juguetes',15000,'Pon a pensar a tu mascota',1,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages-7.jpg?alt=media&token=75ce0962-3656-4d41-bde8-8a740d5ef6f0'),
(12,'Juguete para jalar','Juguetes',3000,'Resistente',11,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages-8.jpg?alt=media&token=2105c6ae-d248-47b2-be13-790d3c2f7c6f'),
(13,'Shampoo','Higiene',13000,'Anti Pulgas',3,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fdownload-3.jpg?alt=media&token=c7dbd2ef-dd64-45c3-8439-373c630c6c6e'),
(14,'Dentalife','Higiene',3000,'Sabor Natural',13,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages-10.jpg?alt=media&token=7a303cac-94ed-4aa8-914f-9db4014aef77'),
(15,'Bolsas de excremento','Higiene',6897,'10 Rollos',21,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages-11.jpg?alt=media&token=4e265334-6871-4630-b460-fec3d613ef05'),
(16,'Spray Gato','Higiene',4000,'No dañino',2,1,'https://firebasestorage.googleapis.com/v0/b/adopcion-e0dc4.appspot.com/o/imagenes%2Fimages-9.jpg?alt=media&token=eb04441d-f0c4-41a4-b1d6-d554bac773c5');
