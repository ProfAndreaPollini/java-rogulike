package org.ap.roguelike;

import org.ap.roguelike.commands.Command;
import org.ap.roguelike.entities.Entity;
import org.ap.roguelike.entities.Hero;
import org.ap.roguelike.entities.NPC;
import org.ap.roguelike.utils.Vec2i;

import java.util.ArrayList;
import java.util.List;

public class World {

    private int width;
    private int height;

    private ArrayList<Integer> tileMap = new ArrayList<>();
    private ArrayList<Tile> tiles;
    private ArrayList<NPC> entities = new ArrayList<>();
    Hero hero;

    private List<Command> commands = new ArrayList<>();


    public World(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new ArrayList<>();
        entities = new ArrayList<>();

        for (int i = 0; i < width*height; i++) {
            tileMap.add(null);
        }
        hero = new Hero();

    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void processCommands() {
        for (Command command : commands) {
            command.execute(this);
        }
        commands.clear();
    }

    public void addTile(Tile t) {
        tiles.add(t);
    }
    public void addNPC(NPC e) {
        entities.add(e);
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

        for (Entity e : entities) {
            e.draw(renderer);
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

    public void update() {

        for (NPC e : entities) {
            e.update(this);
        }
    }

    public Hero getHero() {
        return hero;
    }

    public boolean isInBounds(int desiredX, int desiredY) {
        return !(desiredX < 0 || desiredX >= width || desiredY < 0 || desiredY >= height);
    }

    public boolean isInBounds(Vec2i desideredPos) {
        return isInBounds(desideredPos.getX(),desideredPos.getY());
    }

    public Tile getTile(Vec2i desideredPos) {
        return getTile(desideredPos.getX(),desideredPos.getY());
    }
}
