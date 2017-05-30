package component;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.BaseNumberUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by toprak.ucar on 26/05/2017.
 */
public class XlsWriter {
    HSSFWorkbook workbook;
    HSSFSheet sheet;
    Converter converter;
    ;

    public XlsWriter() {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("iyziSheet");
        converter = new Converter();
    }

    public void writeToXlsFile(String fileName, List<List<String>> rows) {
        int rowNumber = 0;
        int cellNumber;
        Row row;
        for (List<String> data : rows) {
            row = sheet.createRow(rowNumber++);
            cellNumber = 0;
            for (String field : data) {
                Cell cell = row.createCell(cellNumber++);
                if (isNumericValue(field))
                    cell.setCellValue(converter.convertFieldToNumericValue(field));
                else
                    cell.setCellValue(field);
            }
        }
        createFileAndWrite(fileName);

    }

    public boolean isNumericValue(String field) {
        if (Pattern.matches("[0-9]+(\\.){0,1}[0-9]+", field) || NumberUtils.isCreatable(field))
            return true;
        return false;
    }

    private void createFileAndWrite(String fileName) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File(generateFileName(fileName)));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String generateFileName(String fileName) {
        return fileName + ".xls";
    }
}
