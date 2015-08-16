package org.sample.web;

import java.util.List;

public class Menu {

    private MenuItem main;

    private List<MenuItem> items;

    public MenuItem getMain() {
        return this.main;
    }

    public void setMain(final MenuItem main) {
        this.main = main;
    }

    public List<MenuItem> getItems() {
        return this.items;
    }

    public void setItems(final List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Menu [main=" + this.main + ", items=" + this.items + "]";
    }

}
