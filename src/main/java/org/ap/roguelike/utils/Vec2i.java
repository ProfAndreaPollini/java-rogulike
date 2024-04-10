package org.ap.roguelike.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vec2i {
    private int x;
    private int y;

    public static Vec2i zero() {
        return new Vec2i(0, 0);
    }

    public Vec2i add(Vec2i other) {
        return new Vec2i(x + other.x, y + other.y);
    }

    public static Vec2i randomDirection() {
        var dx = (int) (Math.random() * 3) - 1;
        var dy = (int) (Math.random() * 3) - 1;
        return new Vec2i(dx, dy);
    }

    public boolean isZero() {
        return x == 0 && y == 0;
    }
}
