Github Publico: https://github.com/Educal72/proyecto

Integrantes:
Calderón Mora Eduardo
Ureña Piedra Dylan Antonio

Primera Versión del Script para la Base de Datos MySQL

/*drop schema adopcion;
drop user usuario;*/
/*Se crea la base de datos */

CREATE SCHEMA adopcion;
/*Se crea un usuario para la base de datos llamado "usuario_practica” y tiene la contraseña “la”_Clave*/
create user 'usuario'@'%' identified by 'clave';
/*Se asignan los prvilegios sobrela base de datos Practica al usuario creado */
grant all privileges on adopcion.* to 'usuario'@'%';
flush privileges;



/*Se crea la tabla de estados llamada estado... igual que la clase Estado */
CREATE TABLE adopcion.animales (
  id_animal INT NOT NULL AUTO_INCREMENT,
  img blob,
  nombre VARCHAR(50) NOT NULL,
  edad int NOT NULL,
  raza VARCHAR(25) NOT NULL,
  descripcion VARCHAR(500) NULL,
  PRIMARY KEY (`id_animal`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;


/*
INSERT INTO adopcion.animales (img,nombre, edad, raza, descripcion) VALUES
(null,'nombre','12','na','descripcion1');



DROP TABLE ADOPCION.PRODUCTOS;

*/

CREATE TABLE adopcion.productos (
  id_producto INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  categoria VARCHAR(50) NOT NULL,
  precio int NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  existencias int not null,
  activo bool,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;


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

/*
INSERT INTO adopcion.productos (nombre,categoria,precio, descripcion) VALUES
('nombre','Juguetes','12','descripcion1');


*/


/*Se insertan 4 registros en la tabla usuario como ejemplo */
/*
INSERT INTO adopcion.usuario (id_usuario, nombre, contrasena,puntos,calificacion,admin) VALUES
(1, 'Julian','1234',0,85,0),
(2, 'Pedro','4321', 0,89,0),
(3,'Eliel','5678',20,99,1),
(4, 'Marco','9876',10,100,0);*/
