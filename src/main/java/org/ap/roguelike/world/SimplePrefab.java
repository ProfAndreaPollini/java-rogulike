package org.ap.roguelike.world;

import org.ap.roguelike.utils.Color;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;


public class SimplePrefab implements Prefab {
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Color> getData() {
        return data;
    }

    //    PImage srcImage;
//    PGraphics context;
    public int width;
    public int height;
    public List<Color> data;

    public SimplePrefab(PImage img) {
//        srcImage = img;
        width = img.width;
        height = img.height;
        data = new ArrayList<>();
        buildData(img);

//        this.context = context;
    }

    private void buildData(PImage img) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                data.add(new Color(img.get(i, j)));
            }
        }
    }

}
