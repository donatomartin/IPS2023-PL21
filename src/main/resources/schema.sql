--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
drop table Carreras if exists Carreras;

--------------------------------------------------------
drop table Empleado;
create table Empleado (id int primary key not null autoincrement, 
nombre varchar(30) not null, apellido varchar(30) not null, dni varchar(9) not null, 
fechaNacimiento date not null, salarioAnual real not null, telefono varchar(30) not null, 
check(salarioAnual>0));

drop table EmpleadoDeportivo;
create table EmpleadoDeportivo(id int primary key not null autoincrement, 
nombre varchar(30) not null, apellido varchar(30) not null, dni varchar(9) not null, 
fechaNacimiento date not null, salarioAnual real not null, telefono varchar(30) not null, 
posicion varchar(30) not null, foreign key (id) references Empleado(id), check(salarioAnual>0));

drop table Jugador;
create table Jugador();

drop table Tecnico;
create table Tecnico();

drop table EmpleadoNoDeportivo;
create table EmpleadoNoDeportivo(id int primary key not null autoincrement, 
nombre varchar(30) not null, apellido varchar(30) not null, dni varchar(9) not null, 
fechaNacimiento date not null, salarioAnual real not null, telefono varchar(30) not null,
horaInicio time, horaFin time, diasSemana int, horasSemanales int,
foreign key (id) references Empleado(id), check(salarioAnual>0), 
check(strftime('%s', horaFin) - strftime('%s', horaInicio) < 10), check(horasSemanales<40));

drop table Equipo;
create table Equipo();

drop table EquipoProfesional;
create table EquipoProfesional();

drop table EquipoPrincipal;
create table EquipoPrincipal();

drop table EquipoFilial;
create table EquipoFilial();

drop table EquipoFormacion;
create table EquipoFormacion();

drop table Entrada;
create table Entrada();

drop table Reserva;
create table Reserva();

drop table Venta;
create table Venta();

drop table Merch;
create table Merch();

drop table Entrevista;
create table Entrevista();
