import component.Converter;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by toprak.ucar on 30/05/2017.
 */
public class TestConverter {
    Converter converter;

    @Before
    public void setUp(){
        converter = new Converter();
    }

    @Test
    public void convert_to_long(){
        String text = "1234.5555";
        Double value = converter.convertFieldToNumericValue(text);
        assertEquals(1234.5555, value);
    }
}
