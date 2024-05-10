package Level6;// Codewars Kata - 6 kyu
// Bowling Pins - https://www.codewars.com/kata/585cf93f6ad5e0d9bf000010

public class Bowling {

    public String bowlingPins(int[] pinsToRemove) {

        String bowlingPins = "7 8 9 10\n 4 5 6 \n  2 3  \n   1   ";

        for (int n : pinsToRemove) {
            bowlingPins = bowlingPins.replaceAll("\\b" + n + "(?!\\d)", " ");
        }

        return bowlingPins.replaceAll("\\b([1-9]|10)(?!\\d)", "I");
    }

}
