--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:
	
delete from empleadonodeportivo;
insert into empleadonodeportivo(nombre,apellido,dni,fechaNacimiento,salarioAnual,telefono) values
	('aaa','zzz','12345678K','1985-02-04',10000000, '1234567890'),
	('ccc','yyy', '12345678K','1985-02-04',10000000, '1234567890'),
	('bbb','xxx','12345678K','1985-02-04',10000000, '1234567890'),
	('ddd','www', '12345678K','1985-02-04',10000000, '1234567890');
	
delete from empleadodeportivo;
insert into empleadodeportivo(nombre,apellido,dni,fechaNacimiento,salarioAnual,telefono,posicion) values
	('eee','fff','12345678K','1985-02-04',10000000, '1234567890', 'Delantero'),
	('ggg','hhh','12345678K','1985-02-04',10000000, '1234567890', 'Delantero'),
	('iii','jjj','12345678K','1985-02-04',10000000, '1234567890', 'Delantero');