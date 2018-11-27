package com.epam.information.handling.parser;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SentenceParserTest {
    private final String FIRST_LEXEME = "Hi,";
    private final String SECOND_LEXEME = "I'm";
    private final String THIRD_LEXEME = "Yan.";

    @Test
    public void shouldReturnParsedSentance() {
        //given
        Parser sentenceParser = new SentenceParser();

        //when
        Component component = sentenceParser.parse(FIRST_LEXEME + " " + SECOND_LEXEME + " " + THIRD_LEXEME);

        //then
        List<Component> childs = component.getChilds();
        Lexeme firstLexem = (Lexeme) childs.get(0);
        String firstLexemValue = firstLexem.getValue();
        Assert.assertEquals(FIRST_LEXEME, firstLexemValue);

        Lexeme secondLexem = (Lexeme) childs.get(1);
        String secondLexemValue = secondLexem.getValue();
        Assert.assertEquals(SECOND_LEXEME, secondLexemValue);

        Lexeme thirdLexem = (Lexeme) childs.get(2);
        String thirdLexemValue = thirdLexem.getValue();
        Assert.assertEquals(THIRD_LEXEME, thirdLexemValue);
    }
}
