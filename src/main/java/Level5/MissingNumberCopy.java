package Level5;// Codewars Kata - 5 kyu
// Missing Number - https://www.codewars.com/kata/5a28cf591f7f7019a80000de

import java.util.ArrayList;
import java.util.List;// Testen slagen: getallen in reeks hebben zelfde aantal digits
// Testen falen: in reeks zit verspringing naar veelvoud van 10 (e.g. 99, 101)

class MissingNumberCopy {
    public static int missing(final String input){
        /*
            input = 1235679
            length = 1
            position = 0
            missingNumbers = []
            while true:
                current = adhv position en length // 3
                expected = current +1             // 4
                expectedPlusOne = expected +1     // 5
                next = adhv position en length    // 5

                if (next == expected)
                    toppie ga zo door
                elseif (next == expectedPlusOne)
                    missingNumbers += [expected]
                else
                    length ++
                    position = 0
                    missingNumbers = []
                    if (length > input.length)
                        return -1

                if outputList bevat meer dan 1 nummer:
                    length ++
                    position = 0
                    missingNumbers = []
                    if (length > input.length)
                        return -1
         */

        int initialLength = 1;
        int length = initialLength;
        int position = 0;
        List<Integer> missingNumbers = new ArrayList<>();

        while (true) {
//            123

            int current = Integer.valueOf(input.substring(position, position + length));
            int expected = current + 1;
            int expectedLength = String.valueOf(expected).length();
            int expectedPlusOne = expected + 1;
            int next = Integer.parseInt(input.substring(position + length, position + length + expectedLength));
            length = expectedLength;

            if (position + length + expectedLength + length > input.length()) {
                // check missing numbers of ga opnieuw met initialLength +1
            }

            if (next == expected) {
                position += length;
                continue;
            }
            else if (next == expectedPlusOne) {
                missingNumbers.add(expected);
            }
            else {
                initialLength++;
                length = initialLength;
                position = 0;
                missingNumbers.clear();
                if (length > input.length()) {
                    return -1;
                }
                continue;
            }

            if (missingNumbers.size() == 1) {
                return missingNumbers.get(0);
            }
            if (missingNumbers.size() > 1) {
                initialLength++;
                length = initialLength;
                position = 0;
                missingNumbers.clear();
                if (length > input.length()) {
                    return -1;
                }
            }
            if (length > input.length()) {
                return -1;
            }
        }
    }
}