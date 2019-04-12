package main;

import blocks.Block;
import blocks.OBlock;
import text.Display;

public class Game {

    private static final int FPS = 1;

    public static void main(String[] args) throws InterruptedException {

        // Create Display
        Display display = new Display();

        Block block = new OBlock();

        // Game Loop
        while (true) {

            // Updates
            block.update(display);
            display.update();

            // Spawn New Blocks
            if (!block.falling()) {
                block = new OBlock();
                System.out.println("newBlock");
            }

            // Sleep
            Thread.sleep((long) (1000.0 / FPS));
        }
    }

}
