import component.CsvReader;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by toprak.ucar on 24/05/2017.
 */
public class TestReader {
    CsvReader reader;
    String fileName;
    List<String> linesCovered;


    @Before
    public void setUp(){
        reader = new CsvReader();
        fileName = "test.csv";
        linesCovered = new ArrayList<String>();
    }

    @Test
    public void test_read_file(){
        linesCovered = reader.read(fileName);
        assertEquals(2, linesCovered.size());
        assertEquals("1903-03-19 00:00:25,1990-12-18", linesCovered.get(1));
    }



}
