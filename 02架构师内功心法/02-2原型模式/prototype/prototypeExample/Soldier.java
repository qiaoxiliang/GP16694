package com.prototype.prototypeExample;

public class Soldier {

    private String type;
    private String country;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "type='" + type + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public Soldier deppClone(){
        return null;
    }
}
