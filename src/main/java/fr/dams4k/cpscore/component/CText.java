package fr.dams4k.cpscore.component;

import fr.dams4k.cpscore.CPSCore;

public class CText {
    public String value;
    public String color;

    public CText(String value, String color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return "CText{" +
                "value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getText() {
//        return value.replace("{fps}", CPSCore.INTERFACE.getFPS());
        return "";
    }
}