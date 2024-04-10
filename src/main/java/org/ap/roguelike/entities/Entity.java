package org.ap.roguelike.entities;

import lombok.Setter;
import org.ap.roguelike.Renderer;
import org.ap.roguelike.World;
import org.ap.roguelike.utils.Vec2i;

public abstract class Entity {

    protected String spriteName;
    @Setter
    protected Vec2i position;

    public Entity(String spriteName) {

        position = new Vec2i(10,10);
        this.spriteName = spriteName;
    }

    public  void draw(Renderer renderer){
        renderer.drawSprite(spriteName, position.getX(), position.getY());
    }

    public  void move(int dx, int dy){
        position = position.add(new Vec2i(dx,dy));
    }

    public void move(Vec2i dpos) {
        position = position.add(dpos);
    }

    public void setSprite(String spriteName) {
        this.spriteName = spriteName;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public void setX(int x) {
        position.setX(x);
    }

    public void setY(int y) {
        position.setY(y);
    }


    public void update(World world) {

    }
}
