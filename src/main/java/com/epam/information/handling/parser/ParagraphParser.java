package com.epam.information.handling.parser;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Composite;

public class ParagraphParser extends Parser {
    @Override
    public Component parse(String paragraphText) {
        String[] sentences = paragraphText.split("[!\\?.{1,3}]");
        Composite paragraph = new Composite();
        for (String sentence : sentences) {
            Component lexeme = successor.parse(sentence.trim());
            paragraph.addComponennt(lexeme);
        }
        return paragraph;
    }
}
