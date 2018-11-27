package com.epam.information.handling.composite;

import com.epam.information.handling.sorter.Sorter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CompositeTest {
    private final Component FIRST_LEXEME = new Lexeme("Hi,");
    private final Component SECOND_LEXEME = new Lexeme("my");
    private final Component THIRD_LEXEME = new Lexeme("name");
    private final Component FOURTH_LEXEME = new Lexeme("Yan.");

    private final Component FIFTH_LEXEME = new Lexeme("Are");
    private final Component SIXTH_LEXEME = new Lexeme("you");
    private final Component SEVEN_LEXEME = new Lexeme("here?");

    private Component firstParagraph = new Composite();
    private Component secondParagraph = new Composite();

    {
        firstParagraph.addComponennt(FIRST_LEXEME);
        firstParagraph.addComponennt(SECOND_LEXEME);
        firstParagraph.addComponennt(THIRD_LEXEME);
        firstParagraph.addComponennt(FOURTH_LEXEME);

        secondParagraph.addComponennt(FIFTH_LEXEME);
        secondParagraph.addComponennt(SIXTH_LEXEME);
        secondParagraph.addComponennt(SEVEN_LEXEME);
    }

    @Test
    public void shouldCreateSameComposite() {
        //given
        Composite text = new Composite();
        text.addComponennt(secondParagraph);
        text.addComponennt(firstParagraph);
        //when
        Composite composite = new Composite(text);
        //then
        Assert.assertEquals(text, composite);
        List<Component> compositeChilds = composite.getChilds();
        Component thirdComponent = compositeChilds.get(0);
        Component fourthComponent = compositeChilds.get(1);
        Assert.assertEquals(secondParagraph, thirdComponent);
        Assert.assertEquals(firstParagraph, fourthComponent);
    }
}
