package Level7;

// Codewars Kata - 7 kyu
// Exes and Ohs - https://www.codewars.com/kata/55908aad6620c066bc00002a
public class XO {

    public static boolean getXO (String str) {
        int numX = 0;
        int numO = 0;

        for (char c : str.toLowerCase().toCharArray()) {
            if (c == 'x') numX++;
            if (c == 'o') numO++;
        }

        return numX == numO;
    }
}
