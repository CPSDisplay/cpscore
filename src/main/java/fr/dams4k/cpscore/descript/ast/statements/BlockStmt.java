package fr.dams4k.cpscore.descript.ast.statements;

import fr.dams4k.cpscore.Action;
import fr.dams4k.cpscore.descript.lexer.Token;
import fr.dams4k.cpscore.descript.lexer.TokenType;
import fr.dams4k.cpscore.descript.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlockStmt implements Statement{
    public Action action;
    public List<StateStmt> statesStmt = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("Block(action: %s)", action);
    }

    public String interpret() {
        Integer value = action.getInteger();
        String stringValue = Integer.toString(value);

        Boolean isPressed = value > 0;
        TokenType pressType = isPressed ? TokenType.TRUE : TokenType.FALSE;

        StateStmt stateStmt = findStatePriority(new Token(TokenType.NUMBER, stringValue), new Token(pressType));

        String text = stateStmt.getText(stringValue);

        return text;
    }

    public boolean parse(Parser parser) {
        parser.expect(TokenType.OPEN_CURLY);
        Token actionToken = parser.expect(TokenType.ACTION);
        action = Action.of(actionToken.value);

        while (parser.currentTokenType() == TokenType.COLON) {
            parser.advance();

            StateStmt state = new StateStmt();
            if (state.parse(parser)) {
                statesStmt.add(state);
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

    public StateStmt findState(Token state) {
        for (StateStmt stateStmt : statesStmt) {
            if (stateStmt.state.equals(state)) {
                return stateStmt;
            }
        }
        return null;
    }

    public StateStmt findStatePriority(Token... states) {
        StateStmt stmt = null;

        for (Token state : states) {
            stmt = findState(state);
            if (stmt != null) break;
        }

        return stmt;
    }
}
