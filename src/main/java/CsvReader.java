import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by toprak.ucar on 24/05/2017.
 */
public class CsvReader {
    private String csvFile;
    private String line = "";
    private BufferedReader br;
    private List<String> rows = new ArrayList<String>();

    public List<String> Reader(String fileName){
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                rows.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }

}
