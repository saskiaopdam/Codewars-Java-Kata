// Simple number sequence - https://www.codewars.com/kata/5a28cf591f7f7019a80000de
package Level5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class MissingNumber {
    public static int missing(String s) {
        System.out.println("string: " + s);
        String stringToCheck = s;
        int digits = 1;
        BigInteger start = new BigInteger(stringToCheck.substring(0, digits));
        BigInteger expected = start.add(BigInteger.ONE);
        BigInteger expectedPlusOne = expected.add(BigInteger.ONE);
//        long start = Long.parseLong(stringToCheck.substring(0, digits));
//        long expected = start + 1;
        int expectedDigits = String.valueOf(expectedPlusOne).length();
        stringToCheck = s.replaceFirst(String.valueOf(start), "");
        List<BigInteger> missingNumbers = new ArrayList<>();

        while (expectedDigits <= stringToCheck.length()) {
            BigInteger actual = new BigInteger(stringToCheck.substring(0, expectedDigits));

            // How also repeat loop when remaining string to check is shorter than expected digits?
            if (actual.compareTo(expected) < 0 || actual.compareTo(expected.add(BigInteger.ONE)) > 0) {
                missingNumbers.clear();
                stringToCheck = s;
                digits++;
                start = new BigInteger(stringToCheck.substring(0, digits));
                expected = start.add(BigInteger.ONE);
                expectedDigits = String.valueOf(expected).length();
                stringToCheck = s.replaceFirst(String.valueOf(start), "");
                continue;
            }

            if (actual.equals(expected)) {
                expected = expected.add(BigInteger.ONE);
                expectedDigits = String.valueOf(expected).length();
                stringToCheck = stringToCheck.replaceFirst(String.valueOf(actual), "");
            }

            if (actual.equals(expected.add(BigInteger.ONE))) {
                missingNumbers.add(expected);
                expected = expected.add(BigInteger.ONE);
            }

            if (stringToCheck.length() < expectedDigits && !stringToCheck.isEmpty()) {
                System.out.println("exceeding string");
                return -1;
            }
//
//            System.out.println("start: " + start);
//            System.out.println("expected (start + 1): " + expected);
//            System.out.println("remaining: " + stringToCheck);
//            System.out.println("length of expected string: " + expectedDigits);
//            System.out.println("length of remaining string: " + stringToCheck.length());


        }

        System.out.println("missing numbers: " + missingNumbers);
        if (missingNumbers.isEmpty()) {
            System.out.println("none missing");
            return -1;
        }
        else if (missingNumbers.size() > 1) {
            System.out.println("more than one missing");
            return -1;
        }
        else {
            System.out.println("exactly one missing");
            return missingNumbers.get(0).intValue();
        }

    }
}