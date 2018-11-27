package com.epam.information.handling.specification;

import com.epam.information.handling.composite.Component;
import com.epam.information.handling.composite.Lexeme;

import java.util.Comparator;

public class SentenceRegexsSpecification implements Comparator<Component> {
    private String regex;

    public SentenceRegexsSpecification(String regex) {
        this.regex = regex;
    }

    @Override
    public int compare(Component firstComponent, Component secondComponent) {
        Lexeme firstLexeme = (Lexeme) firstComponent;
        Lexeme secondLexeme = (Lexeme) secondComponent;
        int firstLexemeInclusionNumber = firstLexeme.getInclusionNumber(regex);
        int secondLexemeInclusionNumber = secondLexeme.getInclusionNumber(regex);
        int difference = secondLexemeInclusionNumber - firstLexemeInclusionNumber;
        if (difference == 0) {
            String secondLexemeValue = secondLexeme.getValue();
            String firstLexemeValue = firstLexeme.getValue();
            return secondLexemeValue.compareTo(firstLexemeValue);
        }
        return difference;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
