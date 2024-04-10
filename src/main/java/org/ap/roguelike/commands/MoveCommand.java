package org.ap.roguelike.commands;

import org.ap.roguelike.World;
import org.ap.roguelike.entities.Entity;
import org.ap.roguelike.utils.Vec2i;

public class MoveCommand implements Command{


    private final Vec2i desiredPos;
    private final Vec2i oldPos;
    private final Entity entity;

    public MoveCommand(Entity entity, Vec2i oldPos, Vec2i desiredPos) {
        this.entity = entity;
        this.oldPos = oldPos;
        this.desiredPos = desiredPos;
    }



    @Override
    public void execute(World world) {
        entity.setPosition(desiredPos);
        var tile = world.getTile(desiredPos);
//        world.addEvent(new HeroMovedEvent(entity, oldPos, desiredPos, tile));
    }
}
