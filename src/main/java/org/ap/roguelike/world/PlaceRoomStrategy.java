package org.ap.roguelike.world;

import org.ap.roguelike.utils.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaceRoomStrategy implements WorldBuilderStrategy {

    private final int width;
    private final int height;
    List<Prefab> prefabs;
    HashMap<Color,String> colorMapper = new HashMap<>();
    List<Prefab> rooms;

    public PlaceRoomStrategy(int width, int height) {
        this.width = width;
        this.height = height;
        rooms = new ArrayList<>();

        this.prefabs = new ArrayList<>();
    }

    public void addPrefab(SimplePrefab prefab) {
        prefabs.add(prefab);
    }

    public void addColorMap(Color color, String name) {
        colorMapper.put(color,name);
    }

    @Override
    public void build(WorldBuilder builder) {
        // fill rooms
        for (int i = 0; i < width*height; i++) {
            var room = prefabs.get((int) (Math.random() * prefabs.size()));
            rooms.add(room);
        }

        // select random prefab
        for(int i = 0; i < width*height; i++) {
            var room = rooms.get(i);

            var xPos = i % width;
            var yPos = i / width;
            var offsetY = 0;
            for (int j = 0; j < yPos; j++) {
                var idx = j * width + xPos;
                offsetY += rooms.get(idx).getHeight();
            }

            var offsetX = 0;

            for (int j = 0; j < xPos; j++) {
                var idx = yPos * width + j;
                offsetX += rooms.get(idx).getWidth();
            }
            var x = xPos * room.getWidth();
            var y = yPos * room.getHeight();
            for (int j = 0; j < room.getWidth(); j++) {
                for (int k = 0; k < room.getHeight(); k++) {
                    var color = room.getData().get(j + k * room.getWidth());
                    var name = colorMapper.get(color);
                    if (name == null) {
                        continue;
                    }
                    builder.getGrid().setTile(name,offsetX + j,offsetY + k);
                }
            }
        }

    }
}
