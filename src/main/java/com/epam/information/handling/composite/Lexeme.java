package com.epam.information.handling.composite;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexeme implements Component {
    private String value;

    public Lexeme(String value) {
        this.value = value;
    }

    public Lexeme(Lexeme lexeme) {
        this.value = lexeme.value;
    }

    @Override
    public void addComponennt(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Component> getChilds() {
        return null;
    }

    public int getInclusionNumber(String regex) {
        int inclusionCouinter = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            inclusionCouinter++;
        }
        return inclusionCouinter;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other.getClass() == Lexeme.class)) {
            return false;
        }

        Lexeme lexeme = (Lexeme) other;

        return getValue() != null ? getValue().equals(lexeme.getValue()) : lexeme.getValue() == null;
    }

    @Override
    public int hashCode() {
        return getValue() != null ? getValue().hashCode() : 0;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }
}
