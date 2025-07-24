package fr.dams4k.cpscore.descript.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Lexer {
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

    public String source;
    public int position;
    public LexerPattern[] patterns = {
            new LexerPattern("\\s+", ignoreHandler),

            new LexerPattern("\\$[a-zA-Z]*", actionHandler),
            new LexerPattern("^([\"'])(?:(?=(\\\\?))\\2.)*?\\1", stringHandler),
            new LexerPattern("[1-9][0-9]*", numberHandler),
            new LexerPattern("true", defaultHandler(TokenType.TRUE)),
            new LexerPattern("false", defaultHandler(TokenType.FALSE)),

            new LexerPattern("\\{", defaultHandler(TokenType.OPEN_CURLY)),
            new LexerPattern("\\}", defaultHandler(TokenType.CLOSE_CURLY)),
            new LexerPattern(":", defaultHandler(TokenType.COLON)),
            new LexerPattern(";", defaultHandler(TokenType.SEMI_COLON)),
            new LexerPattern("=", defaultHandler(TokenType.EQUAL)),

            new LexerPattern("textColor", defaultHandler(TokenType.TEXT_COLOR)),
            new LexerPattern("backgroundColor", defaultHandler(TokenType.BACKGROUND_COLOR)),
            new LexerPattern("text", defaultHandler(TokenType.TEXT)),
            new LexerPattern("visible", defaultHandler(TokenType.VISIBLE)),
    };
    public List<Token> tokens = new ArrayList<>();

    public Lexer(String source) {
        this.source = source;
    }

    public void advance(int n) {
        this.position += n;
    }

    public Character at() {
        return remaining().charAt(0);
    }

    public String remaining() {
        return source.substring(position);
    }

    public boolean at_eof() {
        return this.position >= source.length();
    }

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
