package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Records {

    private File file;
    private DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
    private LocalDateTime currentDateTime = LocalDateTime.now();



    public Records(String nameOfFile) {
        this.file = new File(nameOfFile);
    }
    public void writeToFile(String lineOfText) {
        PrintWriter printWriter = null;
        if (this.file.exists()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                printWriter = new PrintWriter(fileOutputStream);
                currentDateTime = LocalDateTime.now();
                printWriter.println(">" + currentDateTime.format(targetFormat) + lineOfText);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                printWriter = new PrintWriter(this.file);
                currentDateTime = LocalDateTime.now();
                printWriter.println(">" + currentDateTime.format(targetFormat) + lineOfText);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        printWriter.flush();
        printWriter.close();
    }
}


