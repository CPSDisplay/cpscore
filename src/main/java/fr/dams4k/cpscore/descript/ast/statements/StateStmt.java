package fr.dams4k.cpscore.descript.ast.statements;

import fr.dams4k.cpscore.descript.lexer.Token;
import fr.dams4k.cpscore.descript.lexer.TokenType;
import fr.dams4k.cpscore.descript.parser.Parser;

public class StateStmt implements Statement {
    public Token state;
    public ModifierStmt modifier = new ModifierStmt();

    @Override
    public boolean parse(Parser parser) {
        state = parser.expectOne(TokenType.TRUE, TokenType.FALSE, TokenType.NUMBER);
        parser.expect(TokenType.EQUAL);

        if (!modifier.parse(parser)) {
            return false;
        }

        return true;
    }

    public String getText(String defaultText) {
        return modifier.modifiers.getOrDefault(TokenType.TEXT, new Token(TokenType.STRING, defaultText)).value;
    }
}
