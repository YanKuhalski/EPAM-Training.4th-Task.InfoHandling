package com.epam.information.handling.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public Composite() {
    }

    public Composite(Composite composite) {
        Component newComponent;

        for (Component component : composite.getChilds()) {
            if (component.getClass() == Composite.class) {
                newComponent = new Composite((Composite) component);
            } else {
                newComponent = new Lexeme((Lexeme) component);
            }
            components.add(newComponent);
        }
    }


    @Override
    public void addComponennt(Component component) {
        components.add(component);
    }

    @Override
    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other.getClass() == Composite.class)) {
            return false;
        }

        Composite composite = (Composite) other;

        return components != null ? components.equals(composite.components) : composite.components == null;
    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }

    public List<Component> getChilds() {
        return components;
    }
}
