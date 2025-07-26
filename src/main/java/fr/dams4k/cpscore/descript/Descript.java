package fr.dams4k.cpscore.descript;

import fr.dams4k.cpscore.descript.ast.statements.BlockStmt;
import fr.dams4k.cpscore.descript.lexer.Token;
import fr.dams4k.cpscore.descript.lexer.Tokenizer;
import fr.dams4k.cpscore.descript.parser.Parser;
import fr.dams4k.cpscore.descript.parser.StatementParser;

import java.util.List;

// Big BIG BIG reference is https://github.com/tlaceby/parser-series/
// So thanks you man, very cool :thumbsup:
public class Descript {
    public static String parse(String source) {
        List<Token> tokens = Tokenizer.tokenize(source);
        Parser parser = new Parser(tokens);

        BlockStmt block = StatementParser.parseBlock(parser);

        return block.interpret();
    }
}
