package fr.dams4k.cpscore.descript.ast.statements;

import fr.dams4k.cpscore.descript.parser.Parser;

public interface Statement {
    boolean parse(Parser parser);
}
