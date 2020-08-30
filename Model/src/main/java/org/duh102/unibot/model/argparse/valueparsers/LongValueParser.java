package org.duh102.unibot.model.argparse.valueparsers;

import org.duh102.unibot.model.text.RichTextComponent;

public class LongValueParser implements ValueParser<Long> {
    @Override
    public Long parse(RichTextComponent value) throws NumberFormatException {
        return Long.parseLong(value.getRawString());
    }
}
