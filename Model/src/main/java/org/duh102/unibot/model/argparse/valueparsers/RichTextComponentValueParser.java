package org.duh102.unibot.model.argparse.valueparsers;

import org.duh102.unibot.model.text.RichTextComponent;

public class RichTextComponentValueParser implements ValueParser<RichTextComponent> {
    @Override
    public RichTextComponent parse(RichTextComponent value) {
        return value;
    }
}
