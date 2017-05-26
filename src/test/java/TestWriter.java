import Component.XlsWriter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by toprak.ucar on 26/05/2017.
 */
public class TestWriter {
    XlsWriter writer;
    String filename;
    List<List<String>> data;

    @Before
    public void setUp(){
        data = new ArrayList<List<String>>();

        List<String> row1 = new ArrayList<String>();
        row1.addAll(Arrays.asList("1984","george","orwell"));

        List<String> row2 = new ArrayList<String>();
        row2.addAll(Arrays.asList("animal farm","george","orwell"));

        List<String> row3 = new ArrayList<String>();
        row3.addAll(Arrays.asList("down and out in paris and london","george","orwell"));

        data.add(row1);
        data.add(row2);
        data.add(row3);

        writer = new XlsWriter();

    }

    @Test
    public void test_generate_file_name(){
        String fileName = writer.generateFileName("toprak");
        assertEquals("toprak.xls", fileName);

    }

    @Ignore
    @Test
    public void test_write_to_an_excel_file(){
        writer.writeToXlsFile("test", data);
    }

}
