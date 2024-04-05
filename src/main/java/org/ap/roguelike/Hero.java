package org.ap.roguelike;

public class Hero {
    private int x;
    private int y;
    private String spriteName;

    public Hero(){
        x=10;
        y=10;
        spriteName = "hero";
    }

    public void draw(Renderer renderer) {
        renderer.drawSprite(spriteName,x,y);
    }

    public void moveLeft(int dx) {
        move(-dx,0);
    }

    public void moveRight(int dx) {
        move(dx,0);
    }

    public void move(int dx, int dy) {
        System.out.println("Hero.move(" + dx + ", " + dy + ")");
        x += dx;
        y += dy;
        System.out.println("Hero.move() x=" + x + ", y=" + y);
    }

    public void moveDown(int dy) {
        move(0,dy);
    }

    public void moveUp(int dy) {
        move(0,-dy);
    }

    public void setSprite(String spriteName) {
        this.spriteName = spriteName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
