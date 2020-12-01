/* Creación de Base de datos */

CREATE DATABASE FutbolDB;
USE FutbolDB;

/* Creación de Tablas */

CREATE TABLE Ligas (codLiga char(5) primary key, nomLiga varchar(50));

CREATE TABLE Equipos (codEquipo integer AUTO_INCREMENT PRIMARY KEY, nomEquipo varchar(40), codLiga char(5) DEFAULT 'PDN',
localidad varchar(60), internacional tinyint(1) default 0,
FOREIGN KEY (codLiga) REFERENCES Ligas(codLiga));

create table Futbolistas (codDNIoNIE char(9) PRIMARY KEY, nombre varchar(50), nacionalidad varchar(40));

create table Contratos (codContrato integer AUTO_INCREMENT PRIMARY KEY, codDNIoNIE char(9), codEquipo integer, 
fechaInicio date, fechaFin date, precioAnual integer, precioRecision integer,
FOREIGN KEY (codEquipo) REFERENCES Equipos(codEquipo),
FOREIGN KEY (codDNIoNIE) REFERENCES Futbolistas(codDNIoNIE)
);

CREATE TABLE EquiposObservaciones (codEquipo Integer PRIMARY KEY,observaciones varChar(200), 
FOREIGN KEY (codEquipo) REFERENCES Equipos(codEquipo));

-- Inserciones 
insert into ligas values ('PDN', 'Primera División Nacional');
insert into ligas values ('SDN', 'Segunda División Nacional');
insert into ligas values ('PDF', 'Primera División de la Federación');
insert into ligas values ('SDF', 'Segunda División de la Federación');
insert into ligas values ('TDF', 'Tercera División de la Federación');

insert into equipos values (null,'Equipo1', default, 'Santa Cruz', 1);
insert into equipos values (null,'Equipo2', 'SDN', 'Los Sauces', 0);
insert into equipos values (null,'Equipo3', 'SDN', 'La Orotava', 1);
insert into equipos values (null,'Equipo4', 'PDF', 'La Victoria', 1);
insert into equipos values (null,'Equipo5', 'SDF', 'Los Abrigos', 0);
insert into equipos values (null,'Equipo6', 'TDF', 'Las Galletas', 0);

insert into futbolistas values ('745F', 'Sergio Ramos', 'Española');
insert into futbolistas values ('X65R', 'Thomas Muller', 'Alemana');
insert into futbolistas values ('F85H', 'Alan Shearer', 'Inglesa');
insert into futbolistas values ('399S', 'Xavi Hernández', 'Española');
insert into futbolistas values ('J96A', 'David Beckham', 'Inglesa');

insert into contratos values (null,'745F', 3, '2018-11-08', '2019-04-06', 12369, 123535);
insert into contratos values (null,'745F', 6, '2012-02-11', '2020-06-04', 15987, 125653);
insert into contratos values (null,'F85H', 5, '2010-12-01', '2015-06-04', 17896, 125635);
insert into contratos values (null,'F85H', 4, '2013-02-10', '2015-12-06', 12896, 14863);
insert into contratos values (null,'399S', 1, '2011-09-10', '2013-12-08', 1789, 14341);
insert into contratos values (null,'J96A', 2, '2019-09-10', '2025-12-08', 1789, 14123);

insert into EquiposObservaciones values (1,'El mejor equipo Tenerife');
insert into EquiposObservaciones values (2,'Equipo de La Palma');
insert into EquiposObservaciones values (3,'El norte de Tenerife');
