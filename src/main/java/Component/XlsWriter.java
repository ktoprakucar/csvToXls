package Component;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by toprak.ucar on 26/05/2017.
 */
public class XlsWriter {
    HSSFWorkbook workbook;
    HSSFSheet sheet;
    ;

    public XlsWriter() {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("iyziSheet");
    }

    public void writeToXlsFile(String fileName, List<List<String>> rows){
        int rowNumber = 0;
        int cellNumber;
        Row row;
        for(List<String> data : rows){
            row = sheet.createRow(rowNumber++);
            cellNumber = 0;
            for(String field : data){
                Cell cell = row.createCell(cellNumber++);
                cell.setCellValue(field);
            }
        }
        createFileAndWrite(fileName);

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
        return fileName+".xls";
    }
}
