package org.duh102.unibot.model.argparse;

import org.duh102.unibot.model.text.RichText;

public interface ArgumentParser {
    Arguments parse(RichText arguments);
    RichText getHelp(RichText helpTopic);
}
