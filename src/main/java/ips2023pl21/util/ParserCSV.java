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

import ips2023pl21.model.equipos.EquipoDeportivo;
import ips2023pl21.model.equipos.Partido;
import ips2023pl21.persistence.Persistence;

public class ParserCSV {

		Persistence p = Persistence.getInstance();
		
		@SuppressWarnings("rawtypes")
		public List<List> parsePartidosCSV(String archivo) throws FileNotFoundException, IOException, CsvValidationException{
			List<List> ret = new ArrayList<>();
			List<Partido> partidos = new ArrayList<>();
			List<String> fallos = new ArrayList<>();
			
			CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
			try (CSVReader reader = new CSVReaderBuilder(new FileReader(archivo)).withCSVParser(csvParser).withSkipLines(1).build()) {
				String[] lineInArray;
				int countFilas = 1;
				while ((lineInArray = reader.readNext()) != null) {
					countFilas++;
					
					Partido par = new  Partido();
					
					if(lineInArray[2]!= null && p.selectEquipoPorNombre(lineInArray[2]) != null) {
						EquipoDeportivo e = p.selectEquipoPorNombre(lineInArray[2]);
						par.setId(UUID.randomUUID().toString());
						par.setLocal(e);
						
						if(!lineInArray[3].isBlank()) {
							par.setVisitante(lineInArray[3]);
							
							if(!lineInArray[0].isBlank() && fechaValida(lineInArray[0])) {
								par.setFecha(lineInArray[0]);
								
								if(!lineInArray[4].isBlank() && suplementoValido(Float.parseFloat(lineInArray[4]))) {
									par.setSuplemento(Float.parseFloat(lineInArray[4]));
									
									partidos.add(par);
								} else {
									fallos.add("Fallo en fila " + countFilas + " suplemento no valido");
								}
							} else {
								fallos.add("Fallo en fila " + countFilas + " fecha no valida");
							}
						} else {
							fallos.add("Fallo en fila " + countFilas + " Equipo visitante no valido");
						}
					} else {
						fallos.add("Fallo en fila " + countFilas + " Equipo local no valido");
					}
				}
			}

			ret.add(partidos);
			ret.add(fallos);
			
			return ret;
		}

		private boolean suplementoValido(float f) {
			return f >= 0 ? true : false;
		}

		private boolean fechaValida(String fecha) {
			if(fecha.length() != 10) {
				return false;
			}
			
			String[] fechaTokens = fecha.split("-");
			if(fechaTokens.length != 3) {
				return false;
			}
			if(fechaTokens[0].length() != 4) {
				return false;
			}
			if(fechaTokens[1].length() != 2) {
				return false;
			}
			if(fechaTokens[2].length() != 2) {
				return false;
			}

			return true;
		}
}
