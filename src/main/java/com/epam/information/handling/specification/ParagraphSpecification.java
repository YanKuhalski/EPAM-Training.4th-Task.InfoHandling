package com.epam.information.handling.specification;

import com.epam.information.handling.composite.Component;

import java.util.Comparator;
import java.util.List;

public class ParagraphSpecification implements Comparator<Component> {
    @Override
    public int compare(Component firstComponent, Component secondComponent) {
        List<Component> firstComponentChilds = firstComponent.getChilds();
        int firstSize = firstComponentChilds.size();
        List<Component> secondComponentChilds = secondComponent.getChilds();
        int secondSize = secondComponentChilds.size();
        return secondSize - firstSize;
    }
}
