// Simple number sequence - https://www.codewars.com/kata/5a28cf591f7f7019a80000de
package Level5;

import java.util.ArrayList;
import java.util.List;

class MissingNumber {
    public static int missing(String s) {
        String stringToCheck = s;
        int digits = 1;
        int start = Integer.parseInt(stringToCheck.substring(0, digits));
        int expected = start + 1;
        int expectedDigits = String.valueOf(expected).length();
        stringToCheck = s.replaceFirst(String.valueOf(start), "");
        List<Integer> missingNumbers = new ArrayList<>();

        while (expectedDigits <= stringToCheck.length()) {
            int actual = Integer.parseInt(stringToCheck.substring(0, expectedDigits));

            // How also repeat loop when remaining string to check is shorter than expected digits?
            if (actual < expected || actual > expected + 1) {
                missingNumbers.clear();
                stringToCheck = s;
                digits++;
                start = Integer.parseInt(stringToCheck.substring(0, digits));
                expected = start + 1;
                expectedDigits = String.valueOf(expected).length();
                stringToCheck = s.replaceFirst(String.valueOf(start), "");
                continue;
            }

            if (actual == expected) {
                expected++;
                expectedDigits = String.valueOf(expected).length();
                stringToCheck = stringToCheck.replaceFirst(String.valueOf(actual), "");
            }

            if (actual == expected + 1) {
                missingNumbers.add(expected);
                expected++;
            }

            System.out.println("start: " + start);
            System.out.println("expected (start + 1): " + expected);
            System.out.println("remaining: " + stringToCheck);
            System.out.println("length of expected string: " + expectedDigits);
            System.out.println("length of remaining string: " + stringToCheck.length());
        }

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
            return missingNumbers.get(0);
        }

    }
}