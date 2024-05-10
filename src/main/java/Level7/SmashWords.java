package Level7;

// Codewars Kata - 7 kyu
// Sentence Smash - https://www.codewars.com/kata/53dc23c68a0c93699800041d
public class SmashWords {
    public static String smash(String... words) {

        StringBuilder sb = new StringBuilder();
        int wordCount = 0;

        for (String word : words) {
            sb.append(word);
            wordCount++;

            if (wordCount < words.length) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
