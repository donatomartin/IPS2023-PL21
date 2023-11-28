package ips2023pl21.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private String name;
    private Date date;

    public Logger(String name) {
        this.name = name;
        this.date = new Date();
    }

    public void logMessage(String message) {
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
}