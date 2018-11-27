package com.epam.information.handling.parser;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Composite;
import com.epam.information.handling.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class TextParserTest {
    private final Component FIRST_PARAGRAPH = new Composite();
    private final Component SECOND_PARAGRAPH = new Composite();

    private final Component FIRST_LEXEME = new Lexeme("Hi,");
    private final Component SECOND_LEXEME = new Lexeme("my");
    private final Component THIRD_LEXEME = new Lexeme("name");
    private final Component FOURTH_LEXEME = new Lexeme("Yan.");

    private final Component FIFTH_LEXEME = new Lexeme("Are");
    private final Component SIXTH_LEXEME = new Lexeme("you");
    private final Component SEVEN_LEXEME = new Lexeme("here?");


    {
        FIRST_PARAGRAPH.addComponennt(FIRST_LEXEME);
        FIRST_PARAGRAPH.addComponennt(SECOND_LEXEME);
        FIRST_PARAGRAPH.addComponennt(THIRD_LEXEME);
        FIRST_PARAGRAPH.addComponennt(FOURTH_LEXEME);

        SECOND_PARAGRAPH.addComponennt(FIFTH_LEXEME);
        SECOND_PARAGRAPH.addComponennt(SIXTH_LEXEME);
        SECOND_PARAGRAPH.addComponennt(SEVEN_LEXEME);
    }

    private String TEXT = "Hi, my name Yan.\n" +
            "    Are you here?";
    private final Parser paragraphParser = Mockito.mock(ParagraphParser.class);

    @Test
    public void shouldReturnParsedText() {
        //given
        Parser textParser = new TextParser();
        Mockito.when(paragraphParser.parse(Mockito.anyString()))
                .thenReturn(FIRST_PARAGRAPH)
                .thenReturn(SECOND_PARAGRAPH);
        textParser.addSeccessor(paragraphParser);
        //when
        Component component = textParser.parse(TEXT);
        //then
        List<Component> childs = component.getChilds();
        Component firstParagraph = childs.get(0);
        Assert.assertEquals(FIRST_PARAGRAPH, firstParagraph);
        Component secondParagraph = childs.get(1);
        Assert.assertEquals(SECOND_PARAGRAPH, secondParagraph);
    }
}
