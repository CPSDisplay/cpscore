package fr.dams4k.cpscore.descript.parser;

import fr.dams4k.cpscore.descript.errors.ParserIncorrectToken;
import fr.dams4k.cpscore.descript.lexer.Token;
import fr.dams4k.cpscore.descript.lexer.TokenType;

import java.util.List;

public class Parser {
    public final List<Token> tokens;
    public int position = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Token currentToken() {
        return tokens.get(position);
    }

    public TokenType currentTokenType() {
        return currentToken().type;
    }

    public Token advance() {
        Token token = currentToken();
        position++;
        return token;
    }

    public Token expect(TokenType type) {
        Token token = advance();

        if (token.type != type) {
            throw new ParserIncorrectToken(type, token.type);
        }

        return token;
    }
}
