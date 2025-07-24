package fr.dams4k.cpscore.descript.lexer;

public class Token {
    public final TokenType type;
    public final String value;
    public final int size;

    public Token(TokenType type, String value, int size) {
        this.type = type;
        this.value = value;
        this.size = size;
    }

    public Token(TokenType type) {
        this(type, type.str, type.str.length());
    }

    @Override
    public String toString() {
        return String.format("%s[ %s ]", type.name(), value);
    }
}
