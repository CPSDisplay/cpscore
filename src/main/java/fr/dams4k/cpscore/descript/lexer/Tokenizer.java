package fr.dams4k.cpscore.descript.lexer;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public static List<Token> tokenize(String source) {
        List<Token> tokens = new ArrayList<>();

        Lexer lexer = new Lexer(source);
        while (!lexer.at_eof()) {
            String remaining = lexer.remaining();

            Token token = null;
            for (TokenType tokenType : TokenType.values()) {
                token = tokenType.match(remaining);
                if (token != null) {
                    System.out.println(token);
                    lexer.advance(token.size);
                    tokens.add(token);
                    break;
                }
            }

            if (token == null) {
                System.out.println(String.format("Failed to read char %s at position %s", remaining.charAt(0), lexer.position));
                break;
            }
        }

        return tokens;
    }
}
