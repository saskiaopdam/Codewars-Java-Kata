package Level5;

import java.util.ArrayList;
import java.util.List;

class MissingNumber {
    public static int missing(String s){
        String stringToCheck = s;
        int digits = 1;
        int start = Integer.parseInt(stringToCheck.substring(0, digits));
        int expected = start + 1;
        int expectedDigits = String.valueOf(expected).length();
        stringToCheck = s.replaceFirst(String.valueOf(start), "");
        List<Integer> missingNumbers = new ArrayList<>();

        while (expectedDigits <= stringToCheck.length()) {
            int actual = Integer.parseInt(stringToCheck.substring(0, expectedDigits));
            String actualString = stringToCheck.substring(0, expectedDigits);

            /// LAATSTE STUKJE STRING < EXPECTED STRING: repeat loop : HOE???
            if (expectedDigits > stringToCheck.length()) {
//                System.out.println("actual smaller than expected");
                missingNumbers.clear();
                stringToCheck = s;
                digits++;
                start = Integer.parseInt(stringToCheck.substring(0, digits));
                expected = start + 1;
                expectedDigits = String.valueOf(expected).length();
                stringToCheck = s.replaceFirst(String.valueOf(start), "");
                continue;
            }

            if (actual < expected) {
//                System.out.println("actual smaller than expected");
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
//                System.out.println("actual equals expected");
                expected++;
                expectedDigits = String.valueOf(expected).length();
                stringToCheck = stringToCheck.replaceFirst(actualString, "");
            }

            if (actual > expected) {
                missingNumbers.add(expected);
                expected++;
            }
        }

        System.out.println("missing numbers: " + missingNumbers);

        if (missingNumbers.isEmpty()) {
            System.out.println("none missing: -1");
            return -1;
        }
        else if (missingNumbers.size() > 1) {
            System.out.println("more than one missing: -1");
            return -1;
        }
        else {
            System.out.println("exactly one missing: " + missingNumbers.get(0));
            return missingNumbers.get(0);
        }
    }
}