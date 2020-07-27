package org.duh102.unibot.model.texteffects;

/**
 * We use a 3-bit color palette for the easiest implementation
 */
public enum TextColorEnum {
    CUSTOM(null), BLACK(SimpleColor.BLACK), RED(SimpleColor.RED),
    GREEN(SimpleColor.GREEN), BLUE(SimpleColor.BLUE), CYAN(SimpleColor.CYAN),
    MAGENTA(SimpleColor.MAGENTA), YELLOW(SimpleColor.YELLOW), WHITE(SimpleColor.WHITE);

    private final SimpleColor color;
    TextColorEnum(SimpleColor color) {
        this.color = color;
    }

    public SimpleColor getColor() {
        return color;
    }
}
