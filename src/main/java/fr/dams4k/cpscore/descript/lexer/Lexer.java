package fr.dams4k.cpscore.descript.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Lexer {
    public String source;
    public int position;
    public LexerPattern[] patterns = {
            new LexerPattern("\\s+", Handlers.ignoreHandler),

            new LexerPattern("\\$[a-zA-Z]*", Handlers.actionHandler),
            new LexerPattern("^([\"'])(?:(?=(\\\\?))\\2.)*?\\1", Handlers.stringHandler),
            new LexerPattern("[1-9][0-9]*", Handlers.numberHandler),
            new LexerPattern("true", Handlers.defaultHandler(TokenType.TRUE)),
            new LexerPattern("false", Handlers.defaultHandler(TokenType.FALSE)),

            new LexerPattern("\\{", Handlers.defaultHandler(TokenType.OPEN_CURLY)),
            new LexerPattern("\\}", Handlers.defaultHandler(TokenType.CLOSE_CURLY)),
            new LexerPattern(":", Handlers.defaultHandler(TokenType.COLON)),
            new LexerPattern(";", Handlers.defaultHandler(TokenType.SEMI_COLON)),
            new LexerPattern("=", Handlers.defaultHandler(TokenType.EQUAL)),

            new LexerPattern("textColor", Handlers.defaultHandler(TokenType.TEXT_COLOR)),
            new LexerPattern("backgroundColor", Handlers.defaultHandler(TokenType.BACKGROUND_COLOR)),
            new LexerPattern("text", Handlers.defaultHandler(TokenType.TEXT)),
            new LexerPattern("visible", Handlers.defaultHandler(TokenType.VISIBLE)),
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
}
