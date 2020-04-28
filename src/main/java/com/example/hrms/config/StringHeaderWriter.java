/**
 * @(#)StringHeaderWriter.java
 */
package com.example.hrms.config;

import java.io.IOException;
import java.io.Writer;
import org.springframework.batch.item.file.FlatFileHeaderCallback;

/**
 * CSV File Header Writer.
 * 
 * @author Su Su Paing
 *
 */
public class StringHeaderWriter implements FlatFileHeaderCallback {

    /**
     * Header String of the CSV file.
     */
    private final String header;

    /**
     * Arguments constructor of the String Header Class.
     * 
     * @param header String
     */
    StringHeaderWriter(String header) {
        this.header = header;
    }

    /**
     * Write Header to the CSV File.
     * 
     * @param writer Writer
     */
    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write(header);
    }
}