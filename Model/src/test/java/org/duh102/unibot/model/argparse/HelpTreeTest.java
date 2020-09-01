package org.duh102.unibot.model.argparse;

import org.duh102.unibot.model.exception.HelpException;
import org.duh102.unibot.model.text.RichText;
import org.duh102.unibot.model.text.RichTextComponent;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class HelpTreeTest {

    @Test
    public void testConstructor() {
        HelpTree tree = new HelpTree(new RichText("here's some help"));
        assertThat(tree.getHelpText()).isEqualTo(new RichText("here's some help"));
        assertThat(tree.getSubcommandHelp()).isNullOrEmpty();

        HelpTree tree2 = new HelpTree(new RichText("here's some more help"), Collections.singletonMap(new RichTextComponent("sub"), tree));
        assertThat(tree2.getHelpText()).isEqualTo(new RichText("here's some more help"));
        assertThat(tree2.getSubcommandHelp()).containsOnlyKeys(new RichTextComponent("sub"));
        HelpTree temp = tree2.getSubcommandHelp().get(new RichTextComponent("sub"));
        assertThat(temp.getHelpText()).isEqualTo(new RichText("here's some help"));
        assertThat(temp.getSubcommandHelp()).isNullOrEmpty();
    }

    @Test
    public void testBuilder() {
        HelpTree.Builder builder = new HelpTree.Builder(new RichText("a"));
        HelpTree temp = builder.build();
        assertThat(temp.getHelpText()).isEqualTo(new RichText("a"));

        builder.setHelp(new RichText("b"));
        temp = builder.build();
        assertThat(temp.getHelpText()).isEqualTo(new RichText("b"));

        assertThat(temp.getSubcommandHelp()).isNullOrEmpty();

        builder.addSubHelp(new RichTextComponent("a"), temp);
        HelpTree temp2 = builder.build();
        assertThat(temp2.getSubcommandHelp()).containsOnlyKeys(new RichTextComponent("a"));
        HelpTree subTemp = temp2.getSubcommandHelp().get(new RichTextComponent("a"));
        assertThat(subTemp).isEqualTo(temp);
    }

    @Test
    public void testSubHelp() throws HelpException {
        RichTextComponent sub0Component = new RichTextComponent("sub0");
        RichTextComponent sub1Component = new RichTextComponent("sub1");
        RichTextComponent sub0_0Component = new RichTextComponent("final_0");
        RichTextComponent sub0_1Component = new RichTextComponent("final_1");
        RichTextComponent sub1_0Component = new RichTextComponent("sub_1_0");

        // sub 0 tree
        HelpTree sub0_0 = new HelpTree.Builder(new RichText("final help topic 0")).build();
        HelpTree sub0_1 = new HelpTree.Builder(new RichText("final help topic 1")).build();
        HelpTree sub0 = new HelpTree.Builder(new RichText("sub_0"))
                .addSubHelp(new RichTextComponent(sub0_0Component.getRawString()), sub0_0)
                .addSubHelp(new RichTextComponent(sub0_1Component.getRawString()), sub0_1)
                .build();

        // sub 1 tree
        HelpTree sub1_0 = new HelpTree.Builder(new RichText("sub 1 0 help")).build();
        HelpTree sub1 = new HelpTree.Builder(new RichText("sub_1"))
                .addSubHelp(new RichTextComponent(sub1_0Component.getRawString()), sub1_0)
                .build();

        // main tree
        HelpTree help = new HelpTree.Builder(new RichText("command help"))
                .addSubHelp(new RichTextComponent(sub0Component.getRawString()), sub0)
                .addSubHelp(new RichTextComponent(sub1Component.getRawString()), sub1)
                .build();

        // Base case
        assertThat(help.getSubHelpRecursive(null)).isEqualTo(help.getHelpText());
        // Sub 0
        assertThat(help.getSubHelpRecursive(Collections.singletonList(sub0Component)))
                .isEqualTo(sub0.getHelpText());
        // Sub 1
        assertThat(help.getSubHelpRecursive(Collections.singletonList(sub1Component)))
                .isEqualTo(sub1.getHelpText());
    }
}
