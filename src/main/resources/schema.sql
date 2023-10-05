--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:

drop table if exists Empleado;
create table Empleado(
	id int primary key not null, 
	nombre varchar(30) not null, 
	apellido varchar(30) not null, 
	dni varchar(9) not null, 
	fechaNacimiento varchar(10) not null, 
	salarioAnual real not null, 
	telefono varchar(30) not null, 
	check(salarioAnual>0)
);

drop table EmpleadoDeportivo;
create table EmpleadoDeportivo(
	id int primary key not null, 
	nombre varchar(30) not null, 
	apellido varchar(30) not null, 
	dni varchar(9) not null, 
	fechaNacimiento varchar(10) not null, 
	salarioAnual real not null, 
	telefono varchar(30) not null, 
	posicion varchar(30) not null, 
	foreign key (id) references Empleado(id), 
	check(salarioAnual>0)
);
