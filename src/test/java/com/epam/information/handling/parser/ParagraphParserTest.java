package com.epam.information.handling.parser;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Composite;
import com.epam.information.handling.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class ParagraphParserTest {
    private final Component FIRST_PARAGRAPH = new Composite();

    private final Component FIRST_LEXEME = new Lexeme("Рш...");
    private final Component SECOND_LEXEME = new Lexeme("my!");
    private final Component THIRD_LEXEME = new Lexeme("name?");
    private final Component FOURTH_LEXEME = new Lexeme("Yan.");

    {
        FIRST_PARAGRAPH.addComponennt(FIRST_LEXEME);
        FIRST_PARAGRAPH.addComponennt(SECOND_LEXEME);
        FIRST_PARAGRAPH.addComponennt(THIRD_LEXEME);
        FIRST_PARAGRAPH.addComponennt(FOURTH_LEXEME);
    }

    private String TEXT = "Hi... my! name? Yan.";
    private final Parser sentenceParser = Mockito.mock(SentenceParser.class);

    @Test
    public void shouldReturnParsedParagraph() {
        //given
        Parser parser = new ParagraphParser();
        Mockito.when(sentenceParser.parse(Mockito.anyString()))
                .thenReturn(FIRST_LEXEME)
                .thenReturn(SECOND_LEXEME)
                .thenReturn(THIRD_LEXEME)
                .thenReturn(FOURTH_LEXEME);
        parser.addSeccessor(sentenceParser);

        //when

        Component component = parser.parse(TEXT);

        //then
        List<Component> childs = component.getChilds();
        Component firstParagraph = childs.get(0);
        Assert.assertEquals(FIRST_LEXEME, firstParagraph);

        Component secondParagraph = childs.get(1);
        Assert.assertEquals(SECOND_LEXEME, secondParagraph);

        Component thirdParagraph = childs.get(2);
        Assert.assertEquals(THIRD_LEXEME, thirdParagraph);

        Component fourthParagraph = childs.get(3);
        Assert.assertEquals(FOURTH_LEXEME, fourthParagraph);
    }
}
