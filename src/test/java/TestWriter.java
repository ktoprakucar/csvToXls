import component.XlsWriter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by toprak.ucar on 26/05/2017.
 */
public class TestWriter {
    XlsWriter writer;
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

    @Test
    public void test_alphanumeric_value_for_isNumeric(){
        String text = "123A123";
        Boolean isNumeric = writer.isNumericValue(text);
        assertFalse(isNumeric);
    }

    @Test
    public void test_integer_value_for_isNumeric(){
        String text = "123123";
        Boolean isNumeric = writer.isNumericValue(text);
        assertTrue(isNumeric);
    }

    @Test
    public void test_decimal_value_for_isNumeric(){
        String text = "123.123";
        Boolean isNumeric = writer.isNumericValue(text);
        assertTrue(isNumeric);
    }

    @Test
    public void test_text_with_two_dots(){
        String text = "123.123.";
        Boolean isNumeric = writer.isNumericValue(text);
        assertFalse(isNumeric);
    }

    @Test
    public void test_text_with_only_dot(){
        String text = ".";
        Boolean isNumeric = writer.isNumericValue(text);
        assertFalse(isNumeric);
    }

    @Test
    public void test_decimal_text_with_two_dots(){
        String text = "213..123";
        Boolean isNumeric = writer.isNumericValue(text);
        assertFalse(isNumeric);
    }

    @Test
    public void test_only_one_number(){
        String text = "0";
        Boolean isNumeric = writer.isNumericValue(text);
        assertTrue(isNumeric);
    }

    @Test
    public void test_correct_date_format(){
        String text = "1903-19-03 22:11:11";
        boolean isDate = writer.isDateValueWithTime(text);
        assertTrue(isDate);
    }

    @Test
    public void test_wrong_date_format_with_miliseconds(){
        String text = "1903-19-03 22:11:11.123";
        boolean isDate = writer.isDateValueWithTime(text);
        assertFalse(isDate);
    }


    @Test
    public void test_date_format_without_time(){
        String text = "1903-19-03";
        boolean isDate = writer.isDateWithoutTime(text);
        assertTrue(isDate);
    }

    @Test
    public void test_wrong_date_format_with_wrong_order_without_time(){
        String text = "19-03-1903";
        boolean isDate = writer.isDateWithoutTime(text);
        assertFalse(isDate);
    }




}
