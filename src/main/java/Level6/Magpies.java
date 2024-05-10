package Level6;// Codewars Kata - 6 kyu
// Baby Magpies - https://www.codewars.com/kata/59bb02f5623654a0dc000119

import java.util.stream.IntStream;

public class Magpies {

    public static boolean child(final String bird1, final String bird2) {
        final int numColorAreas = bird1.length();
        return inRange(numDiff(bird1, bird2, numColorAreas), 1, 2);
    }

    public static boolean grandchild(final String bird1, final String bird2) {
        final int numColorAreas = bird1.length();

        if (numColorAreas == 1 && numDiff(bird1, bird2, numColorAreas) == 1) {
            return false;
        }

        return inRange(numDiff(bird1, bird2, numColorAreas), 0, 4);
    }

     private static boolean inRange(final int numDiff, final int min, final int max) {
        return numDiff >= min && numDiff <= max;
     }

    private static int numDiff(final String bird1, final String bird2, final int numColorAreas) {
        return (int) IntStream.range(0, numColorAreas)
            .filter(i -> bird1.charAt(i) != bird2.charAt(i))
            .count();
    }

}