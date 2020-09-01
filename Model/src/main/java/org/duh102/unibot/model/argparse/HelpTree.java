package org.duh102.unibot.model.argparse;

import org.duh102.unibot.model.exception.HelpException;
import org.duh102.unibot.model.exception.NoMoreHelpException;
import org.duh102.unibot.model.text.RichText;
import org.duh102.unibot.model.text.RichTextComponent;

import java.util.*;

public class HelpTree {
    private RichText helpText;
    private Map<RichTextComponent, HelpTree> subcommandHelp;

    public HelpTree() {
        super();
    }
    public HelpTree(RichText help) {
        helpText = help;
        subcommandHelp = null;
    }
    public HelpTree(RichText help, Map<RichTextComponent, HelpTree> subcommandHelp) {
        helpText = help;
        this.subcommandHelp = subcommandHelp;
    }

    public static class Builder {
        private RichText text;
        private Map<RichTextComponent, HelpTree> subHelp = null;
        public Builder(RichText text) {
            this.text = text;
        }
        public Builder setHelp(RichText text) {
            this.text = text;
            return this;
        }
        public Builder addSubHelp(RichTextComponent text, HelpTree subHelp) {
            if(this.subHelp == null) {
                this.subHelp = new HashMap<>();
            }
            this.subHelp.put(text, subHelp);
            return this;
        }
        public HelpTree build() {
            return new HelpTree(text, subHelp);
        }
    }

    public RichText getHelpText() {
        return helpText;
    }

    public Map<RichTextComponent, HelpTree> getSubcommandHelp() {
        return subcommandHelp;
    }

    public Set<RichTextComponent> getSubcommandTopics() {
        return getSubcommandHelp().keySet();
    }

    public RichText getSubHelpRecursive(List<RichTextComponent> components) throws HelpException {
        if(components == null || components.size() == 0) {
            return getHelpText();
        }
        RichTextComponent next = components.get(0);
        if(!subcommandHelp.containsKey(next)) {
            throw new NoMoreHelpException(String.format("Invalid help topic: %s", next.getRawString()));
        }
        HelpTree help = subcommandHelp.get(next);
        return help.getSubHelpRecursive(components.subList(1,components.size()));
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof HelpTree)) {
            return false;
        }
        HelpTree other = (HelpTree)o;
        return Objects.equals(helpText, other.getHelpText())
                && Objects.equals(subcommandHelp, other.getSubcommandHelp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(helpText, subcommandHelp);
    }
}
