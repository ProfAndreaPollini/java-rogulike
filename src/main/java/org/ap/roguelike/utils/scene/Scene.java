package org.ap.roguelike.utils.scene;

public abstract class Scene {
    private final String name;

    public Scene(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public  void setup() {

    }
    public  void update() {}

    public abstract void draw();

    public void keyTyped(char key) {

    }
}
