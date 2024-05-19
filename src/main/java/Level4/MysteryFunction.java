// https://www.codewars.com/kata/56b2abae51646a143400001d
package Level4;

public class MysteryFunction {

    public static long mystery(long n) {
        return n ^ (n >> 1);
    }

    public static long mysteryInv(long n) {
        for (long mask = n >> 1; mask != 0; mask >>= 1) {
            n ^= mask;
        }

        return n;
    }

    public static String nameOfMystery() {
        return "Gray code";
    }
}