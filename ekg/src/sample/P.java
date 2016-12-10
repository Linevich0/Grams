package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Маргарита on 10.12.2016.
 */
public class P {
    public static Complex[][] readECGFile(String fileName) {

        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String sCurrentLine;
            br = new BufferedReader(new FileReader(fileName));
            while ((sCurrentLine = br.readLine()) != null) {
                lines.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        lines.remove(0);
        lines.remove(0);
        lines.remove(0);
        Complex[][] complex = new Complex[15][lines.size()];

        for (int line = 0; line < lines.size(); line++) {
            String[] parts = lines.get(line).split(",");
            for (int i = 1; i < parts.length; i++) {
                complex[i - 1][line] = new Complex(Double.parseDouble(parts[i]), 0.0);
            }
        }

        return complex;

    }
}
