package com.yurakim.pensees_concordance.entity;

public enum Edition {

    SEL("Sellier"),
    BRU("Brunschvicg"),
    LAF("Lafuma"),
    LEG("Le Guern");

    private final String fullName;

    Edition(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
