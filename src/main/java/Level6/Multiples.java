package Level6;// Codewars Kata - 6 kyu
// Multiples of 3 or 5 - https://www.codewars.com/kata/514b92a657cdc65150000006

import java.util.stream.IntStream;

public class Multiples {

    public static int solution(int number) {
        return IntStream.range(1, number)
                .filter(n -> isMultipleOfThree(n) || isMultipleOfFive(n))
                .sum();
    }

    static boolean isMultipleOfThree(int n) {return n % 3 == 0; }
    static boolean isMultipleOfFive(int n) {return n % 5 == 0; }

}
