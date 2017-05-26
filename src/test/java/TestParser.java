import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by toprak.ucar on 26/05/2017.
 */
public class TestParser {
    List<String> rows;

    @Before
    public void setUp(){
        rows = new ArrayList<String>();
        rows.add("guy;ritchie;british");
        rows.add("pierre;jeunet;french");
        rows.add("turgut;ozakman;turkish");
    }

    @Test
    public void test_parse_lines(){
        List<List<String >> fields = Parser.parseToFields(rows);
        assertEquals(3, fields.size());

        assertEquals(3, fields.get(0).size());
        assertEquals(3, fields.get(1).size());
        assertEquals(3, fields.get(2).size());

        assertEquals("guy", fields.get(0).get(0));
        assertEquals("ritchie", fields.get(0).get(1));
        assertEquals("british", fields.get(0).get(2));

        assertEquals("pierre", fields.get(1).get(0));
        assertEquals("jeunet", fields.get(1).get(1));
        assertEquals("french", fields.get(1).get(2));

        assertEquals("turgut", fields.get(2).get(0));
        assertEquals("ozakman", fields.get(2).get(1));
        assertEquals("turkish", fields.get(2).get(2));
    }
}
