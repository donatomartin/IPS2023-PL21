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
	precioAccion float not null
);