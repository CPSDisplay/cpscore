package fr.dams4k.cpscore.descript.ast.statements;

import fr.dams4k.cpscore.Action;
import fr.dams4k.cpscore.descript.lexer.Token;
import fr.dams4k.cpscore.descript.lexer.TokenType;
import fr.dams4k.cpscore.descript.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class BlockStmt implements Statement{
    public Action action;
    public List<StateStmt> states = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("Block(action: %s)", action);
    }

    public String interpret() {
        Object actionValue = action.getObject();
        if (actionValue == null) return "null";

        Boolean isPressed = action.getBoolean();
        action.is(Integer.class);

        return "";
    }

    public boolean parse(Parser parser) {
        parser.expect(TokenType.OPEN_CURLY);
        Token actionToken = parser.expect(TokenType.ACTION);
        action = Action.of(actionToken.value);

        while (parser.currentTokenType() == TokenType.COLON) {
            parser.advance();

            StateStmt state = new StateStmt();
            if (state.parse(parser)) {
                states.add(state);
            } else {
                return false;
            }
        }

        parser.expect(TokenType.CLOSE_CURLY);

        return true;
    }

    public void parseStates(Parser parser) {
        while (parser.currentTokenType() != TokenType.CLOSE_CURLY) {
            Token state = parser.expectOne(TokenType.TRUE, TokenType.FALSE, TokenType.NUMBER);
            parser.expect(TokenType.EQUAL);

            parser.expectOne(TokenType.SEMI_COLON, TokenType.CLOSE_CURLY);
        }
    }
}
