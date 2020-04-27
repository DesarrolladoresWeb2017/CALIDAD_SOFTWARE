create database colegio;

use colegio;

create table seccion(
seccion varchar(20) primary key
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table grado(
grado varchar(80) primary key
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table curso(
codCurso varchar(20) primary key,
nombre varchar(200)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table profesor(
usuario varchar(20) NOT NULL PRIMARY KEY,
nombre varchar(200) ,
apellido varchar(200),
direccion varchar(200) ,
ciudad varchar(40),
edad int(11),
telefonoCasa int(20),
telefonoMovil int(20),
correo varchar(100),
contraseña varchar(20),
estado int(11)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table aula(
gradog varchar(80),
secciong varchar(20),
usuarioP varchar(20),
cantMax int(11),
CONSTRAINT profe_foreana2 FOREIGN KEY (usuarioP) REFERENCES profesor(usuario) ON DELETE RESTRICT,
CONSTRAINT secc_foreana2 FOREIGN KEY (secciong) REFERENCES seccion(seccion) ON DELETE RESTRICT,
CONSTRAINT grado_foreana2 FOREIGN KEY (gradog) REFERENCES grado(grado) ON DELETE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table asignacionCurso(
cursod varchar(20) primary key,
profesord varchar(20),
CONSTRAINT curso_foreana1 FOREIGN KEY (cursod) REFERENCES curso(codCurso) ON DELETE RESTRICT,
CONSTRAINT profesor_foreana1 FOREIGN KEY (profesord) REFERENCES profesor(usuario) ON DELETE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE alumno (
  usuario varchar(20) NOT NULL PRIMARY KEY,
  nombreh varchar(200) ,
  apellidoh varchar(200) ,
  dnih varchar(20),
  direccionh varchar(200),
  gradoa varchar(80) ,
  secciona varchar(10),
  sexoh varchar(20) ,
  departamento varchar(200) ,   
  distrito varchar(200),
  obser text,
  edad int(11),
  nombrep varchar(200) ,
  apellidop varchar(200) ,
  dnip varchar(20),
  direccionp varchar(200),
  estadoCi varchar(80) ,
  sexop varchar(20) ,
  telefono int(11),
  contra varchar(60),
  estado int(11),
CONSTRAINT aula_fore1 FOREIGN KEY (gradoa) REFERENCES aula(gradog) ON DELETE RESTRICT,
CONSTRAINT aula_fore2 FOREIGN KEY (secciona) REFERENCES aula(secciong) ON DELETE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table nota(
idnota int(11) primary key,
usuarioA varchar(20),
usuarioP varchar(20),
noral int(11),
nprac int(11),
ntrab int(11),
ncuad int(11),
exbi int(11),
proce double,
prome double,
estado int(11),
CONSTRAINT alumno_foreana1 FOREIGN KEY (usuarioA) REFERENCES alumno(usuario) ON DELETE RESTRICT,
CONSTRAINT alumno_foreana2 FOREIGN KEY (usuarioP) REFERENCES profesor(usuario) ON DELETE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


