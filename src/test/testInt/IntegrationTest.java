

import processor.CsvToXls;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

/**
 * Created by toprak.ucar on 26/05/2017.
 */
public class IntegrationTest {
    CsvToXls converter;

    @Before
    public void setUp(){
        converter = new CsvToXls();
    }

    @Ignore
    @Test
    public void test_save_as_an_excel_file(){
        File file = converter.convertCsvToXlsAndSave("settlement-4850-20170119132631-TRY.csv", "settlement");
    }


}
