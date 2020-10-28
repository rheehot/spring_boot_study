package com.yeonho.springinit;

import org.springframework.hateoas.RepresentationModel;

public class Hateoas extends RepresentationModel<Hateoas> {

    private String prefix;

    private String name;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return prefix + " " + name;
    }
}
