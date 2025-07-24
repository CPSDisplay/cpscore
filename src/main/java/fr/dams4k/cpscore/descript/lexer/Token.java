package fr.dams4k.cpscore.descript.lexer;

public class Token {
    public final TokenType type;
    public final String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Token(TokenType type) {
        this(type, type.str);
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", type.name(), value);
    }
}
