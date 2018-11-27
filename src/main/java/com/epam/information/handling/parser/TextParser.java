package com.epam.information.handling.parser;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Composite;

public class TextParser extends Parser {
    @Override
    public Component parse(String text) {
        String[] paragraphs = text.split("\n {4}");
        Composite fullText = new Composite();
        for (String paragraph : paragraphs) {
            Component sentence = successor.parse(paragraph);
            fullText.addComponennt(sentence);
        }
        return fullText;
    }
}
