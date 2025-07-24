package fr.dams4k.cpscore.descript.lexer;

import java.util.regex.Matcher;

public interface TokenMatcher {
    Matcher match(String value);
}
