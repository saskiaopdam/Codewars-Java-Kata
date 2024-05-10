package Level5;

// Codewars Kata - 5 kyu
// RGB To Hex Conversion - https://www.codewars.com/kata/513e08acc600c94f01000001
public class RgbToHex {

    public static String rgb(int r, int g, int b) {

        String hexRed = twoChars(Integer.toHexString(validValue(r)).toUpperCase());
        String hexGreen = twoChars(Integer.toHexString(validValue(g)).toUpperCase());
        String hexBlue = twoChars(Integer.toHexString(validValue(b)).toUpperCase());

        return hexRed + hexGreen + hexBlue;
    }

    private static String twoChars(String hexString) {
        return (hexString.length() == 1) ? ("0" + hexString) : hexString;
    }

    private static int validValue(int value) {
        return Math.min(255, Math.max(0, value));
    }

}
