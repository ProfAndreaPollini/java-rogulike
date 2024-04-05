package org.ap.roguelike.world;

import org.ap.roguelike.Tile;
import org.ap.roguelike.World;

import java.util.ArrayList;
import java.util.List;

public class WorldBuilder {


    private World world;
    private int width;
    private int height;

    private List<WorldBuilderStrategy> steps = new ArrayList<>();

    public WorldBuilder(int width, int height) {
        width = width;
        height = height;

        world = new World(width,height);
    }

    public void addTile(Tile t) {
        world.addTile(t);
    }

    public void addStep(WorldBuilderStrategy step) {
        steps.add(step);
    }
    
    public World build() {
        for (WorldBuilderStrategy step : steps) {
            step.build(this);
        }
        return world;
    }

    public World getGrid() {
        return world;
    }
}
