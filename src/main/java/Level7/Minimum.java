package Level7;// Codewars Kata - 7 kyu
// Form The Minimum - https://www.codewars.com/kata/5ac6932b2f317b96980000ca

import java.util.Arrays;
import java.util.stream.Collectors;

public class Minimum{
    public static int minValue(int[] values){
        return Integer.parseInt(Arrays.stream(values)
                .distinct()
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }
}
