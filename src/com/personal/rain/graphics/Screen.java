package com.personal.rain.graphics;

import java.util.Random;

public class Screen {

    private int width;
    private int height;
    public int[] pixels;

    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;

    // creating an integer for tracking a new tiles
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[this.width * this.height];  // 50,400
        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xFFFFFF);
            tiles[0] = 0;
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void render(int xOffSet, int yOffSet) {
        for (int y = 0; y < height; y++) {
            int yy = y + yOffSet;
//            if (yy < 0 || yy >= height) break;
            for (int x = 0; x < width; x++) {
                int xx = x + xOffSet;
//                if (xx < 0 || xx >= width) break;
                //se divide el sprite en 16
                //int tileIndex = (x / 16) + (y / 16) * 64;  
                int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
                pixels[x + y * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
            }
        }
    }

}
