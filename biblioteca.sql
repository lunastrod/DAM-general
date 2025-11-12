drop database if exists biblioteca;
create database biblioteca;
use biblioteca;

create table Autor (
	idAutor int primary key,
    nombreAutor varchar(40) not null,
    apellidoAutor varchar(40),
    ciudadAutor varchar(40)
);

create table Editorial (
	idEditorial int primary key
);

create table Libro (
	idLibro int primary key,
    nomLibro varchar(40) not null,
    idAutor int,
    idEditorial int,
    publicacionLibro date,
    foreign key (idAutor) references Autor(idAutor),
    foreign key (idEditorial) references Editorial(idEditorial)
);

create table Usuario (
	idUsuario int primary key,
	nombreUsuario varchar(40) not null,
    apellidoUsuario varchar(40),
    telefonoUsuario varchar(40)
);

create table Prestamo (
	idPrestamo int primary key,
    idLibro int,
    idUsuario int,
    fechaInicio date,
    fechaFin date,
    foreign key (idLibro) references Libro(idLibro),
    foreign key (idUsuario) references Usuario(idUsuario)
);

insert into Autor values(105,"Pepe","García","Madrid");
insert into Autor values(106,"Luis","García","Madrid");
insert into Autor values(107,"Hugo","García","Madrid");
insert into Autor values(108,"Zoe","Jastreb","Madrid");
insert into Usuario values(109,"Daniel","Parra","91231823");
insert into Usuario values(110,"Ana","Rueda","91231823");
insert into editorial values(1);
INSERT INTO Libro VALUES (501,'Cien años de soledad',105,1,'1967-05-30');
INSERT INTO Libro VALUES (1501,'Mil años de soledad',105,1,'1967-05-30');
insert into prestamo values (1,501,109, "2025-05-30","2025-07-30");
SELECT * FROM biblioteca.autor;
select * from biblioteca.prestamo;