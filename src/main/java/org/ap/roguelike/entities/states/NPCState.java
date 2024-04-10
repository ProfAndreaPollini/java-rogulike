package org.ap.roguelike.entities.states;

import org.ap.roguelike.Renderer;
import org.ap.roguelike.World;

public interface NPCState {
    void update(World world);
    void draw(Renderer renderer);
}
