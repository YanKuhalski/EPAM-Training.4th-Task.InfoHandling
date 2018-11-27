package com.epam.information.handling.parser;

import com.epam.information.handling.composite.Component;

public abstract class Parser {
    protected Parser successor;

    public abstract Component parse(String text);

    public Parser addSeccessor(Parser seccessor) {
        this.successor = seccessor;
        return seccessor;
    }

    public Parser getSuccessor() {
        return successor;
    }
}
