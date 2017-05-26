package Converter;


import Component.CsvReader;
import Component.Parser;
import Component.XlsWriter;

import java.util.List;

/**
 * Created by toprak.ucar on 26/05/2017.
 */
public class CsvToXls {
    private final CsvReader reader;
    private final XlsWriter writer;

    public CsvToXls() {
        reader = new CsvReader();
        writer = new XlsWriter();
    }

    public void convertCsvToXlsAndSave(String csvFile, String xlsFile){
        List<String> lines = reader.read(csvFile);
        List<List<String>> rows = Parser.parseToFields(lines);
        writer.writeToXlsFile(xlsFile, rows);
    }
}
