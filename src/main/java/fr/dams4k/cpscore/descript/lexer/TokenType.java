package fr.dams4k.cpscore.descript.lexer;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum TokenType {
    ACTION,
    STRING,
    NUMBER,
//    RANGE("range", "\\[[1-9][0-9]*:[1-9][0-9]*\\]"),
    TRUE, // also used for pressed
    FALSE, // also used for unpressed

    // GROUPING
    OPEN_CURLY("{"),
    CLOSE_CURLY("}"),

    // SYMBOLS
    COLON(":"),
    SEMI_COLON(";"),
    EQUAL("="),

    // RESERVED KEYWORD
    TEXT,
    TEXT_COLOR,
    BACKGROUND_COLOR,
    VISIBLE;

    public final String str;

    TokenType() {
        str = formatName(name());
    }

    TokenType(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }


    public static String formatName(String name) {
        // Sadly I can't use Pattern.compile().matcher().replaceAll
        // Because replaceAll method is not available in java8

        String[] splitted = name.toLowerCase(Locale.FRENCH).split("_");
        StringBuilder formatted = new StringBuilder(splitted[0]);
        for (int i = 1; i < splitted.length; i++) {
            String part = splitted[i];
            String camelPart = part.substring(0, 1).toUpperCase(Locale.FRENCH) + part.substring(1);
            formatted.append(camelPart);
        }
        return formatted.toString();
    }
}
