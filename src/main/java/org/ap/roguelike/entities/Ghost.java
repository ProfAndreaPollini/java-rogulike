package org.ap.roguelike.entities;

import org.ap.roguelike.World;
import org.ap.roguelike.utils.Vec2i;

public class Ghost extends NPC {
    public Ghost() {
        super("ghost");
    }

    public void update(World world) {
        // random move
        var dx = (int) (Math.random() * 3) - 1;
        var dy = (int) (Math.random() * 3) - 1;

        var dpos = Vec2i.randomDirection();
        if (dpos.isZero()) {
            return;
        }

        move(dpos);
    }
}
