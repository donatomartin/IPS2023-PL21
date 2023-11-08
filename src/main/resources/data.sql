delete from ampliacioncapital;
insert into ampliacioncapital(faseUno,faseDos,faseTres,capitalTotal,precioAccion,accionesTotales) values
	(0,0,0,1040.1,34.67,30);
	
delete from accionista;
insert into accionista(nombreAccionista,apellidoAccionista,dniAccionista,cuentaBancaria,numeroAcciones,porcentajeCapital) values
	('aaa', 'bbb', '1234K', 'abcd', 15, 50.0),
	('ccc', 'ddd', '5678X', 'efgh', 15, 50.0),
	('eee', 'fff', '9012Z', 'ijkl', 0, 0.0);
	
delete from accion;
insert into accion(idAccionista,precioCompra,enVenta,precioVenta) values
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(1, 34.67, 0, 34.67),
	(2, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67),
	(1, 34.67, 1, 34.67),
	(2, 34.67, 0, 34.67);