package com.example.calcularimc.Models;

public class IMC {
    private String name;
    private float weight;
    private float height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getImc(){
        return getWeight() / (getHeight() * getHeight());
    }
}
