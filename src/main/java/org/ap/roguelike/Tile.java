package org.ap.roguelike;

import processing.core.PImage;

public class Tile {

    private final boolean isSolid;
    public String spriteName;


    private Tile() {
        isSolid = true;
    }

    public Tile(String name,boolean isSolid) {
        spriteName = name;
        this.isSolid = isSolid;
    }


    public boolean isSolid() {
        return isSolid;
    }
}
