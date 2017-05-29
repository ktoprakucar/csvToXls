package component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by toprak.ucar on 26/05/2017.
 */
public class Parser {

    public static List<List<String>> parseToFields(List<String> rows){
        List<List<String>> fieldsRowByRow = new ArrayList<List<String>>();
        for(String line : rows){
            fieldsRowByRow.add(Arrays.asList(line.split("\\s*,\\s*")));
        }
        return fieldsRowByRow;
    }
}
