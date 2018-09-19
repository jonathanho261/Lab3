import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Webscraper {

    /**This string stores the text received from the file*/
    public static final String TEXT = urlToString("http://erdani.com/tdpl/hamlet.txt");

    public static void main (String [] args) {
        System.out.println(wordCount(TEXT));
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nPlease input the word you want to find the occurrence of");
        String input = keyboard.nextLine();
        System.out.println(wordOccurrence(input));
    }

    /**
     * This method returns the number of times a word occurs in a string
     *
     * @param inString the string
     * @return the number of occurrences the word has in the text
     */
    public static int wordOccurrence(String inString) {
        int occurrence = 0;
        String wordArr[] = TEXT.split(" ");
        for (int i = 0; i < wordArr.length; i++) {
            String checker = wordArr[i];
            if (checker.contains(".") || checker.contains(",")) {
                checker = checker.substring(0, checker.length() - 1);
            }
            if (checker.toLowerCase().contains(inString.toLowerCase()) && checker.length() == inString.length()) {
                occurrence++;
            }
        }
        return occurrence;
    }

    /**
     * This method returns the number of words (int) a string
     *
     * @param text the string
     * @return the number of words found in the string
     */
    public static int wordCount(String text) {
        int words = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words++;
            }
        }
        return words;
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
