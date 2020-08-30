package org.duh102.unibot.model.argparse.valueparsers;

import org.duh102.unibot.model.text.RichTextComponent;

public class DoubleValueParser implements ValueParser<Double> {
    @Override
    public Double parse(RichTextComponent value) throws NumberFormatException {
        return Double.parseDouble(value.getRawString());
    }
}
