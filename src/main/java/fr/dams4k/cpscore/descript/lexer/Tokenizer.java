package fr.dams4k.cpscore.descript.lexer;

import java.util.List;

public class Tokenizer {
    public static List<Token> tokenize(String source) {
        Lexer lexer = new Lexer(source);
        while (!lexer.at_eof()) {
            boolean matched = false;

            for (LexerPattern pattern : lexer.patterns) {
                if (pattern.handle(lexer)) {
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                System.out.println(String.format("Unrecognized token %s at position %s ( %s )", lexer.at(), lexer.position, lexer.remaining()));
                break;
            }
        }

        return lexer.tokens;
    }
}
