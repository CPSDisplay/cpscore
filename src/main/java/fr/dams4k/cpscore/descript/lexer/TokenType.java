package fr.dams4k.cpscore.descript.lexer;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum TokenType {
    ACTION(
            "action",
            value -> Pattern.compile("^\\$[a-zA-Z]*").matcher(value),
            value -> value.substring(1) // Remove $
    ),

    STRING(
            "string",
            value -> Pattern.compile( "^([\"'])(?:(?=(\\\\?))\\2.)*?\\1").matcher(value),
            value -> value.substring(1, value.length()-1) // Remove quotes
    ),
    NUMBER("number", "[1-9][0-9]*"),
//    RANGE("range", "\\[[1-9][0-9]*:[1-9][0-9]*\\]"),
    TRUE, // also used for pressed
    FALSE, // also used for unpressed

    // GROUPING
    OPEN_CURLY("{", "\\{"),
    CLOSE_CURLY("}", "\\}"),

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
    public final TokenMatcher tokenMatcher;
    public final TokenFormatter tokenFormatter;

    TokenType() {
        str = formatName(name());
        tokenMatcher = value -> Pattern.compile(String.format("^%s", str)).matcher(value);
        tokenFormatter = value -> value;
    }

    TokenType(String str) {
        this(str, str);
    }

    TokenType(String str, String symbol) {
        this.str = str;
        this.tokenMatcher = value -> Pattern.compile(String.format("^%s", symbol)).matcher(value);
        tokenFormatter = value -> value;
    }

    TokenType(String str, TokenMatcher tokenMatcher, TokenFormatter tokenFormatter) {
        this.str = str;
        this.tokenMatcher = tokenMatcher;
        this.tokenFormatter = tokenFormatter;
    }

    @Override
    public String toString() {
        return str;
    }

    public Token match(String value) {
        Matcher matcher = tokenMatcher.match(value);
        if (!matcher.find()) return null;

        String result = matcher.group();
        String formattedResult = tokenFormatter.formatter(result);

        return new Token(this, formattedResult, result.length());
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
