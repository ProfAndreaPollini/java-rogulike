package org.ap.roguelike.commands;

import org.ap.roguelike.World;

public interface Command {
    void execute(World world);
}
