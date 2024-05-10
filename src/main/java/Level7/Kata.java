package Level7;// Codewars Kata - 7 kyu
// Minimum Steps - https://www.codewars.com/kata/5a91a7c5fd8c061367000002/train/java

import java.util.Arrays;

public class Kata {
    public static int minimumSteps(int[] numbers, int k) {
        Arrays.sort(numbers);

        int additions = 0;
        int cumulative = 0;

        for (int n : numbers) {
            cumulative += n;

            if (cumulative < k) {
                additions++;
            }
        }
        return additions;
    }

    public static void main(String[] args) {
        Kata.minimumSteps(new int[]{8,9,4,2}, 23); // doTest(new int[]{8,9,4,2}, 23, 3);
    }
}
