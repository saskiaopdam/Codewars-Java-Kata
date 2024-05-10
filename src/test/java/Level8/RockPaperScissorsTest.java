package Level8;

import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RockPaperScissorsTest {

    @Test
    public void test1() {
        System.out.println("Fixed Tests Player 1 won!");
        assertEquals("Player 1 won!", RockPaperScissors.rps("rock", "scissors"));
        assertEquals("Player 1 won!", RockPaperScissors.rps("scissors", "paper"));
        assertEquals("Player 1 won!", RockPaperScissors.rps("paper", "rock"));
    }
    @Test
    public void test2() {
        System.out.println("Fixed Tests Player 2 won!");
        assertEquals("Player 2 won!", RockPaperScissors.rps("scissors", "rock"));
        assertEquals("Player 2 won!", RockPaperScissors.rps("paper", "scissors"));
        assertEquals("Player 2 won!", RockPaperScissors.rps("rock", "paper"));
    }
    @Test
    public void test3() {
        System.out.println("Fixed Tests Draw!");
        assertEquals("Draw!", RockPaperScissors.rps("scissors", "scissors"));
        assertEquals("Draw!", RockPaperScissors.rps("paper", "paper"));
        assertEquals("Draw!", RockPaperScissors.rps("rock", "rock"));
    }

    private static String sol(String p1, String p2){
        if (p1 == "rock" && p2 == "scissors" || p1 == "scissors" && p2 == "paper" || p1 == "paper" && p2 == "rock") return "Player 1 won!";
        else if (p1 == p2) return "Draw!";
        else return "Player 2 won!";
    }

//    @Test
//    public void randomTests(){
//        Random r = new Random();
//        String [] arr = {"scissors", "rock", "paper"};
//        String a = arr[r.nextInt(3)];
//        String b = arr[r.nextInt(3)];
//        assertEquals("Should work when p1 = " + a + ", p2 = " + b, sol(a, b), RockPaperScissors.rps(a, b));
//    }

}