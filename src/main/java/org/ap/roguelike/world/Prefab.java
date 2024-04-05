package org.ap.roguelike.world;

import org.ap.roguelike.utils.Color;

import java.util.List;

public interface Prefab {
    int getWidth();
    int getHeight();
    List<Color> getData();
}
