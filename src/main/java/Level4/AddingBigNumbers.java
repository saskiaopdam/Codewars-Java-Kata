package Level4;// Codewars Kata - 4 kyu
// Adding Big Numbers - https://www.codewars.com/kata/525f4206b73515bffb000b21

// methods uit java.math zijn niet toegestaan

public class AddingBigNumbers {
    public static String add(String a, String b) {
        // strings even lang maken
        if (a.length() < b.length()) {
            a = "0".repeat(b.length() - a.length()) + a;
        }
        if (a.length() > b.length()) {
            b = "0".repeat(a.length() - b.length()) + b;
        }

        // van achter naar voor steeds 2 cijfers optellen
        // bij som > 9 het tiental "onthouden"
        // bij elke som de eenheden "noteren"
        // tiental optellen bij volgende optelsom

        StringBuilder sumBuilder = new StringBuilder();
        int carry = 0;

        for (int i = a.length() - 1; i >= 0; i--) {
            int digitA = Character.getNumericValue(a.charAt(i));
            int digitB = Character.getNumericValue(b.charAt(i));

            int sum = digitA + digitB + carry;

            String sumString = String.valueOf(sum);

//            if (sum > 9) {
//                sumBuilder.insert(0, sumString.charAt(sumString.length() - 1));
//                carry = Character.getNumericValue(sumString.charAt(0));
//            } else {
//                sumBuilder.insert(0, sumString);
//                carry = 0;
//            }

//            int sum = digitA + digitB + carry;
            sumBuilder.insert(0, sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            sumBuilder.insert(0, carry);
        }

        while (sumBuilder.length() > 0 && sumBuilder.charAt(0) == '0') {
            sumBuilder.deleteCharAt(0);
        }
        System.out.println(sumBuilder);
        return sumBuilder.toString();
    }

}
