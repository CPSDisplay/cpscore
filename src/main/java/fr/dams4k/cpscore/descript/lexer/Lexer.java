package fr.dams4k.cpscore.descript.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Lexer {
    public static RegexHandler actionHandler = (lexer, matcher) -> {
        boolean found = matcher.find();
        if (found) {
            String value = matcher.group();
            lexer.advance(value.length());
            lexer.tokens.add(new Token(TokenType.ACTION, value.substring(1)));
        }
        return found;
    };

    public static RegexHandler stringHandler = (lexer, matcher) -> {
        boolean found = matcher.find();
        if (found) {
            String value = matcher.group();
            lexer.advance(value.length());
            lexer.tokens.add(new Token(TokenType.STRING, value.substring(1, value.length()-1)));
        }
        return found;
    };

    public static RegexHandler numberHandler = (lexer, matcher) -> {
        boolean found = matcher.find();
        if (found) {
            String value = matcher.group();
            lexer.advance(value.length());
            lexer.tokens.add(new Token(TokenType.NUMBER, value));
        }
        return found;
    };

    public String source;
    public int position;
    public LexerPattern[] patterns = {
            new LexerPattern("\\$[a-zA-Z]*", actionHandler),
            new LexerPattern("^([\"'])(?:(?=(\\\\?))\\2.)*?\\1", stringHandler),
            new LexerPattern("[1-9][0-9]*", numberHandler),
            new LexerPattern("true", defaultHandler(TokenType.TRUE, "true")),
            new LexerPattern("false", defaultHandler(TokenType.FALSE, "false")),

            new LexerPattern("\\{", defaultHandler(TokenType.OPEN_CURLY, "{")),
            new LexerPattern("\\}", defaultHandler(TokenType.CLOSE_CURLY, "}")),
            new LexerPattern(":", defaultHandler(TokenType.COLON, ":")),
            new LexerPattern(";", defaultHandler(TokenType.SEMI_COLON, ";")),
            new LexerPattern("=", defaultHandler(TokenType.EQUAL, "=")),
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

    public static final RegexHandler defaultHandler(TokenType type, String value) {
        return new RegexHandler() {
            @Override
            public boolean handle(Lexer lexer, Matcher matcher) {
                boolean found = matcher.find();
                if (found) {
                    lexer.advance(value.length());
                    lexer.tokens.add(new Token(type, value));
                }
                return found;
            }
        };
    }
}
