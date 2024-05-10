package Level7;// Codewars Kata - 7 kyu
// Jumping Number - https://www.codewars.com/kata/5a54e796b3bfa8932c0000ed/train/java?collection=java-beginner

public class Solution {
    public static String jumpingNumber(int number) {
        String numStr = String.valueOf(number);

        if (numStr.length() == 1) {
            return "Jumping!!";  // Single-digit number is always "Jumping!!"
        }

        for (int i = 1; i < numStr.length(); i++) {
            int prevDigit = numStr.charAt(i - 1) - '0';
            int currentDigit = numStr.charAt(i) - '0';

            if (Math.abs(currentDigit - prevDigit) != 1) {
                return "Not!!";
            }
        }

        return "Jumping!!";
    }
}

