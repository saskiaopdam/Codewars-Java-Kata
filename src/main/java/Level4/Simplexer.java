// https://www.codewars.com/kata/54b8204dcd7f514bf2000348/train/java
package Level4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Simplexer implements Iterator<Token> {
    private final List<Token> tokens = new ArrayList<>();
    private int currentPosition = 0;

    private static final Pattern TOKEN_PATTERN = Pattern.compile(
            "(\\d+)|" +                        // integers
            "(true|false)|" +                  // booleans
            "(\"[^\"]*\")|" +                  // strings
            "([+\\-*/()=])|" +                 // operators
            "(\\b(break|return|if|else|for)\\b)|" + // keywords
            "(\\s+)|" +                        // whitespace
            "(\\w+)"                           // identifiers
    );

    public Simplexer(String buffer) {
        tokens.addAll(
                buffer != null ?
                        TOKEN_PATTERN.matcher(buffer).results()
                                .map(MatchResult::group)
                                .filter(token -> token != null && !token.isEmpty())
                                .map(token -> new Token(token, getTokenType(token)))
                                .toList()
                        : new ArrayList<>()
        );
    }

    private String getTokenType(String token) {
        if (token.matches("\\d+")) {
            return "integer";
        } else if (token.matches("true|false")) {
            return "boolean";
        } else if (token.matches("\"[^\"]*\"")) {
            return "string";
        } else if (token.matches("[+\\-*/()=]")) {
            return "operator";
        } else if (token.matches("\\b(break|return|if|else|for)\\b")) {
            return "keyword";
        } else if (token.matches("\\s+")) {
            return "whitespace";
        } else if (token.matches("\\w+")) {
            return "identifier";
        }
        return "unknown";
    }

    @Override
    public boolean hasNext() {
        return currentPosition < tokens.size();
    }

    @Override
    public Token next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more tokens available");
        }
        return tokens.get(currentPosition++);
    }
}
