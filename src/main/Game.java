package main;

import blocks.Block;
import blocks.TBlock;
import text.Display;

public class Game {

    private static final int FPS = 100;
    private static final double BLOCKSPEED = 5.0;
    private static boolean hasLost = false;
    protected static Block block;
    protected static Display display = new Display();

    public static void main(String[] args) throws InterruptedException {

        GameFrame.startFrame();
        int loops = 0;

        // Game Loop
        while (!hasLost) {

            // First Block
            if (block == null) {
                block = new TBlock();
            }

            // Updates
            block.update(display, loops, FPS, BLOCKSPEED);
            display.update();

            // Spawn New Blocks
            if (!block.falling()) {
                block = new TBlock();
            }

            // Sleep
            Thread.sleep((long) (1000.0 / FPS));
            loops++;
        }
    }

    public static void lose() {
        hasLost = true;
    }

}
