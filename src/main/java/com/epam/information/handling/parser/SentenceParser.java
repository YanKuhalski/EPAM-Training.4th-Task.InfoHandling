package com.epam.information.handling.parser;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Composite;
import com.epam.information.handling.composite.Lexeme;

public class SentenceParser extends Parser {
    @Override
    public Component parse(String sentenceText) {
        String[] lexemes = sentenceText.split(" ");
        Composite sentence = new Composite();
        for (String lexemeValue : lexemes) {
            Lexeme lexeme = new Lexeme(lexemeValue);
            sentence.addComponennt(lexeme);
        }
        return sentence;
    }
}
