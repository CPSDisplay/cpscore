package fr.dams4k.cpscore.descript.errors;

import fr.dams4k.cpscore.descript.lexer.TokenType;

import java.util.Arrays;

public class ParserIncorrectToken extends RuntimeException {
    public ParserIncorrectToken(TokenType receivedType, TokenType expectedType)  {
        super(String.format("Expected %s but received %s instead", expectedType, receivedType));
    }

    public ParserIncorrectToken(TokenType receivedType, TokenType... expectedTypes)  {
        super(String.format("Expected one of %s but received %s instead", Arrays.asList(expectedTypes), receivedType));
    }
}
