package org.duh102.unibot.model.argparse;

import org.duh102.unibot.model.text.RichText;
import org.duh102.unibot.model.text.RichTextComponent;

import java.util.HashMap;
import java.util.Map;

public class HelpTree {
    RichText helpText;
    Map<RichTextComponent, HelpTree> subcommandHelp;

    public HelpTree(RichText help) {
        helpText = help;
        subcommandHelp = null;
    }
    public HelpTree(RichText help, Map<RichTextComponent, HelpTree> subcommandHelp) {
        helpText = help;
        this.subcommandHelp = subcommandHelp;
    }

    public class Builder {
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
}
