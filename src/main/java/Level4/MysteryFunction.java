package Level4;

import java.util.List;
import java.util.stream.Stream;

public class MysteryFunction {

    public static long mystery(long n) {
        // 1 calculate bits m of number n
        int bits = (int)(Math.log(n) / Math.log(2) + 1);

        // 2 create list of all m bits numbers - decimal, binary, gray
        List<Long> decimalList = Stream.iterate(0L, a -> a + 1)
                .limit((int) Math.pow(2, bits))
                .toList();

        List<String> binaryList = decimalList.stream()
                .map(Long::toBinaryString)
                .toList();

        List<String> grayCodeList = binaryList.stream()
                .map(binaryString-> {
                    long binaryLong = Long.parseLong(binaryString, 2);
                    long gray = binaryLong ^ (binaryLong >> 1);
                    return Long.toBinaryString(gray);
                })
                .toList();

        // 3 return decimal value of number at position n in the gray code table
        return Integer.parseInt( grayCodeList.get((int) n), 2);

//        return Integer.parseInt( Stream.iterate(0L, a -> a + 1)
//                .limit((int) Math.pow(2, bits))
//                .map(Long::toBinaryString)
//                .map(binaryString-> {
//                    long binaryLong = Long.parseLong(binaryString, 2);
//                    long gray = binaryLong ^ (binaryLong >> 1);
//                    return Long.toBinaryString(gray);
//                })
//                .toList()
//                .get((int) n), 2);
    }

    public static long mysteryInv(long n) {
        return -1;
    }

    public static String nameOfMystery() {
        return "Gray code";
    }

    public static void main(String[] args) {
        mystery(6); // 3
        mystery(9); // 4
        mystery(19); // 5
        mystery(33); // 6
//        mystery(184467441E19)// 6
    }

}
//public class MysteryFunction {
//
//    public static long mystery(long n) {
//        return n ^ (n >> 1);
//    }
//
//    public static long mysteryInv(long n) {
//        return -1;
//    }
//
//    public static String nameOfMystery() {
//        return "Gray";
//    }
//
//}