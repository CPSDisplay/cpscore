package fr.dams4k.cpscore.descript.parser;

import fr.dams4k.cpscore.Action;
import fr.dams4k.cpscore.descript.ast.statements.BlockStmt;
import fr.dams4k.cpscore.descript.lexer.Token;
import fr.dams4k.cpscore.descript.lexer.TokenType;

public class StatementParser {
    public static BlockStmt parseBlock(Parser parser) {
        parser.expect(TokenType.OPEN_CURLY);
        Token actionToken = parser.expect(TokenType.ACTION);
        if (parser.currentTokenType() == TokenType.COLON) {
            parser.expect(TokenType.COLON);
            Token state = parser.expect(TokenType.TRUE);
        }

        parser.expect(TokenType.CLOSE_CURLY);

        BlockStmt block = new BlockStmt();
        block.action = Action.of(actionToken.value);

        return block;
    }
}
