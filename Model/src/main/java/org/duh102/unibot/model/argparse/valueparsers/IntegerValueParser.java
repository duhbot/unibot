package org.duh102.unibot.model.argparse.valueparsers;

import org.duh102.unibot.model.text.RichTextComponent;

public class IntegerValueParser implements ValueParser<Integer>{
    @Override
    public Integer parse(RichTextComponent value) throws NumberFormatException {
        return Integer.parseInt(value.getRawString());
    }
}
