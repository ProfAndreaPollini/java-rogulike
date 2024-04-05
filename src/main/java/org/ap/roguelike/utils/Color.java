package org.ap.roguelike.utils;

public record Color (int r, int g, int b) {
    public Color(int c) {
        this((c & 0xFF0000) >> 16, (c & 0xFF00) >> 8, c & 0xFF);
    }
}
