package Q4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by KanzakiMirai on 1/12/16.
 */

/**
 * Q4, count the file words
 *
 * @author Diqi Zeng
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
            String fileContent = fileScanner.useDelimiter("\\Z").next();
            char[] charsArray = fileContent.toCharArray();

            ArrayList<String> charsArrayList = new ArrayList<>();
            for (char eachChar : charsArray) {
                String eachCharString = Character.toString(eachChar).toUpperCase();
                if (eachCharString.toCharArray()[0] >= 65 && eachCharString.toCharArray()[0] <= 90) {
                    charsArrayList.add(Character.toString(eachChar).toUpperCase());
                }
            }

            startProcess(charsArrayList);
        }
        catch (Exception e) {
            System.out.println("FILE OPEN FAIL, REASON: " + e.getLocalizedMessage());
        }
    }

    /**
     * generating the bar chart of word frequency of the given file
     * @param charsArrayList arraylist contains every char
     */
    static void startProcess(ArrayList<String> charsArrayList) throws UnsupportedEncodingException {
        HashMap<String, Integer> freqMap = new HashMap<>();

        /**
         * building a hashmap to count every word
         */
        for (String eachChar : charsArrayList) {
            if (freqMap.get(eachChar) == null) {
                freqMap.put(eachChar, 1);
            }
            else {
                freqMap.put(eachChar, freqMap.get(eachChar) + 1);
            }
        }

        String keysString = "";
        String valuesString = "";

        /**
         * parsing into Google Bar Chart generator
         */
        for ( Map.Entry<String, Integer> entry : freqMap.entrySet() ) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            keysString+= String.format("%s(%s)|", key, value);
            valuesString+= String.format("%s,", value);
        }

        keysString = URLEncoder.encode(keysString.substring(0, keysString.length() - 1), "UTF-8");
        valuesString = valuesString.substring(0, valuesString.length() - 1);

        String chartImageURL = String.format("https://chart.googleapis.com/chart?&chbh=30,05,10&chxt=y&chs=1000x300&chd=t:%s&cht=bvs&chco=4D89F9&chl=%s", valuesString, keysString);

        System.out.println("freqMap = " + freqMap);

        System.out.println("Bar chart URL: " + chartImageURL);
    }
}