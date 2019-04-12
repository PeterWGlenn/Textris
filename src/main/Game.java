package main;

import blocks.Block;
import blocks.OBlock;
import text.Display;

public class Game {

    private static final int FPS = 3;
    private static boolean hasLost = false;

    public static void main(String[] args) throws InterruptedException {

        // Create Display
        Display display = new Display();

        Block block = new OBlock();

        // Game Loop
        while (!hasLost) {

            // Updates
            block.update(display);
            display.update();

            // Spawn New Blocks
            if (!block.falling()) {
                block = new OBlock();
            }

            // Sleep
            Thread.sleep((long) (1000.0 / FPS));
        }
    }

    public static void lose() {
        hasLost = true;
    }

}
