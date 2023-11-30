package ips2023pl21.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private String name;
    private Date date;

    
    public Logger() {
    	this("System");
    }
    
    public Logger(String name) {
        this.name = name;
        this.date = new Date();
    }

    private void logMessage(String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        String dateString = formatter.format(date);
        String logMessage = "[" + dateString + "] : " + message;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log/" + name + " - " + dateString + ".log", true))) {
            writer.write(logMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void logSelect(String tableName) {
    	logMessage("(SELECT) Obtenidos elementos de la tabla " + tableName + ". ");
    }
    
    public void logInsert(String tableName, String infoInsertado) {
    	logMessage("(INSERT) Insertado elemento en la tabla " + tableName + ". Nuevo " + infoInsertado +".");
    }
    
    public void logDelete(String tableName, String infoBorrado) {
    	logMessage("(DELETE) Borrado elemento de la tabla " + tableName + ". Eliminado " + infoBorrado +".");
    }
    
    public void logUpdate(String tableName, String infoAcualizado, String paramsActualizados) {
    	logMessage("(UPDATE) Borrado elemento de la tabla " + tableName + ". Actualizado " + infoAcualizado +". Parametros actualizados: " + paramsActualizados + ".");
    }
    
}