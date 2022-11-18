package m3naming.after;

public class StringUtils {

    public static int countOccurrences(String stringToSearch, char charToFind) {
        int count = 0;
        for (int i = 0; i < stringToSearch.length(); i++) {
            if (stringToSearch.charAt(i) == charToFind) {
                count++;
            }
        }
        return count;
    }
}
