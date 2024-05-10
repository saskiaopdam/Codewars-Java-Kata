package Level8;

// Codewars Kata - 8 kyu
// Well of Ideas - https://www.codewars.com/kata/57f222ce69e09c3630000212
public class Kata {
    public static String well(String[] x) {
        int good = 0;

        for (String s : x) {
            if (s.equals("good")) good++;
        }

        return good == 0 ? "Fail!" : good > 2 ? "I smell a series!" : "Publish!";
    }
}
