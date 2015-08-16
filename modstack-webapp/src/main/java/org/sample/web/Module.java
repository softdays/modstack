package org.sample.web;

public class Module {

    private String ngModuleName;

    private Menu menu;

    private String scriptUrl;

    public String getNgModuleName() {
        return this.ngModuleName;
    }

    public void setNgModuleName(final String ngModuleName) {
        this.ngModuleName = ngModuleName;
    }

    public String getScriptUrl() {
        return this.scriptUrl;
    }

    public void setScriptUrl(final String scriptUrl) {
        this.scriptUrl = scriptUrl;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(final Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Module [ngModuleName=" + this.ngModuleName + ", menu=" + this.menu + ", scriptUrl="
                + this.scriptUrl + "]";
    }

}
