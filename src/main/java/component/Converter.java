package component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by toprak.ucar on 30/05/2017.
 */
public class Converter {

    public Double convertFieldToNumericValue(String field) {
        return Double.parseDouble(field);
    }

    public Date convertFieldToDateValue(String field) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(field);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public Date convertFieldToDateValueWithoutTime(String field) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(field);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
