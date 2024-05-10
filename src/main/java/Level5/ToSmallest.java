package Level5;// Codewars Kata - 5 kyu
// Find the Smallest - https://www.codewars.com/kata/573992c724fc289553000e95

import java.util.Arrays;

public class ToSmallest {

    public static long[] smallest(long n) {
        String numberStr = String.valueOf(n);
        int len = numberStr.length();

        // Initialize variables to track the best move
        long smallestNumber = n;
        int fromIndex = 0;
        int toIndex = 0;

        // Iterate over each digit in the number
        for (int i = 0; i < len; i++) {
            char digit = numberStr.charAt(i);

            // Try moving the current digit to every possible position
            for (int j = 0; j <= len; j++) {
                // Create a StringBuilder based on the current number
                StringBuilder modified = new StringBuilder(numberStr);

                // Remove the current digit
                modified.deleteCharAt(i);

                // Check if j is within the bounds of the modified string
                if (j <= modified.length()) {
                    // Insert the digit at the specified position
                    modified.insert(j, digit);

                    // Convert modified number string back to long
                    String modifiedNumberStr = modified.toString();
                    long modifiedNumber = Long.parseLong(modifiedNumberStr);

                    // Update smallestNumber and indices if this modified number is smaller
                    if (modifiedNumber < smallestNumber) {
                        smallestNumber = modifiedNumber;
                        fromIndex = i;
                        toIndex = j;
                    } else if (modifiedNumber == smallestNumber) {
                        // If numbers are the same, prioritize smaller 'fromIndex' and 'toIndex'
                        if (i < fromIndex || (i == fromIndex && j < toIndex)) {
                            fromIndex = i;
                            toIndex = j;
                        }
                    }
                }
            }
        }

        return new long[] { smallestNumber, fromIndex, toIndex };
    }

    public static void main(String[] args) {
        // Test cases
        testSmallest(261235);   // Expected: [126235, 2, 0]
        testSmallest(209917);   // Expected: [29917, 0, 1]
        testSmallest(285365);   // Expected: [238565, 3, 1]
        testSmallest(269045);   // Expected: [26945, 3, 0]
        testSmallest(296837);   // Expected: [239687, 4, 1]
        testSmallest(100000);   // Expected: [1, 0, 6]
    }

    private static void testSmallest(long n) {
        long[] result = smallest(n);
        System.out.println("smallest(" + n + ") -> " + Arrays.toString(result));
    }
}
