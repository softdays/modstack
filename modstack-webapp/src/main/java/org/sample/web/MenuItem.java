package org.sample.web;

public class MenuItem {

    private String label;

    private String path;

    @Override
    public String toString() {
        return "MenuItem [label=" + this.label + ", path=" + this.path + "]";
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(final String path) {
        this.path = path;
    }

}
