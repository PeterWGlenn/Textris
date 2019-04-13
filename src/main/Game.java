package main;

import blocks.Block;
import blocks.OBlock;
import text.Display;

public class Game {

    private static final int FPS = 15;
    private static boolean hasLost = false;
    protected static Block block;
    protected static Display display = new Display();

    public static void main(String[] args) throws InterruptedException {

        GameFrame.startFrame();

        // Game Loop
        while (!hasLost) {

            // First Block
            if (block == null) {
                block = new OBlock();
            }

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
