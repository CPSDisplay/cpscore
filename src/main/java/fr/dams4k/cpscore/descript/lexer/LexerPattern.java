package fr.dams4k.cpscore.descript.lexer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexerPattern {
    public final String regex;
    public final RegexHandler handler;

    public LexerPattern(String regex, RegexHandler handler) {
        this.regex = regex;
        this.handler = handler;
    }

    public boolean handle(Lexer lexer) {
        String firstIteRegex = String.format("^%s", regex);
        Matcher matcher = Pattern.compile(firstIteRegex).matcher(lexer.remaining());
        if (matcher.find()) {
            handler.handle(lexer, matcher);
            return true;
        }
        return false;
    }
}
