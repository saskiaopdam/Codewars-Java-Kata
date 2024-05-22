// https://www.codewars.com/kata/54b8204dcd7f514bf2000348/train/java
package Level4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Simplexer implements Iterator<Token> {
    private final List<Token> tokens = new ArrayList<>();
    private int currentPosition = 0;
    String text = "";
    String type = "";

    private static final Pattern TOKEN_PATTERN = Pattern.compile(
            "(\\d+)|" +             // integers
            "(true|false)|" +       // booleans
            "(\"[^\"]*\")|" +       // strings
            "([+\\-*/()])|" +       // operators
            "(\\b(break|return)\\b)|" +  // keywords
            "(\\s+)" +               // whitespace
            "(\\w+)|"            // identifiers
    );

    public Simplexer(String buffer) {
        Matcher matcher = TOKEN_PATTERN.matcher(buffer);

        Stream<String> tokenStream = matcher.results()
                .map(MatchResult::group)
                .filter(string -> !string.isEmpty());

        tokenStream.forEach(string -> {
            if (string.matches("\\d+")) {
                text = string;
                type = "integer";
            } else if (string.matches("true|false")) {
                text = string;
                type ="boolean";
            } else if (string.matches("\"[^\"]*\"")) {
                text = string;
                type = "string";
            } else if (string.matches("\\b(break|return)\\b")) {
                text = string;
                type = "keyword";
            } else if (string.matches("\\w+")) {
                text = string;
                type = "identifier";
            } else if (string.matches("[+\\-*/()]")) {
                text = string;
                type = "operator";
            } else if (string.matches("\\s+")) {
                text = string;
                type = "whitespace";
            }

            tokens.add(new Token(text, type));
        });

    }

    @Override
    public boolean hasNext() {
        return currentPosition < tokens.size();
    }

    @Override
    public Token next() {
        System.out.println("new Token(text, type).text " + new Token(text, type).text);
        System.out.println("new Token(text, type).type " + new Token(text, type).type);
        return new Token(text, type);
    }
}