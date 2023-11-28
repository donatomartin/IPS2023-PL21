-- Empleado
drop table Empleado;
create table Empleado(
	eid integer primary key autoincrement, 
	nombre varchar(30) not null, 
	apellido varchar(30) not null, 
	dni varchar(9) not null, 
	fechaNacimiento varchar(10) not null, 
	salarioAnual real not null, 
	telefono varchar(30) not null,
	tipo varchar(30) not null,
	posicion varchar(30) not null
);

-- Horario Semanal
drop table HorarioSemanal;
create table HorarioSemanal(
    diaSemana int not null,
    fechaInicio varchar(10) not null,
    fechaFin varchar(10),
    eid int not null,
    primary key (diaSemana, fechaInicio, eid),
    foreign key (eid) references Empleado(eid)
);

drop table FranjaSemanal;
create table FranjaSemanal(
    horaInicio varchar(5) not null,
    horaFin varchar(5) not null,
    diaSemana int not null,
    fechaInicio varchar(10) not null,
	eid int not null,
	check (horaInicio != horaFin),
	primary key (diaSemana, eid, fechaInicio, horaInicio, horaFin),
    foreign key (diaSemana, fechaInicio, eid) references HorarioSemanal(diaSemana, fechaInicio, eid)
);

-- Horario Puntual
drop table HorarioPuntual;
create table HorarioPuntual(
    fechaPuntual varchar(10) not null,
    eid int not null,
	primary key (fechaPuntual, eid),
    foreign key (eid) references Empleado(eid)
);

drop table FranjaPuntual;
create table FranjaPuntual(
    horaInicio varchar(5) not null,
    horaFin varchar(5) not null,
    fechaPuntual varchar(10) not null,
	eid int not null,
	check (horaInicio != horaFin),
	primary key (fechaPuntual, eid, horaInicio, horaFin),
    foreign key (fechaPuntual, eid) references HorarioPuntual(fechaPuntual, eid)
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

-- Horario Entrevista
drop table HorarioEntrevista;
create table HorarioEntrevista(
	fechaEntrevista varchar(10) not null,
    horaInicio varchar(5) not null,
    horaFin varchar(5) not null,
    datosMedio varchar(30),
    eid int,
	check (horaInicio != horaFin),
    primary key (fechaEntrevista, eid),
    foreign key (eid) references Empleado(eid)
);

-- Horario Jardineria
drop table HorarioJardineria;
create table HorarioJardineria(
	fechaJardineria varchar(10) not null,
    horaInicio varchar(5) not null,
    horaFin varchar(5) not null,
    iid int not null,
    eid int not null,
	check (horaInicio != horaFin),
    primary key(fechaJardineria, eid, iid),
    foreign key(eid) references Empleado(eid),
	foreign key(iid) references Instalacion(id)
);

-- HorarioEntrenamiento
drop table HorarioEntrenamiento;
create table HorarioEntrenamiento(
	id integer primary key autoincrement,
	fechaEntrenamiento varchar(10) not null,
	horaInicio varchar(5) not null,
	horaFin varchar(5) not null,
	enid int not null,
	iid int not null,
	eid int not null,
	check (horaInicio != horaFin),
	unique (fechaEntrenamiento, enid, iid, eid),
	foreign key(enid) references Empleado(eid),
	foreign key(iid) references Instalacion(id),
	foreign key(eid) references Equipo(id)
);

-- Partido
drop table Partido;
create table Partido(
	id varchar(30) primary key,
	idEquipo varchar(30),
	equipoVisitante varchar(30),
	fecha varchar(10),
	suplemento real,
	foreign key(idEquipo) references Equipo(id)
);

-- PartidoAbonado
drop table PartidoAbonado;
create table PartidoAbonado(
	idAbonado varchar(30),
	idPartido varchar(30),
	primary key(idAbonado, idPartido),
	foreign key(idAbonado) references Abonado(id),
	foreign key(idPartido) references Partido(id)
);

-- Abonado
drop table Abonado;
create table Abonado(
	id integer primary key autoincrement,
	nombre varchar(70)
);

-- Equipo
drop table Equipo;
create table Equipo(
    id integer primary key autoincrement,
	peid int,
	seid int,
    nombre varchar(30) unique not null,
    categoria varchar(30),
    esFilial boolean,
	foreign key (peid) references Empleado(eid),
	foreign key (peid) references Empleado(eid) 
);

-- Juega
drop table Juega;
create table Juega(
	eqid int not null,
	eid int not null,
	primary key (eqid, eid),
	foreign key (eqid) references Equipo(id),
	foreign key (eid) references Empleado(eid)
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
	id int primary key,
	nombre varchar(30),
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

-- VentaMercho
drop table VentaMerchandising;
create table VentaMerchandising(
	id varchar(30) not null,
	idProducto int not null,
	cantidad int,
	primary key(id, idProducto)
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
	id integer primary key autoincrement,
	nombreInstalacion varchar(30) not null
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

--Noticia
drop table Noticia;
create table Noticia(
	id integer primary key autoincrement,
	titulo varchar(30) not null,
	subtitulo varchar(300) not null,
	cuerpo varchar(500) not null,
	img varchar(30)
);

--Accionista
drop table Accionista;
create table Accionista(
	idAccionista integer primary key autoincrement,
	nombreAccionista varchar(30) not null,
	apellidoAccionista varchar(30) not null,
	dniAccionista varchar(30) not null,
	cuentaBancaria varchar(30) not null,
	numeroAcciones int not null,
	limiteAccionesFaseUno int,
	porcentajeCapital float not null
);

--Acciones propiedad
drop table Accion;
create table Accion(
	idAccion integer primary key autoincrement,
	idAccionista integer not null,
	precioCompra float not null,
	enVenta int CHECK (enVenta IN (0, 1)) not null,
	precioVenta float not null,
	foreign key (idAccionista) references Accionista(idAccionista)
);

--Ampliaciones de capital
drop table AmpliacionCapital;
create table AmpliacionCapital(
	idAmpliacion integer primary key autoincrement,
	faseUno int not null,
	faseDos int not null,
	faseTres int not null,
	capitalTotal float not null,
	accionesTotales int not null,
	precioAccion float not null, 
	fase varchar(30) not null,
	vendidas int not null
);

-- Usuario
drop table Usuario;
create table Usuario(
	usuario varchar(30) primary key,
	contrasena varchar(500) not null,
	rol varchar(30) not null,
	pid integer not null
);

--Lesiones
drop table Lesion;
create table Lesion(
	id integer primary key autoincrement,
	eid integer not null,
	causa varchar(30) not null,
	pid integer,
	enid integer,
	descripcion varchar(500),
	fecha varchar(10),
	foreign key (eid) references Empleado(eid),
	foreign key (pid) references Partido(id),
	foreign key (enid) references HorarioEntrenamiento(enid)
);

--Actualizacion
drop table actualizacion;
create table Actualizacion(
	id integer primary key autoincrement,
	eid integer not null,
	texto varchar(500) not null
);

--Compra
drop table Compra;
create table Compra(
	id integer primary key autoincrement,
	cuantia int not null,
	fecha date not null
);
