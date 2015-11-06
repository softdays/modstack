package org.sample.web;

public class Module {

    private String ngModuleName;

    private Menu menu;

    private String[] scripts;

    public String getNgModuleName() {
        return this.ngModuleName;
    }

    public void setNgModuleName(final String ngModuleName) {
        this.ngModuleName = ngModuleName;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(final Menu menu) {
        this.menu = menu;
    }

    public String[] getScripts() {
        return this.scripts;
    }

    public void setScripts(final String[] scripts) {
        this.scripts = scripts;
    }

    @Override
    public String toString() {
        return "Module [ngModuleName=" + this.ngModuleName + ", menu=" + this.menu;
    }

}
