package fr.dams4k.cpscore.descript;

import fr.dams4k.cpscore.descript.ast.statements.BlockStmt;
import fr.dams4k.cpscore.descript.lexer.Token;
import fr.dams4k.cpscore.descript.lexer.Tokenizer;
import fr.dams4k.cpscore.descript.parser.Parser;

import java.util.List;

// Big BIG BIG reference is https://github.com/tlaceby/parser-series/
// So thanks you man, very cool :thumbsup:
public class Descript {
    public static BlockStmt createBlock(String source) {
        List<Token> tokens = Tokenizer.tokenize(source);
        Parser parser = new Parser(tokens);

        BlockStmt block = new BlockStmt();
        if (!block.parse(parser)) {
            return null;
        }

        return block;
    }
}
