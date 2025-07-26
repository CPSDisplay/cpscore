package fr.dams4k.cpscore.component;

import fr.dams4k.cpscore.CPSCore;
import fr.dams4k.cpscore.descript.Descript;
import fr.dams4k.cpscore.descript.ast.statements.BlockStmt;

public class CText {
    public String source;
    public String color;
    public BlockStmt blockStmt;

    public CText(String source, String color) {
        this.source = source;
        this.color = color;
        this.blockStmt = Descript.createBlock(source);
    }

    public String getText() {
        return blockStmt.interpret();
    }
}