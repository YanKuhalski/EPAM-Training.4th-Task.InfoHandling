package com.epam.information.handling.composite;

import java.util.List;

public interface Component {
    void addComponennt(Component component);

    void removeComponent(Component component);

    public List<Component> getChilds();
}
