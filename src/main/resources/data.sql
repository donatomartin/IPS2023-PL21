--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:
	
delete from empleado;
insert into empleado(id,nombre,apellido,dni,fechaNacimiento,salarioAnual,telefono) values
	(1,'aaa','bbb','12345678K','1985-02-04',10000000, '1234567890'),
	(2,'ccc','ddd', '12345678K','1985-02-04',10000000, '1234567890');
	
delete from empleadodeportivo;
insert into empleadodeportivo(id,nombre,apellido,dni,fechaNacimiento,salarioAnual,telefono,posicion) values
	(3, 'eee','fff','12345678K','1985-02-04',10000000, '1234567890', 'Delantero');

delete from merchandaising;
insert into merchandaising(nombre,tipo,precio) values ('Gorra','Ropa',10);
insert into merchandaising(nombre,tipo,precio) values ('Balon','Material',20);
insert into merchandaising(nombre,tipo,precio) values ('Poster','Decoracion',5);
insert into merchandaising(nombre,tipo,precio) values ('Bufanda','Ropa',10);
insert into merchandaising(nombre,tipo,precio) values ('Camiseta','Ropa',20);
insert into merchandaising(nombre,tipo,precio) values ('Cono','Material',5);