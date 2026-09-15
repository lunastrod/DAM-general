drop database if exists LigaBaloncesto;
create database LigaBaloncesto;
use LigaBaloncesto;

create table Equipo(
	idEquipo int primary key,
    
    nombreEquipo varchar(50),
    ciudad varchar(50),
    webOficial varchar(100),
    puntos int
);

create table Jugador(
	idJugador int primary key,
    
    idCapitan int,
    idEquipo int,
    foreign key (idCapitan) references Jugador(idJugador),
    foreign key (idEquipo) references Equipo(idEquipo),
    
    nombre varchar(20),
    apellido varchar(20),
    posicion varchar(20),
    fechaAlta date,
    salarioBruto float,
    altura float
);

create table Partido(
	elocal int,
    evisitante int,
    fecha date,
    foreign key (elocal) references Equipo(idEquipo),
    foreign key (evisitante) references Equipo(idEquipo),
    primary key (elocal,evisitante,fecha),
	resultado varchar(20),
    arbitro	int
);

INSERT INTO Equipo (idEquipo, nombreEquipo, ciudad, webOficial, puntos) VALUES
(101, 'FC Barcelona Básquet', 'Barcelona', 'https://www.fcbarcelona.com', 10),
(102, 'Real Madrid', 'Madrid', 'https://www.realmadrid.com', 9),
(103, 'Valencia Basket Club', 'Valencia', 'https://www.valenciabasket.com', 11),
(104, 'Casademont Zaragoza', 'Zaragoza', 'https://www.casademontzgz.es', 24),
(105, 'Club Baloncesto Gran Canaria', 'Las Palmas', 'https://cbgrancanaria.net', 14),
(106, 'Saski Baskonia', 'Vitoria', 'https://www.baskonia.com', 22);

INSERT INTO Jugador (idJugador, idCapitan, idEquipo, nombre, apellido, posicion, fechaAlta, salarioBruto, altura) VALUES
(17, 17, 101, 'Fiorella Ruth', 'ALBÚJAR ALBINO', 'Alero', '2025-03-30', 2200, 1.60),
(12, 17, 101, 'David', 'MARTÍNEZ GALLEGO', 'Escolta', '2025-03-31', 1900, 1.60),
(6, 17, 101, 'Stiv Brandon', 'GAVIRIA RAMOS', 'Pivot', '2023-11-29', 2300, 1.87),

(16, 16, 102, 'Ana Belén', 'RUEDA REINA', 'Escolta', '2023-11-02', 2200, 1.65),
(9, 16, 102, 'Zoe Mariel', 'JASTREB', 'Alero', '2023-10-30', 1800, 1.61),
(3, 16, 102, 'Adonis David', 'CARPIO ROMERO', 'Base', '2024-03-01', 1700, 1.90),

(8, 8, 103, 'Miguel Nicolás', 'GÓMEZ PEARSON', 'Escolta', '2024-02-27', 2200, 1.79),
(2, 8, 103, 'Yeray', 'ARIAS BETHENCOURT', 'Pivot', '2024-09-02', 2300, 1.80),
(14, 8, 103, 'Daniel', 'PARRA SEGOVIA', 'Pivot', '2025-01-10', 2300, 1.74),

(4, 4, 104, 'Gabriel', 'FERNÁNDEZ CAÑADAS', 'Escolta', '2023-04-01', 2200, 1.82),
(7, 4, 104, 'Inmaculada', 'GIL ESCRIBANO', 'Base', '2024-01-28', 1700, 1.65),
(10, 4, 104, 'Jaime', 'LIZARZA ARNANZ', 'Pivot', '2024-11-21', 2300, 1.89),

(19, 19, 104, 'Luz Adriana', 'Perdomo', 'Alero', '2025-05-19', 2200, 1.60),
(15, 19, 104, 'Juan Antonio', 'ROS FERNÁNDEZ', 'Base', '2025-01-19', 1700, 1.75),
(20, 19, 104, 'Carlos', 'Elvira', 'Escolta', '2024-01-31', 1900, 1.70),

(1, 1, 105, 'Alejandro', 'ARAGON ESPINOZA', 'Alero', '2025-10-12', 1800, 1.90),
(13, 1, 105, 'David', 'MORENO SORIANO', 'Pivot', '2025-03-30', 2300, 1.70),
(11, 1, 105, 'Luis Daniel', 'LOPEZ MILICIA', 'Base', '2024-04-07', 1700, 1.73),
(18, 1, 105, 'Maria Pilar', 'Martin Gomez', 'Pivot', '2025-03-11', 2300, 1.60),
(5, 1, 105, 'Hugo', 'GARCÍA SALAZAR', 'Alero', '2023-09-10', 1800, 1.72);


INSERT INTO Partido (elocal, evisitante, fecha, resultado, arbitro) VALUES
(101, 102, '2025-10-04', '100-100', 4),
(102, 103, '2025-10-04', '90-91', 5),
(103, 104, '2025-10-11', '88-77', 6),
(101, 105, '2025-10-18', '66-78', 6),
(102, 104, '2025-10-25', '90-90', 7),
(103, 105, '2025-11-01', '79-93', 3),
(104, 105, '2025-11-08', '91-99', 2),
(105, 102, '2025-11-08', '90-66', 1),
(101, 104, '2025-11-15', '110-70', 2);




/*Ordene toda la tabla de los jugadores por nombre.
Ahora por apellido.
Seleccione los nombres, equipos y posición de los jugadores y ordénelos por posición y equipo.
Ahora organízalos de forma ascendente por su posición.
Seleccione los distintos equipos que existen en la tabla jugador.
Obtén los datos de los 5 jugadores mas antiguos*/

/*select nombre as "Nombre Jugador" from Jugador;
select nombre as "Nombre Jugador" from Jugador;
select nombre as "Nombre Jugador" from Jugador order by nombre asc;
select distinct idEquipo from jugador;
select * from jugador limit 5;
select * from jugador order by nombre asc limit 5;*/

select * from Jugador order by nombre asc;
select * from Jugador order by apellido asc;
select nombre,idEquipo,posicion from Jugador order by posicion,idEquipo asc;
select nombre,idEquipo,posicion from Jugador order by posicion asc;
select distinct idEquipo from jugador;
select * from Jugador order by fechaAlta limit 5;