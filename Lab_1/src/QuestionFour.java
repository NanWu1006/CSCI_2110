import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by KanzakiMirai on 1/12/16.
 */
public class QuestionFour {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the input file path: ");
        String filePath = inputScanner.next();

        Scanner fileScanner;
        File file = new File(filePath);
        try {
            fileScanner = new Scanner(file);
            startProcess(fileScanner);
        }
        catch (Exception e) {
            System.out.println("FILE OPEN FAIL, REASON: " + e.getLocalizedMessage());
        }
    }

    static void startProcess(Scanner fileScanner) {
        HashMap<String, Integer> freqMap = new HashMap<>();

        while (fileScanner.hasNext()) {
            String nextWord = fileScanner.next();
            if (freqMap.get(nextWord) == null) {
                freqMap.put(nextWord, 1);
            }
            else {
                freqMap.put(nextWord, freqMap.get(nextWord) + 1);
            }
        }

        String keysString = "";
        String valuesString = "";

        for ( Map.Entry<String, Integer> entry : freqMap.entrySet() ) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            keysString+= String.format("%s|", key);
            valuesString+= String.format("%s,", value);
        }

        keysString = keysString.substring(0, keysString.length() - 1);
        valuesString = valuesString.substring(0, valuesString.length() - 1);

        String chartImageURL = String.format("https://chart.googleapis.com/chart?chs=250x100&chd=t:%s&cht=bvs&chco=4D89F9&chl=%s", valuesString, keysString);

        System.out.println("Bar chart URL: " + chartImageURL);
    }
}