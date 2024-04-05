package org.ap.roguelike;

import processing.awt.PImageAWT;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.HashMap;

public class Spritesheet {
    public static final int TILE_SIZE = 16;
    PImage spritesheet;
    HashMap<String, PImage> sprites = new HashMap<>();

    public  Spritesheet(PImage img) {
        spritesheet = img;
    }


    public PImage get(int col, int row) {
        return spritesheet.get(col*TILE_SIZE,row*TILE_SIZE,TILE_SIZE, TILE_SIZE);
    }

    public PImage get(String name) {
        return sprites.get(name);
    }

    public void defineSprite(String name,int row, int col) {
        var image = spritesheet.get(col*TILE_SIZE,row*TILE_SIZE,TILE_SIZE,TILE_SIZE);
        sprites.put(name,image);
    }

    public void  defineSprite(String name,int row, int col, int width, int height) {
        var image = spritesheet.get(col*TILE_SIZE,row*TILE_SIZE,width,height);
        sprites.put(name,image);
    }


}
