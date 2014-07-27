/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class FieldFileReader {

    private final String separator;
    private final File file;
    private BufferedReader reader;

    public FieldFileReader(String fileName, String separator) throws FileNotFoundException {
        this.file = new File(fileName);
        this.reader = new BufferedReader(new FileReader(file));
        this.separator = separator;
    }

    public boolean reopen() throws FileNotFoundException {
        if (reader == null) {
            this.reader = new BufferedReader(new FileReader(file));
            return true;
        } else {
            return false;
        }

    }

    public String[] readFields() throws IOException {
        if (reader == null) {
            return null;
        }
        String line = reader.readLine();
        if (line == null) {
            reader.close();
            reader = null;
            return null;
        }
        String[] fields = line.split(separator);
        return fields;
    }
}
