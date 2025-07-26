package fr.dams4k.cpscore.descript.errors;

import fr.dams4k.cpscore.descript.lexer.TokenType;

public class ParserIncorrectToken extends RuntimeException {
    public ParserIncorrectToken(TokenType expectedType, TokenType receivedType)  {
        super(String.format("Expected %s but received %s instead", expectedType, receivedType));
    }
}
