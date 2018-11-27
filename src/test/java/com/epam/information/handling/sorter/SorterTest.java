package com.epam.information.handling.sorter;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Composite;
import com.epam.information.handling.composite.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SorterTest {
    private final Component FIRST_LEXEME = new Lexeme("Hi,");
    private final Component SECOND_LEXEME = new Lexeme("my");
    private final Component THIRD_LEXEME = new Lexeme("name");
    private final Component FOURTH_LEXEME = new Lexeme("Yan.");

    private final Component FIFTH_LEXEME = new Lexeme("Are");
    private final Component SIXTH_LEXEME = new Lexeme("you");
    private final Component SEVEN_LEXEME = new Lexeme("here?");

    private static final Sorter SORTER = new Sorter();

    private final String REGEX = "Y";

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
    public void shouldSortParagraphs() {
        //given
        Composite text = new Composite();
        text.addComponennt(secondParagraph);
        text.addComponennt(firstParagraph);

        //when
        Composite sortParagraphs = SORTER.sortParagraphs(text);

        //then
        List<Component> childs = sortParagraphs.getChilds();
        Assert.assertEquals(firstParagraph, childs.get(0));
        Assert.assertEquals(secondParagraph, childs.get(1));
    }

    @Test
    public void shouldSortWordsInText() {
        //given
        Composite text = new Composite();
        text.addComponennt(firstParagraph);

        //when
        Composite sortWords = SORTER.sortWords(text);

        //then
        List<Component> paragraphs = sortWords.getChilds();
        Component component = paragraphs.get(0);
        List<Component> words = component.getChilds();

        Assert.assertEquals(THIRD_LEXEME, words.get(0));
        Assert.assertEquals(FOURTH_LEXEME, words.get(1));
        Assert.assertEquals(FIRST_LEXEME, words.get(2));
        Assert.assertEquals(SECOND_LEXEME, words.get(3));
    }

    @Test
    public void shouldSortLexemesInText() {
        //given
        Composite text = new Composite();
        text.addComponennt(firstParagraph);

        //when
        Composite sortLexemes = SORTER.sortLexemes(text, REGEX);

        //then
        List<Component> paragraphs = sortLexemes.getChilds();
        Component component = paragraphs.get(0);
        List<Component> words = component.getChilds();

        Assert.assertEquals(FOURTH_LEXEME, words.get(0));
        Assert.assertEquals(THIRD_LEXEME, words.get(1));
        Assert.assertEquals(SECOND_LEXEME, words.get(2));
        Assert.assertEquals(FIRST_LEXEME, words.get(3));
    }
}
