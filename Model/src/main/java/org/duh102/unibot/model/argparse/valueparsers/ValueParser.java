package org.duh102.unibot.model.argparse.valueparsers;

import org.duh102.unibot.model.text.RichTextComponent;

public interface ValueParser<T> {
    T parse(RichTextComponent value);
}
