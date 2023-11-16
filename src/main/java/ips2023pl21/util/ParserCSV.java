package ips2023pl21.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import ips2023pl21.model.equipos.Partido;
import ips2023pl21.persistence.Persistence;

public class ParserCSV {

		Persistence p = Persistence.getInstance();
		
		public List<Partido> parsePartidosCSV(String archivo) throws FileNotFoundException, IOException, CsvValidationException{
			ArrayList<Partido> partidos = new ArrayList<>();
			
			CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
			try (CSVReader reader = new CSVReaderBuilder(new FileReader(archivo)).withCSVParser(csvParser).build()) {
				String[] lineInArray;
				while ((lineInArray = reader.readNext()) != null) {
					Partido p = new Partido();
					p.setId(UUID.randomUUID().toString());
					System.out.println(lineInArray[0]);
					System.out.println(lineInArray[1]);
					System.out.println(lineInArray[2]);
					System.out.println(lineInArray[3]);
					
					partidos.add(p);
				}
			}
//			Partido par = new  Partido();
//			
//			EquipoDeportivo e = p.selectEquipoPorNombre("Sporting");
//			
//			par.setId(UUID.randomUUID().toString());
//			par.setLocal(e);
//			par.setVisitante("prueba csv");
//			par.setFecha("1-1-1");
//			par.setSuplemento(999);
//			
//			partidos.add(par);
			return partidos;
		}
}
