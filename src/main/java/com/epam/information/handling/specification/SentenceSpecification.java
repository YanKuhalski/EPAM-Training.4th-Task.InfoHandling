package com.epam.information.handling.specification;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Lexeme;

import java.util.Comparator;

public class SentenceSpecification implements Comparator<Component> {
    @Override
    public int compare(Component firstComponent, Component secondComponent) {
        Lexeme firstLexeme = (Lexeme) firstComponent;
        Lexeme secondLexeme = (Lexeme) secondComponent;
        String firstLexemeValue = firstLexeme.getValue();
        String firstSrt = firstLexemeValue.replaceAll("[.{1,3}\\?!,]", "");
        String secondLexemeValue = secondLexeme.getValue();
        String secondtSrt = secondLexemeValue.replaceAll("[.\\?!,.{1,3}]", "");
        return secondtSrt.length() - firstSrt.length();
    }
}
