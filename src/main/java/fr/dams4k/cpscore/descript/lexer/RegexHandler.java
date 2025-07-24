package fr.dams4k.cpscore.descript.lexer;

import java.util.regex.Matcher;

public interface RegexHandler {
    boolean handle(Lexer lexer, Matcher matcher);
}
