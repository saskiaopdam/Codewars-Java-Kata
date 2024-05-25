// https://www.codewars.com/kata/59eb1e4a0863c7ff7e000008
package Level3;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BooleanOrder {

    // 1 operands + operators string
    // 2 operands + operators ritsen
    // 3 mappen: "t" -> true, "f" -> false, "^" -> ^, "|" -> |, "&" -> &
    // 4 combinatie met () genereren en testen
    // 5 combinatie == true -> count++
    // 6 return count
    private final String operands;
    private final String operators;

    public BooleanOrder(final String operands, final String operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public BigInteger solve() {
        BigInteger count = computeCount(operands, operators);
        System.out.println("count: " + count);
        return count;
    }

    private BigInteger computeCount(String operands, String operators)  {
        System.out.println("operands: " + operands + " , operators: " + operators);

//        solve("tft","^&")
//        "((t ^ f) & t)" = True
//        "(t ^ (f & t))" = True

        BigInteger count = BigInteger.ZERO;

//        String expression = "((true ^ false) & true)";
        String expression = IntStream.range(0, operands.length())
                .mapToObj(index -> {
                    StringBuilder sb = new StringBuilder();
                    if (index > 0) {
                        sb.append(operators.charAt(index - 1));
                    }
                    sb.append(operands.charAt(index) == 't' ? "true" : "false");
                    return sb.toString();
                })
                .collect(Collectors.joining());

        System.out.println("expression: " + expression);

        if (evaluatesToTrue(expression))  {
            count = count.add(BigInteger.ONE);
        }

        return count;
    }


    private Boolean evaluatesToTrue(String expression) {

        boolean result = expression.startsWith("true");

        for (int i = 0; i < expression.length(); i++) {

            char currentChar = expression.charAt(i);
            if (currentChar == '&' || currentChar == '|' || currentChar == '^') {
                char nextChar = expression.charAt(i + 1);
                boolean nextOperand = nextChar == 't';
                switch (currentChar) {
                    case '&':
                        result &= nextOperand;
                        break;
                    case '|':
                        result |= nextOperand;
                        break;
                    case '^':
                        result ^= nextOperand;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator: " + currentChar);
                }
            }
        }

        return result;

    }

}
