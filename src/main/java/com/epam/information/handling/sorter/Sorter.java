package com.epam.information.handling.sorter;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Composite;
import com.epam.information.handling.specification.ParagraphSpecification;
import com.epam.information.handling.specification.SentenceRegexsSpecification;
import com.epam.information.handling.specification.SentenceSpecification;

import java.util.List;

public class Sorter {
    public Composite sortParagraphs(Composite text) {
        Composite textClon = new Composite(text);
        List<Component> paragraphs = textClon.getChilds();
        paragraphs.sort(new ParagraphSpecification());
        return textClon;
    }

    public Composite sortWords(Composite text) {
        Composite textClon = new Composite(text);
        List<Component> paragraphs = textClon.getChilds();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getChilds();
            sentences.sort(new SentenceSpecification());
        }
        return textClon;
    }

    public Composite sortLexemes(Composite text, String regex) {
        Composite textClon = new Composite(text);

        List<Component> paragraphs = textClon.getChilds();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getChilds();
            sentences.sort(new SentenceRegexsSpecification(regex));
        }
        return textClon;

    }
}