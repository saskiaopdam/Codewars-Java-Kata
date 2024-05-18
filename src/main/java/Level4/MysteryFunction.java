// https://www.codewars.com/kata/56b2abae51646a143400001d
package Level4;

import java.util.stream.Stream;

public class MysteryFunction {

    public static long mystery(long n) {
        // 1 calculate bits m of number n
        // 2 create list of all m bits numbers - decimal, binary, gray
        // 3 return decimal value of number at position n in the gray code list
        int bits = (int) (Math.log(n) / Math.log(2) + 1);

        return Integer.parseInt( Stream.iterate(0L, a -> a + 1)
                .limit((int) Math.pow(2, bits))
                .map(Long::toBinaryString)
                .map(binaryString-> {
                    long binaryLong = Long.parseLong(binaryString, 2);
                    long gray = binaryLong ^ (binaryLong >> 1);
                    return Long.toBinaryString(gray);
                })
                .toList()
                .get((int) n), 2);
    }

    public static long mysteryInv(long n) {
        // 1 long to binary (gray)
        String grayString = Long.toBinaryString(n);

        // 2 gray to regular binary
        long grayLong = Long.parseLong(grayString, 2);
        long binaryLong = grayLong;
        for (long mask = grayLong >> 1; mask != 0; mask >>= 1) {
            binaryLong ^= mask;
        }

        String binaryString = Long.toBinaryString(binaryLong);

        // 3 binary to decimal - return decimal
        return Long.parseLong(binaryString, 2);
    }

    public static String nameOfMystery() {
        return "Gray code";
    }
}