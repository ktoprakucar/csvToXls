import Component.CsvReader;
import Component.XlsWriter;
import Converter.CsvToXls;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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
    public void test_converter(){
        converter.convertCsvToXlsAndSave("test.csv", "test");
    }

}
