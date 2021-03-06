package main;

import blocks.Block;
import text.Display;

public class Game {

    private static final int FPS = 100;
    private static final double BLOCKSPEED = 2.0;
    private static double blockSpeedHardDropMultiplier = 1.0;
    private static double blockSpeedLevelMultiplier = 1.0;
    private static boolean hasLost = false;
    protected static Block block;
    protected static Display display = new Display();

    private static int blocksFallen = 0;

    public static void main(String[] args) throws InterruptedException {

        GameFrame.startFrame();
        int loops = 0;

        // Game Loop3
        while (!hasLost) {

            // First Block
            if (block == null) {
                block = Block.getRandomBlockType();
            }

            // Updates
            block.update(display, loops, FPS,
                    BLOCKSPEED * blockSpeedHardDropMultiplier
                            * blockSpeedLevelMultiplier);
            display.update();

            // Spawn New Blocks
            if (!block.falling()) {
                block = Block.getRandomBlockType();
                blocksFallen++;
                blockSpeedLevelMultiplier += (blocksFallen / 1000.0);

                display.clearCompleteLines();
            }

            // Sleep
            Thread.sleep((long) (1000.0 / FPS));
            loops++;
        }
    }

    public static void lose() {
        hasLost = true;
    }

    public static void setBSM(double bsm) {
        blockSpeedHardDropMultiplier = bsm;
    }

}
