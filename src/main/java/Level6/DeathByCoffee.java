package Level6;// Codewars Kata - 6 kyu
// Death by Coffee - https://www.codewars.com/kata/57db78d3b43dfab59c001abe

public class DeathByCoffee {

    public static int[] coffeeLimits(final int year, final int month, final int day) {
        final int CAFE = 0xCAFE;
        final int DECAF = 0xDECAF;

        int healthNumber = (year * 10000) + (month * 100) + day;
        int regularLimit = 0;
        int decafLimit = 0;

        regularLimit = drinkCoffee(CAFE, healthNumber, regularLimit);
        decafLimit = drinkCoffee(DECAF, healthNumber, decafLimit);

        return new int[]{ regularLimit, decafLimit };
    }

    private static int drinkCoffee(int coffeeType, int healthNumber, int currentLimit) {

        for (int i = 1; i <= 5000; i++) {
            healthNumber += coffeeType;
            currentLimit++;

            if (Integer.toHexString(healthNumber).contains("dead")) {
                break;
            }
        }

        if (currentLimit == 5000) {
            currentLimit = 0;
        }

        return currentLimit;
    }

}