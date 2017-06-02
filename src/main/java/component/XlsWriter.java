package component;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
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


    public XlsWriter() {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("iyziSheet");
        converter = new Converter();
    }

    public File writeToXlsFile(String fileName, List<List<String>> rows) {
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        File xlsFile = new File(generateFileName(fileName));
        generateXlsData(rows, cellStyle, createHelper);
        saveXlsDataToFile(xlsFile);
        return xlsFile;

    }

    private void saveXlsDataToFile(File xlsFile) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            workbook.write(bos);
            FileUtils.writeByteArrayToFile(xlsFile, bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateXlsData(List<List<String>> rows, CellStyle cellStyle, CreationHelper createHelper) {
        int rowNumber = 0;
        int cellNumber;
        Row row;
        for (List<String> data : rows) {
            row = sheet.createRow(rowNumber++);
            cellNumber = 0;
            for (String field : data) {
                Cell cell = row.createCell(cellNumber++);
                saveDataToCells(cellStyle, createHelper, field, cell);
            }
        }
    }

    private void saveDataToCells(CellStyle cellStyle, CreationHelper createHelper, String field, Cell cell) {
        if (isNumericValue(field))
            cell.setCellValue(converter.convertFieldToNumericValue(field));
        else if (isDateValueWithTime(field)) {
            cellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cell.setCellValue(converter.convertFieldToDateValue(field));
            cell.setCellStyle(cellStyle);
        }
        else if(isDateWithoutTime(field)){
            cellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
            cell.setCellValue(converter.convertFieldToDateValueWithoutTime(field));
            cell.setCellStyle(cellStyle);
        }
        else
            cell.setCellValue(field);
    }


    public String generateFileName(String fileName) {
        return fileName + ".xls";
    }

    public boolean isNumericValue(String field) {
        if (Pattern.matches("[0-9]+(\\.){0,1}[0-9]+", field) || NumberUtils.isCreatable(field))
            return true;
        return false;
    }

    public boolean isDateValueWithTime(String field) {
        if (Pattern.matches("\\d{4}\\-\\d{2}\\-\\d{2}\\s\\d{2}\\:\\d{2}\\:\\d{2}", field))
            return true;
        return false;
    }

    public boolean isDateWithoutTime(String field) {
        if (Pattern.matches("\\d{4}\\-\\d{2}\\-\\d{2}", field))
            return true;
        return false;
    }
}
