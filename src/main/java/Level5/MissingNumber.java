// Simple number sequence - https://www.codewars.com/kata/5a28cf591f7f7019a80000de
package Level5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class MissingNumber {
    public static int missing(String s) {
        int digits = 1;
        BigInteger firstNumber = new BigInteger(s.substring(0, digits));
        BigInteger expected = firstNumber.add(BigInteger.ONE);
        BigInteger expectedPlusOne = expected.add(BigInteger.ONE);
        int expectedDigits = expected.toString().length();
        String stringToCheck = s.replaceFirst(firstNumber.toString(), "");
        List<BigInteger> missingNumbers = new ArrayList<>();

        while (expectedDigits <= stringToCheck.length()) {

            if (stringToCheck.startsWith(expected.toString())) {
                stringToCheck = stringToCheck.replaceFirst(expected.toString(), "");
                expected = expected.add(BigInteger.ONE);
                expectedPlusOne = expected.add(BigInteger.ONE);
                expectedDigits = expected.toString().length();
            }

            else if (stringToCheck.startsWith(expectedPlusOne.toString())) {
                missingNumbers.add(expected);
                expected = expected.add(BigInteger.ONE);
            }


            else if (stringToCheck.length() < expectedDigits) {
                break;
            }

            else {
                digits++;
                firstNumber = new BigInteger(s.substring(0, digits));
                expected = firstNumber.add(BigInteger.ONE);
                expectedPlusOne = expected.add(BigInteger.ONE);
                expectedDigits = expected.toString().length();
                stringToCheck = s.replaceFirst(firstNumber.toString(), "");
                missingNumbers.clear();
            }

        }

        return missingNumbers.size() == 1 ? missingNumbers.get(0).intValue() : -1;
    }
}