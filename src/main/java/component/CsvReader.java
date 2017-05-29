package component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toprak.ucar on 24/05/2017.
 */
public class CsvReader {

    public List<String> read(String fileName){
        String line;
        BufferedReader br = readFile(fileName);
        List<String> rows = new ArrayList<String>();

        try {
            while ((line = br.readLine()) != null) {
                rows.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }

    private BufferedReader readFile(String fileName)  {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bf;
    }

}
