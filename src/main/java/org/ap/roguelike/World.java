package org.ap.roguelike;

import java.util.ArrayList;

public class World {

    private int width;
    private int height;

    private ArrayList<Integer> tileMap = new ArrayList<>();
    private ArrayList<Tile> tiles;



    public World(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new ArrayList<>();

        for (int i = 0; i < width*height; i++) {
            tileMap.add(null);
        }

    }

    public void addTile(Tile t) {
        tiles.add(t);
    }


    public ArrayList<Integer> getFloorTiles() {
        var floorTiles = new ArrayList<Integer>();
        for (int i = 0; i < tileMap.size(); i++) {
            if (tileMap.get(i) != null && !tiles.get(tileMap.get(i)).isSolid()) {
                floorTiles.add(i);
            }
        }
        return floorTiles;
    }


    public void draw(Renderer renderer) {
//        System.out.println("World.draw() width=" + width + ", height=" + height + ", tileMap.size()=" + tileMap.size() + ", tiles.size()=" + tiles.size());
        for (int i = 0; i < tileMap.size(); i++) {
            if (tileMap.get(i) == null) {
                continue;
            }

            var tileIndex = tileMap.get(i);

            var x = i % width;
            var y = (i / width);
            var spriteName = tiles.get(tileIndex).spriteName;
            if (spriteName != null) {
                renderer.drawSprite(spriteName,x,y);
            }
        }
    }

    public int size() {
        return width*height;
    }

    public void setTile(String name,int col, int row) {
        //search for the tile
        var tileIndex = -1;
        for (int i = 0; i < tiles.size(); i++) {
            var tile = tiles.get(i);
            if (tile != null && tile.spriteName.equals(name)) {
                tileIndex = i;
                break;
            }
        }

        var idx = row*width + col;
        tileMap.set(idx,tileIndex);
    }

    public Tile getTile(int col, int row) {
        var idx = row*width + col;
        var tileIndex = tileMap.get(idx);
        return tiles.get(tileIndex);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Integer getRandomFreeIdx() {
        var idx = (int) (Math.random() * tileMap.size()/2);
        while (tileMap.get(idx) != null && tiles.get(tileMap.get(idx)).isSolid()) {
            idx = (int) (Math.random() * tileMap.size()/2);
        }
        return idx;
    }

}
