package fr.dams4k.cpscore.descript.lexer;

import java.util.Locale;

public enum TokenType {
    STRING,
    NUMBER,
    TRUE, // also used for pressed
    FALSE, // also used for unpressed

    // GROUPING
    OPEN_CURLY("{"),
    CLOSE_CURLY("}"),

    // RESERVED KEYWORD
    TEXT,
    TEXT_COLOR,
    BACKGROUND_COLOR,
    VISIBLE;

    public final String str;
    public final TokenMatcher matcher;

    TokenType(String str, TokenMatcher matcher) {
        this.str = str;
        this.matcher = matcher;
    }

    TokenType(String str) {
        this.str = str;
        this.matcher = value -> value.toLowerCase(Locale.ENGLISH).startsWith(str);
    }

    TokenType() {
        str = formatName(name());
        matcher = value -> value.toLowerCase(Locale.ENGLISH).startsWith(str);
    }

    @Override
    public String toString() {
        return str;
    }

    public Token match(String value) {
        return matcher.match(value) ? new Token(this) : null;
    }

    public static String formatName(String name) {
        // Sadly i can't use Pattern.compile().matcher().replaceAll
        // Because replaceAll method is not available in java8

        String[] splitted = name.toLowerCase(Locale.FRENCH).split("_");
        String formatted = splitted[0];
        for (int i = 1; i < splitted.length; i++) {
            String part = splitted[i];
            formatted += part.substring(0, 1).toUpperCase(Locale.FRENCH) + part.substring(1, part.length());
        }
        return formatted;
    }
}
