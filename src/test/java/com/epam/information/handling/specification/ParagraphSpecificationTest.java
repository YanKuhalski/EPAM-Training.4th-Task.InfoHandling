package com.epam.information.handling.specification;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Composite;
import com.epam.information.handling.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;

public class ParagraphSpecificationTest {
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
    public void shouldReturnResultOfSizeComparing() {
        //given
        ParagraphSpecification comparator = new ParagraphSpecification();
        //when
        int result = comparator.compare(firstParagraph, secondParagraph);
        //then
        Assert.assertTrue(result < 0);
    }
}
