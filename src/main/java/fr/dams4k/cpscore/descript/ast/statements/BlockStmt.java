package fr.dams4k.cpscore.descript.ast.statements;

import fr.dams4k.cpscore.Action;

public class BlockStmt implements Statement{
    public Action action;

    @Override
    public String toString() {
        return String.format("Block(action: %s)", action);
    }

    public String interpret() {
        Object actionValue = action.getObject();
        if (actionValue == null) return "null";

        return actionValue.toString();
    }
}
