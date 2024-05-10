package Level8;// Codewars Kata - 8 kyu
// Rock Paper Scissors - https://www.codewars.com/kata/5672a98bdbdd995fad00000f

import java.util.Map;
public class RockPaperScissors {

    private static final Map<String, String> OUTCOMES = Map.of(
            "rockscissors", "Player 1 won!",
            "scissorspaper", "Player 1 won!",
            "paperrock", "Player 1 won!"
    );

    public static String rps(String p1, String p2) {
        return p1.equals(p2) ? "Draw!" : OUTCOMES.getOrDefault(p1 + p2, "Player 2 won!");
    }

}
