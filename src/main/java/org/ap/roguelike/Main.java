package org.ap.roguelike;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.ap.roguelike.scenes.MainScene;
import org.ap.roguelike.utils.scene.Scene;
import org.ap.roguelike.utils.scene.SceneManager;
import processing.core.PApplet;
import processing.core.PGraphics;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends PApplet {


    private PGraphics g;
    private Spritesheet spritesheet;

    private SceneManager sceneManager;
    private Scene currentScene;

    private Renderer renderer;
    public Main() {


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

        try {
            var config = Files.readString(Path.of("assets/config.json"));

            var json = Jsoner.deserialize(config, new JsonObject());
            System.out.println(json);
            var spritesConfig = (JsonArray) json.get("sprites");
            for (Object o : spritesConfig) {
                var spriteInfo = (JsonObject) o;
                System.out.println(spriteInfo);

                var row = (BigDecimal) spriteInfo.get("row");
                var col = (BigDecimal) spriteInfo.get("col");
                var name = (String) spriteInfo.get("name");
                System.out.println("loading sprite info: " + name);

                spritesheet.defineSprite(name, row.intValue(), col.intValue());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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
        currentScene.update();
        currentScene.draw();

    }

    public static void main(String[] args) {

        PApplet.main("org.ap.roguelike.Main");
    }
}