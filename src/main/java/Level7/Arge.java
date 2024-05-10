package Level7;

// Codewars Kata - 7 kyu
// Growth of a Population - https://www.codewars.com/kata/563b662a59afc2b5120000c6
public class Arge {

    public static int nbYear(int p0, double percent, int aug, int p) {

        int currentPopulation = p0;
        int yearsToTarget = 0;

        while (currentPopulation < p) {
            currentPopulation = currentPopulation + (int) (currentPopulation * percent * 0.01) + aug;
            yearsToTarget++;
        }

        return yearsToTarget;
    }
}
