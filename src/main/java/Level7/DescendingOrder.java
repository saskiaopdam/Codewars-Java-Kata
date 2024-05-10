package Level7;// Codewars Kata - 7 kyu
// Descending Order - https://www.codewars.com/kata/5467e4d82edf8bbf40000155

import java.util.Comparator;
import java.util.stream.Collectors;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        return Integer.parseInt(String.valueOf(num)
                .chars()                                // IntStream of Unicode code points
                .mapToObj(c -> String.valueOf((char) c)) // Convert each code point to a String
                .sorted(Comparator.reverseOrder())        // Sort in descending order of characters
                .collect(Collectors.joining()));        // Join the sorted characters to form a string and parse to integer
    }
}
