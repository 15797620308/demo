package com.example.model;

import java.util.List;

public class Navs {
    private String title;
    private String icon;
    private String href;
    private  boolean spread;
    private List<Navs> children;

    public Navs() {
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
    }

    public Navs(String title, String icon, String href, boolean spread) {
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
    }

    public Navs(String title, String icon, String href, boolean spread, List<Navs> children) {
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
        this.children = children;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public void setChildren(List<Navs> children) {
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public String getIcon() {
        return icon;
    }

    public String getHref() {
        return href;
    }

    public boolean isSpread() {
        return spread;
    }

    public List<Navs> getChildren() {
        return children;
    }
}
