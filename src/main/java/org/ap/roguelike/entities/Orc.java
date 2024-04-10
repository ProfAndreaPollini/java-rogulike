package org.ap.roguelike.entities;

import org.ap.roguelike.Renderer;
import org.ap.roguelike.World;

public class Orc extends NPC {

    private String state = "idle";
    private Integer fov = 7;

    public Orc() {
        super("orc");


    }

    private void idle(World world) {
        // random move
        var dx = (int) (Math.random() * 3) - 1;
        var dy = (int) (Math.random() * 3) - 1;

        // check if there is a movement
        if (dx == 0 && dy == 0) {
            return;
        }

        var desiredX = getX() + dx;
        var desiredY = getY() + dy;

        // check grid bounds
        if (!world.isInBounds(desiredX, desiredY)) {
            return;
        }

        var tile = world.getTile(desiredX,desiredY);

        if (tile.isSolid()) {
            return;
        }
        move(dx, dy);
    }

    @Override
    public void update(World world) {
        var distanceFromHero = Math.abs(world.getHero().getX() - getX()) + Math.abs(world.getHero().getY() - getY());

        if (distanceFromHero < fov) {
            state = "chase";
        } else {
            state = "idle";
        }

        if (state.equals("idle")) {
            idle(world);
        } else if (state.equals("chase")) {
            idle(world);
        }
//        currentState.update(world);

    }

    @Override
    public void draw(Renderer renderer) {
        if (state.equals("chase")) {
            renderer.getGraphics().fill(255,0,0);
            renderer.circle(getX(), getY(), 20);
        }

        super.draw(renderer);
    }
}
