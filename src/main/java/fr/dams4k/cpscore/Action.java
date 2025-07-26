package fr.dams4k.cpscore;

import java.util.Locale;

public enum Action {
    FPS(() -> { return CPSCore.INTERFACE.getFPS(); }),
    BPS(() -> { return CPSCore.INTERFACE.getBPS(); }),

    ATTACK(() -> { return CPSCore.INTERFACE.getAttack(); }),
    USEITEM(() -> { return CPSCore.INTERFACE.getUseItem(); });

    Caller caller;

    Action(Caller caller) {
        this.caller = caller;
    }

    public static Action of(String value) {
        return valueOf(value.toUpperCase(Locale.ENGLISH));
    }

    public Object getObject() {
        return caller.call();
    }

    public Integer getInteger() {
        return (Integer) getObject();
    }

    public Float getFloat() {
        return (Float) getObject();
    }

    public String getString() {
        return getObject().toString();
    }

    public Boolean getBoolean() {
        if (getObject() instanceof Integer) {
            return getInteger() > 0;
        } else if (getObject() instanceof Float) {
            return getFloat() > 0f;
        } else if (getObject() instanceof String) {
            return !getString().isEmpty();
        } else if (getObject() instanceof Boolean) {
            return (Boolean) getObject();
        }

        return getObject() != null;
    }

    private interface Caller {
        Object call();
    }
}
