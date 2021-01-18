package com.company;

public class Country {
    private String code, name, capital, code2;
    public Country(String code, String name, String capital, String code2){
        this.code=code;
        this.name=name;
        this.capital=capital;
        this.code2=code2;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getCode2() {
        return code2;
    }
}
