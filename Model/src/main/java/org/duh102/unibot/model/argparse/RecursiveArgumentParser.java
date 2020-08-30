package org.duh102.unibot.model.argparse;

import org.duh102.unibot.model.argparse.valueparsers.ValueParser;
import org.duh102.unibot.model.text.RichText;
import org.duh102.unibot.model.text.RichTextComponent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RecursiveArgumentParser implements ArgumentParser {
    Map<RichTextComponent, ArgumentParser> subparsers = new HashMap<>();
    Map<RichTextComponent, ValueParser<?>> argumentValueParsers = new HashMap<>();
    Set<RichTextComponent> argumentPlaceholders = new HashSet<>();
    Map<RichTextComponent, HelpTree> argumentHelp;

    public RecursiveArgumentParser addArgument(RichTextComponent argument, RichText helpText) {
        return this;
    }
    public RecursiveArgumentParser addArgument(RichTextComponent argument, ValueParser<?> valueParser, RichText helpText) {
        return this;
    }
    public RecursiveArgumentParser addSubparser(RichTextComponent prefix, ArgumentParser subparser, RichText helpText) {
        return this;
    }

    @Override
    public Arguments parse(RichText arguments) {
        return null;
    }

    @Override
    public RichText getHelp(RichText helpTopic) {
        return null;
    }
}
