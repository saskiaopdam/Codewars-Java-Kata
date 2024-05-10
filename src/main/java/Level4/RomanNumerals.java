package Level4;// Codewars Kata - 4 kyu
// Roman Numerals Helper - https://www.codewars.com/kata/51b66044bce5799a7f000003

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumerals {

    static final Map<Integer, String> romanThousandsMap = Map.of(1,"M", 2, "MM", 3, "MMM", 4, "MMMM");
    static final Map<Integer, String> romanHundredsMap = Map.of(1,"C", 2, "CC", 3, "CCC", 4, "CD", 5, "D", 6, "DC", 7, "DCC", 8, "DCCC", 9, "CM");
    static final Map<Integer, String> romanTensMap = Map.of(1,"X", 2, "XX", 3, "XXX", 4, "XL", 5, "L", 6, "LX", 7, "LXX", 8, "LXXX", 9, "XC");
    static final Map<Integer, String> romanOnesMap = Map.of(1,"I", 2, "II", 3, "III", 4, "IV", 5, "V", 6, "VI", 7, "VII", 8, "VIII", 9, "IX");

    public static String toRoman(int n) {

        String romanNumeral;

        int thousands = (int) Math.floor((double) n /1000);
        int hundreds = (int) Math.floor((double) (n - (thousands * 1000)) /100);
        int tens = (int) Math.floor((double) (n - (thousands * 1000) - (hundreds * 100)) /10);
        int ones = (int) Math.floor((double) n - (thousands * 1000) - (hundreds * 100) - (tens * 10));

        String romanThousands = (thousands == 0) ? "" : romanThousandsMap.get(thousands);
        String romanHundreds = (hundreds == 0) ? "" : romanHundredsMap.get(hundreds);
        String romanTens = (tens == 0) ? "" : romanTensMap.get(tens);
        String romanOnes = (ones == 0) ? "" : romanOnesMap.get(ones);

        romanNumeral = romanThousands + romanHundreds + romanTens + romanOnes;

        return romanNumeral;
    }

    public static int fromRoman(String romanNumeral) {
        int arabicNumeral;
        String regex = "(M{0,4})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";
        Matcher matcher = Pattern.compile(regex).matcher(romanNumeral);

        if (matcher.matches()) {
            String thousands = matcher.group(1);
            String hundreds = matcher.group(2);
            String tens = matcher.group(3);
            String ones = matcher.group(4);

            int arabicThousands = getKeyFromValue(thousands, romanThousandsMap);
            int arabicHundreds = getKeyFromValue(hundreds, romanHundredsMap);
            int arabicTens = getKeyFromValue(tens, romanTensMap);
            int arabicOnes = getKeyFromValue(ones, romanOnesMap);

            arabicNumeral = (arabicThousands * 1000) + (arabicHundreds * 100) + (arabicTens * 10) + arabicOnes;
            return arabicNumeral;
        } else {
            throw new IllegalArgumentException("invalid");
        }
    }

     public static int getKeyFromValue(String value, Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return 0;
     }

}
