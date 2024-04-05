package org.ap.roguelike.utils.scene;

import java.util.HashMap;

public class SceneManager {
    private HashMap<String, Scene> scenes = new HashMap<>();
    private Scene currentScene;

    public void addScene(Scene scene) {
        scenes.put(scene.getName(), scene);
    }

    public void setCurrentScene(String name) {
        currentScene = scenes.get(name);

    }

    public Scene getCurrentScene() {
        return currentScene;
    }


}
