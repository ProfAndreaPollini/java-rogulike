package org.ap.roguelike.world;

import org.ap.roguelike.Tile;
import org.ap.roguelike.World;
import org.ap.roguelike.world.spawners.SpawnStrategy;

import java.util.ArrayList;
import java.util.List;

public class WorldBuilder {


    private World world;
    private int width;
    private int height;

    private List<WorldBuilderStrategy> steps = new ArrayList<>();
    private List<SpawnStrategy> spawners = new ArrayList<>();

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
    public void addSpawner(SpawnStrategy spawner) {
        spawners.add(spawner);
    }
    
    public World build() {
        for (WorldBuilderStrategy step : steps) {
            step.build(this);
        }

        for (SpawnStrategy spawner : spawners) {
            spawner.spawn(world);
        }
        return world;
    }

    public World getGrid() {
        return world;
    }
}
