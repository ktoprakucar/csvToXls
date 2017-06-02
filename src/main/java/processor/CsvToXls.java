package processor;


import component.CsvReader;
import component.Parser;
import component.XlsWriter;

import java.io.File;
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

    public File convertCsvToXlsAndSave(String csvFile, String xlsFile){
        List<String> lines = reader.read(csvFile);
        List<List<String>> rows = Parser.parseToFields(lines);
        return writer.writeToXlsFile(xlsFile, rows);
    }
}
