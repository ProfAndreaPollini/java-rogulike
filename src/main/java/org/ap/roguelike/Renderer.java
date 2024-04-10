package org.ap.roguelike;

import lombok.Getter;
import processing.core.PGraphics;

public class Renderer {
    public static  int TILE_SIZE = 16;
    public static  int SCALE = 2;

    private final PGraphics g;

    @Getter
    private final Spritesheet spritesheet;

    public Renderer(PGraphics g, Spritesheet spritesheet) {
        this.g = g;
        this.spritesheet = spritesheet;
    }

    public PGraphics getGraphics() {
        return g;
    }

    public void drawSprite(String spriteName, int x, int y) {
        var sprite = spritesheet.get(spriteName);
        g.image(sprite,Renderer.SCALE*x*Renderer.TILE_SIZE,Renderer.SCALE*y*Renderer.TILE_SIZE,
                Renderer.SCALE*Renderer.TILE_SIZE,Renderer.SCALE*Renderer.TILE_SIZE);
    }

    public void circle(int x, int y, int radius) {
        g.circle(x * Renderer.SCALE*Renderer.TILE_SIZE, y * Renderer.SCALE*Renderer.TILE_SIZE, radius);
    }

    public void renderDebug(int heroX, int heroY) {
        g.text("Hero: [" + heroX + ", " + heroY + "]", 10, 10);
    }
}
