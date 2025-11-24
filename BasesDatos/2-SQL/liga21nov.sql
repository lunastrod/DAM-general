use ligabaloncesto;
-- ¿Cuántos jugadores tiene cada equipo?
SELECT idEquipo, COUNT(*) AS "Total jugadores por equipo" FROM jugador GROUP BY idEquipo;
-- Obtén la suma de las edades de los jugadores por equipo.
SELECT idEquipo, SUM(edad) AS "Total edad por equipo" FROM jugador GROUP BY idEquipo;
-- Obtén la edad promedio de los jugadores por equipo.
-- ¿Cuál es el salario más bajo registrado en la tabla de jugadores?


/*
1. Jugadores del equipo 102 ordenados por apellido y conteo total
Muestra los datos de los jugadores que pertenecen al equipo 102
ordenados por apellido, y adicionalmente indica cuántos jugadores
tiene ese equipo.
*/
select * from jugador where idEquipo=102 order by apellido;
select COUNT(*) as "Jugadores equipo 102" from jugador where idEquipo=102;

/*
2. Jugadores pívot ordenados por id y salario promedio del puesto
Obtén los datos de los jugadores cuya posición sea pívot, ordenados
por id, e incluye el salario promedio de todos los jugadores que
juegan en esa misma posición.
*/
select * from jugador where posicion="Pivot" order by idJugador;
select avg(salarioBruto) as "salario medio pivot" from jugador where posicion="Pivot";

/*
3. Jugadores que midan más de 1.80 m y ganen menos de 2000 €,
junto con edad máxima y mínima del grupo
Selecciona los jugadores que cumplan estas condiciones y muestra
también la edad máxima y mínima dentro de ese subconjunto.
*/
select * from jugador where altura>1.8 && salarioBruto<2000;
select max(edad),min(edad) from jugador where altura>1.8 && salarioBruto<2000;

/*
4. Partidos jugados en marzo y total de goles marcados en ese mes
Muestra todos los partidos disputados en marzo y calcula el total de
goles marcados (local + visitante) durante ese mes.
*/
select * from partido where month(fecha)=10;-- no hay ninguno en marzo así que he puesto mes 10
-- TODO: numero goles

/*
5. Jugadores de los equipos 103 y 104 que ganen más de 2100 €,
incluyendo salario promedio por equipo
Muestra los jugadores que cumplan esta condición y calcula el
salario promedio del equipo al que pertenecen.
BASE DE DATOS - DAM 1
*/
select * from jugador where (idEquipo=103 || idEquipo=104) && salarioBruto>2100;
select idEquipo,avg(salarioBruto) as "salario medio equipo" from jugador where idEquipo=103 || idEquipo=104 GROUP BY idEquipo;

/*
6. Equipos cuya web no contenga “www” y
cantidad de jugadores que tienen registrados
Lista los nombres de los equipos cuya página web no incluya la
palabra “www” y muestra cuántos jugadores tiene cada uno.
*/
select * from equipo where webOficial not regexp "www";
select COUNT(*) as "Jugadores equipo sin www" from jugador where idEquipo=(select idEquipo from equipo where webOficial not regexp "www") GROUP BY idEquipo;

/*
7. Equipos cuya web termine en ‘.com’ y salario total de sus jugadores
Muestra el nombre de los equipos y la suma total del salario de
todos sus jugadores si su web finaliza en “.com”.
*/
select * from equipo where webOficial regexp ".com$";

/*

8. Promedio de goles por partido en un año específico
Muestra todos los partidos jugados durante el año 2024 (o el año
que tú uses en tu BD) y calcula el promedio total de goles por partido
(goles_local + goles_visitante) en ese año.
*/

/*
9. Equipos con más de 5 jugadores y edad promedio del plantel
Muestra los equipos que tengan más de 5 jugadores y calcula la edad
promedio de sus jugadores.
*/

/*
10.Equipos que hayan anotado más de 10 goles en total como locales
(usando SUM + HAVING)
Suma los goles marcados por cada equipo cuando jugó como local y
muestra solo los equipos que superen los 10 goles.
*/

/*
11.Jugadores ordenados por fecha de nacimiento y conteo por década
Lista a los jugadores ordenados por su fecha de nacimiento y,
además, muestra cuántos jugadores nacieron en cada década
(1980s, 1990s, 2000s, etc.).
*/

/*
12.Edad promedio de jugadores por posición, mostrando solo las
posiciones cuyo promedio supere los 25 años
Agrupa a los jugadores por su posición, calcula la edad promedio y
muestra únicamente aquellas posiciones en las que dicho promedio
supere los 25 años.
*/