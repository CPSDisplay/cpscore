package fr.dams4k.cpscore.descript.ast.statements;

import fr.dams4k.cpscore.descript.lexer.Token;
import fr.dams4k.cpscore.descript.lexer.TokenType;
import fr.dams4k.cpscore.descript.parser.Parser;

import java.util.HashMap;
import java.util.Map;

public class ModifierStmt implements Statement {
    public Map<Token, Token> modifiers = new HashMap<>();

    @Override
    public boolean parse(Parser parser) {
        parser.expectOne(TokenType.OPEN_BRACKET);

        parseModifier(parser);
        while (parser.currentTokenType() == TokenType.SEMI_COLON) {
            parser.advance();
            parseModifier(parser);
        }

        parser.expect(TokenType.CLOSE_BRACKET);
        return false;
    }

    public void parseModifier(Parser parser) {
        Token attr = parser.expectOne(TokenType.TEXT, TokenType.TEXT_COLOR, TokenType.BACKGROUND_COLOR, TokenType.VISIBLE);
        parser.expect(TokenType.COLON);
        Token value = parser.expectOne(TokenType.STRING, TokenType.TRUE, TokenType.FALSE, TokenType.NUMBER);

        modifiers.putIfAbsent(attr, value);
    }
}
