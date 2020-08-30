package org.duh102.unibot.model.argparse.valueparsers;

import org.duh102.unibot.model.text.RichTextComponent;

public class FloatValueParser implements ValueParser<Float>{
    @Override
    public Float parse(RichTextComponent value) throws NumberFormatException {
        return Float.parseFloat(value.getRawString());
    }
}
