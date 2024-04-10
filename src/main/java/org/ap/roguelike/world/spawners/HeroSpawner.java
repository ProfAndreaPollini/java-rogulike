package org.ap.roguelike.world.spawners;

import org.ap.roguelike.World;

public class HeroSpawner implements SpawnStrategy{
    @Override
    public void spawn(World world) {
        var freePosIdx = world.getRandomFreeIdx();
        world.getHero().setX(freePosIdx % world.getWidth());
        world.getHero().setY(freePosIdx / world.getWidth());
    }
}
