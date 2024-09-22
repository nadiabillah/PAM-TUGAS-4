package com.example.recyclerview;

public class Item {
    private String name;
    private int id;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}