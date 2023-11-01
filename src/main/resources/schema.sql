-- Empleado
drop table EmpleadoNoDeportivo;
create table EmpleadoNoDeportivo(
	eid integer primary key autoincrement, 
	nombre varchar(30) not null, 
	apellido varchar(30) not null, 
	dni varchar(9) not null, 
	fechaNacimiento varchar(10) not null, 
	salarioAnual real not null, 
	telefono varchar(30) not null,
	posicion varchar(30) not null
);

drop table EmpleadoDeportivo;
create table EmpleadoDeportivo(
	eid integer primary key autoincrement,
	nombre varchar(30) not null, 
	apellido varchar(30) not null, 
	dni varchar(9) not null, 
	fechaNacimiento varchar(10) not null, 
	salarioAnual real not null, 
	telefono varchar(30) not null, 
	posicion varchar(30) not null
);

-- Jugador
drop table JugadorProfesional;
create table JugadorProfesional(
	eid integer primary key autoincrement, 
	nombre varchar(30) not null, 
	apellido varchar(30) not null, 
	dni varchar(9) not null, 
	fechaNacimiento varchar(10) not null, 
	salarioAnual real not null, 
	telefono varchar(30) not null,
    posicion varchar(30) not null
);

-- Horario Semanal
drop table HorarioSemanal;
create table HorarioSemanal(
    diaSemana int,
    fechaInicio varchar(10),
    fechaFin varchar(10),
    eid int not null,
    foreign key (eid) references EmpleadoNoDeportivo(eid),
    primary key (diaSemana, fechaInicio)
);

drop table FranjaSemanal;
create table FranjaSemanal(
    fsid integer primary key autoincrement,
    horaInicio varchar(5) not null,
    horaFin varchar(5) not null,
    diaSemana int not null,
    fechaInicio varchar(10) not null,
    foreign key (diaSemana, fechaInicio) references HorarioSemanal(diaSemana, fechaInicio)
);

-- Horario Puntual
drop table HorarioPuntual;
create table HorarioPuntual(
    fechaPuntual varchar(10) primary key,
    eid int not null,
    foreign key (eid) references EmpleadoNoDeportivo(eid)
);

drop table FranjaPuntual;
create table FranjaPuntual(
    fpid integer primary key autoincrement,
    horaInicio varchar(5) not null,
    horaFin varchar(5) not null,
    fechaPuntual varchar(10) not null,
    foreign key (fechaPuntual) references HorarioPuntual(fechaPuntual)
);

-- Horario Equipo
drop table HorarioEquipo;
create table HorarioEquipo(
	idEquipo varchar(30) not null,
	fecha varchar(10) not null,
	horaEntrada int not null,
	horaSalida int not null,
	minutoEntrada int not null,
	minutoSalida int not null,
	idInstalacion varchar(30) not null,
	primary key(idEquipo, fecha, horaEntrada),
    foreign key(idEquipo) references Equipo(id),
    foreign key(idInstalacion) references Instalacion(id)
);

drop table Equipo;
create table Equipo(
    id integer primary key autoincrement,
    nombre varchar(30),
    categoria varchar(30),
    esFilial boolean
);

-- Entrevista
drop table Entrevista;
create table Entrevista (
    fechaEntrevista varchar(10),
    horaInicio varchar(5),
    horaFin varchar(5),
    datosMedio varchar(30) not null,
    eid int,
    primary key (fechaEntrevista, horaInicio, horaFin)
    foreign key (eid) references JugadorProfesional(eid)
);

-- Reserva
drop table Reserva;
create table Reserva(
	nombreUsuario varchar(30) not null,
	cuentaBancaria varchar(30) not null,
	idInstalacion varchar(30) not null,
	precioReserva int not null,
	fechaReserva varchar(30) not null,
	horaEntrada int not null,
	horaSalida int not null,
	minutoEntrada int not null,
	minutoSalida int not null,
	fechaVenta varchar(10) not null,
	horaVenta int not null,
	minutoVenta int not null,
	primary key (nombreUsuario, fechaReserva, horaEntrada),
	foreign key (idInstalacion) references Instalacion(id)
);

-- Mercho
drop table Merchandaising;
create table Merchandaising(
	nombre varchar(30) primary key not null,
	tipo varchar(30) not null,
	precio double not null
);

-- Venta
drop table Venta;
create table Venta(
	id integer primary key autoincrement,
	concepto varchar(30) not null,
	fecha date not null,
	hora varchar(8) not null,
	minuto varchar(8) not null,
	cuantia real not null
);

-- Venta Mercho
drop table VentaMerchandising;
create table VentaMerchandising(
	id integer primary key autoincrement,
	concepto varchar(30) not null,
	fecha date not null,
	hora varchar(8) not null,
	minuto varchar(8) not null,
	cuantia real not null,
	producto varchar(30) not null,
	unidades int not null,
	precioPorProducto real,
	foreign key (id) references Venta(id)
);

--Entrada
drop table Entrada;
create table Entrada(
	tribuna varchar(30) not null,
	seccion varchar(30) not null,
	fila int not null,
	asiento int not null,
	precio int,
	check(precio=30),
	primary key(tribuna, seccion, fila, asiento)
);

--Instalaciones
drop table Instalacion;
create table Instalacion(
	id varchar(30) not null,
	nombreInstalacion varchar(30) not null,
	primary key (id)
);

--Abono
drop table Abono;
create table Abono(
	tribuna varchar(30) not null,
	seccion varchar(30) not null,
	fila int not null,
	asiento int not null,
	precio int,
	fechaCaducidad varchar(30) not null,
	primary key(tribuna, seccion, fila, asiento),
	foreign key (tribuna, seccion, fila, asiento) references Entrada(tribuna, seccion, fila, asiento)
);