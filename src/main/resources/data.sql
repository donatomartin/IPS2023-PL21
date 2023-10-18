--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:
	
delete from empleado;
insert into empleado(id,nombre,apellido,dni,fechaNacimiento,salarioAnual,telefono) values
	(1,'aaa','bbb','12345678K','1985-02-04',10000000, '1234567890'),
	(2,'ccc','ddd', '12345678K','1985-02-04',10000000, '1234567890');
	
delete from empleadodeportivo;
insert into empleadodeportivo(id,nombre,apellido,dni,fechaNacimiento,salarioAnual,telefono,posicion) values
	(3, 'eee','fff','12345678K','1985-02-04',10000000, '1234567890', 'Delantero');
	
delete from venta;
insert into venta(id, concepto, fecha, hora, minuto, cuantia) VALUES (1,'merchandising', '2023-10-13', '20','05',30),
(2,'entradas', '2020-02-04','20','20',20),
(3, 'merchandising','2013-02-02','20','00',50),
(4, 'reserva','2013-09-09','21','11',30);

delete from ventaMerchandising;
insert into ventaMerchandising(id, concepto, fecha, hora, minuto, cuantia, producto, unidades, precioPorProducto) VALUES
(1,'merchandising','2023-10-13', '20','05',30, 'camiseta', 3,10),
(3, 'merchandising','2013-02-02','20','00',50,'pantalon',5,10);