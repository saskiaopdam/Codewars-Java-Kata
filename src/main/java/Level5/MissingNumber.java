package Level5;

import java.util.ArrayList;
import java.util.List;

// Testen slagen: getallen in reeks hebben zelfde aantal digits
// Testen falen: in reeks zit verspringing naar veelvoud van 10 (e.g. 99, 101)

class MissingNumber {
    public static int missing(String s){
        // 1. GET NUMBER LENGTH

        // Start with 1-digit numbers
        // Compare a and b
        // b <= a ? stop loop, repeat with 2-digit numbers etc.
        // Return number length
        // Max number length = string length/2

        int numberLength = numberLength(s);


        // 2. GET MISSING NUMBER - with the calculated number length

        // Compare number a and b
        // Difference == 2 ? Store missing number (b - 1)
        // List of missing numbers
        // Missing numbers = 0 ? return -1
        // Missing numbers = 2? return -1
        // Return missing number


        return missingNumberInAscendingNumberSequence(s, numberLength);

    }

    private static int numberLength(String s) {
        System.out.println(s);

        int numberLength = 1;
        boolean repeatLoop = true;

        while (repeatLoop) {
            System.out.println("number length: " + numberLength);

            boolean increased = false;

            for (int i = 0; i < s.length() - numberLength; i+= numberLength) {
                String current = s.substring(i, i + numberLength);
                String next = s.substring(i + numberLength, i + numberLength * 2);

                int currentNum = Integer.parseInt(current);
                int nextNum = Integer.parseInt(next);

                // 3 ISSUES:

                // 1. Increase numberLength after transition to number that is a multiple of 10
                // 2. Stop when last number overflows the string length
                // 3. Include check for multiple missing numbers in a row

                // ISSUE 1:
                if (Math.log10(Integer.valueOf(next)) == numberLength - 1) {
                    next = s.substring(i + numberLength, i + numberLength * 2 + 1);
                    nextNum = Integer.parseInt(next);

                    // e.g. 99, 100
                    // next is 100, and after that current is 100

                    // numberLength++;
                }


                System.out.println("currentNum: " + currentNum + ", nextNum: " + nextNum);

                // condition
                if (nextNum <= currentNum) {
                    numberLength++;
                    increased = true;
                    break;
                }

            }

            // ISSUE 2
            if (!increased || numberLength == s.length()/2) {
                repeatLoop = false;
            }

        }

        System.out.println("Final number length: " + numberLength);
        return numberLength;
    }
    private static int missingNumberInAscendingNumberSequence(String s, int numberLength) {
        List<Integer> missingNumbers = new ArrayList<>();

        int i = 0;

        while (i < s.length() - numberLength) {

            String current = s.substring(i, i + numberLength);
            String next = s.substring(i + numberLength, i + numberLength * 2);

            int currentNum = Integer.valueOf(current);
            int nextNum = Integer.valueOf(next);

            // ISSUE 3
            if (nextNum - currentNum == 2) {
                int missingNumber = nextNum - 1;
                missingNumbers.add(missingNumber);
            }
            //add missing numbers when difference > 2


            i+= numberLength;
        }

        System.out.println("missing numbers: " + missingNumbers);
        if (missingNumbers.isEmpty() || missingNumbers.size() > 1) {
            System.out.println(-1);
            return -1;
        } else {
            System.out.println(missingNumbers.get(0));
            return missingNumbers.get(0);
        }
    }


    public static void main(String[] args) {
        System.out.println(missing("123567")); // Expected: 4
        System.out.println(missing("899091939495")); // Expected: 92
//         System.out.println(missing("9899101102")); // Expected: 100 ***
        System.out.println(missing("599600601602")); // Expected: -1
        System.out.println(missing("8990919395")); // Expected: -1
//         System.out.println(missing("998999100010011003")); // Expected: 1002 ***
//        System.out.println(missing("99991000110002")); // Expected: 10000 ***
//        System.out.println(missing("979899100101102")); // Expected: -1 ***
        System.out.println(missing("900001900002900004900005900006")); // Expected: 900003
    }
}