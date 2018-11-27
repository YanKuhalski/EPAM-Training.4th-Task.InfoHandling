package com.epam.information.handling.director;

import com.epam.information.handling.chain.builder.ChainBuilder;
import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Lexeme;
import com.epam.information.handling.parser.Parser;

import java.util.List;

public class Director {
    private final ChainBuilder chainBuilder;

    public Director(ChainBuilder chainBuilder) {
        this.chainBuilder = chainBuilder;
    }

    public Component createComposit(String text) {
        Parser parser = chainBuilder.buildParserChain();
        Component component = parser.parse(text);
        return component;
    }

    private String createText(Component component) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Component> paragraphs = component.getChilds();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getChilds();
            for (Component sentence : sentences) {
                List<Component> lexemes = sentence.getChilds();
                for (Component lexeme : lexemes) {
                    Lexeme currentLexem = (Lexeme) lexeme;
                    stringBuilder.append(" " + currentLexem.getValue());
                }
            }
        }
        return stringBuilder.toString();
    }

}
