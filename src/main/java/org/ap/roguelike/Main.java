package org.ap.roguelike;

import org.ap.roguelike.scenes.MainScene;
import org.ap.roguelike.utils.scene.Scene;
import org.ap.roguelike.utils.scene.SceneManager;
import processing.core.PApplet;
import processing.core.PGraphics;

public class Main extends PApplet {


    private PGraphics g;
    private Spritesheet spritesheet;

    private SceneManager sceneManager;
    private Scene currentScene;

    private Renderer renderer;
    public Main() {

//        hero = new Hero();
        sceneManager = new SceneManager();

    }

    @java.lang.Override
    public void settings() {
        size(1000,800);
        g = getGraphics();
    }

    @java.lang.Override
    public void setup() {
        g = getGraphics();
        var sprite = loadImage("assets/sprites.png");
        spritesheet = new Spritesheet(sprite);

        spritesheet.defineSprite("hero",0,27);





        spritesheet.defineSprite("floor",0,3);
        spritesheet.defineSprite("wall",13,0);
        spritesheet.defineSprite("stairs",6,2);

        renderer = new Renderer(g,spritesheet);

        var mainScene = new MainScene(sceneManager,renderer);
        mainScene.setup();


        sceneManager.addScene(mainScene);
        sceneManager.setCurrentScene("main");
        currentScene = sceneManager.getCurrentScene();
    }

    @java.lang.Override
    public void keyTyped() {
        currentScene.keyTyped(key);

    }

    @java.lang.Override
    public void draw() {
        background(55);
        currentScene.draw();

    }

    public static void main(String[] args) {

        PApplet.main("org.ap.roguelike.Main");
    }
}