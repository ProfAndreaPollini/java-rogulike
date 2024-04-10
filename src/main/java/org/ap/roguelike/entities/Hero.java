package org.ap.roguelike.entities;

import org.ap.roguelike.World;
import org.ap.roguelike.commands.MoveCommand;
import org.ap.roguelike.utils.Vec2i;

public class Hero extends Entity {

    private char lastKeyPressed;

    public Hero(){
        super("hero");
    }



    public void moveLeft(int dx) {
        move(-dx,0);
    }

    public void moveRight(int dx) {
        move(dx,0);
    }



    public void moveDown(int dy) {
        move(0,dy);
    }

    public void moveUp(int dy) {
        move(0,-dy);
    }

    @Override
    public void update(World world) {
        Vec2i dpos = Vec2i.zero();

        if (lastKeyPressed == 'a') {
            dpos.setX(-1);
        }
        if (lastKeyPressed =='d') {
            dpos.setX(1);
        }
        if (lastKeyPressed == 's') {
            dpos.setY(1);
        }  if (lastKeyPressed == 'w') {
            dpos.setY(-1);
        }

        // check if there is a movement
        if (dpos.isZero()) {
            return;
        }

        var oldPos = position;
        var desiredPos = position.add(dpos);


        if (!canMove(desiredPos, world)) {
            return;
        }
        var moveCmd = new MoveCommand(this, oldPos,desiredPos);
        world.addCommand(moveCmd);
//        moveCmd.execute(world);
//        // check grid bounds
//        if (!world.isInBounds(desiredPos)) {
//            return;
//        }
//
//        var tile = world.getTile(desiredPos);
//
//        if (tile.isSolid()) {
//            return;
//        }

//        move(dx,dy);
//        position = position.add(dpos);



//        if (tile.spriteName.equals("stairs")) {
////            generateLevel(renderer.getGraphics());
////            return;
//        }
    }

    public boolean canMove(Vec2i desiredPos, World world) {

        if (!world.isInBounds(desiredPos)) {
            return false;
        }

        var tile = world.getTile(desiredPos);

        return !tile.isSolid();
    }

    public void keyTyped(char lastKeyPressed) {
        this.lastKeyPressed = lastKeyPressed;
    }
}
