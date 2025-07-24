package fr.dams4k.cpscore.descript.lexer;

import java.util.regex.Matcher;

public class Handlers {
    public static RegexHandler actionHandler = (lexer, matcher) -> {
        String value = matcher.group();
        lexer.advance(value.length());
        lexer.tokens.add(new Token(TokenType.ACTION, value.substring(1)));
    };

    public static RegexHandler stringHandler = (lexer, matcher) -> {
        String value = matcher.group();
        lexer.advance(value.length());
        lexer.tokens.add(new Token(TokenType.STRING, value.substring(1, value.length()-1)));
    };

    public static RegexHandler numberHandler = (lexer, matcher) -> {
        String value = matcher.group();
        lexer.advance(value.length());
        lexer.tokens.add(new Token(TokenType.NUMBER, value));
    };

    public static RegexHandler ignoreHandler = (lexer, matcher) -> {
        lexer.advance(matcher.group().length());
    };

    public static final RegexHandler defaultHandler(TokenType type) {
        return new RegexHandler() {
            @Override
            public void handle(Lexer lexer, Matcher matcher) {
                lexer.advance(type.str.length());
                lexer.tokens.add(new Token(type, type.str));
            }
        };
    }
}
