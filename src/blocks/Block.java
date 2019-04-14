package blocks;

import java.util.Random;

import main.Game;
import text.Display;

public abstract class Block {

    protected Character bChar;
    protected int length, height;
    protected Character[][] model;
    protected boolean falling = true;

    protected int xLoc, yLoc, asyncXLoc;

    public Block() {
        xLoc = (Display.length / 2) - (length / 2);
        yLoc = -height;
        asyncXLoc = xLoc;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public Character[][] getModel() {
        return model;
    }

    public void update(Display display, int loops, int FPS,
            double BLOCKSPEED) {
        display.erase(model, xLoc, yLoc);
        if ((loops % ((1000 / BLOCKSPEED) / (1000 / FPS))) == 0
                && canFall(display)) {
            yLoc++;
        }
        if (canShift(display)) {
            xLoc = asyncXLoc;
        }
        else {
            asyncXLoc = xLoc;
        }
        display.render(model, xLoc, yLoc);
    }

    private boolean canFall(Display display) {

        Character[][] screen = display.getScreen();

        for (int h = 0; h < model[0].length; h++) {
            for (int l = 0; l < model.length; l++) {
                if (model[l][h] != null
                        && screen[l + xLoc][h + 1 + yLoc] != null
                        && screen[l + xLoc][h + 1 + yLoc] != ' ') {
                    falling = false;

                    // Check for loss
                    if (yLoc <= 0) {
                        Game.lose();
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean canShift(Display display) {

        Character[][] screen = display.getScreen();

        for (int h = 0; h < model[0].length; h++) {
            for (int l = 0; l < model.length; l++) {
                if (screen[asyncXLoc + l][yLoc + h] != null
                        && screen[asyncXLoc + l][yLoc + h] != ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public static Block getRandomBlockType() {

        int numberOfBlocks = 2;

        Random random = new Random();
        int id = random.nextInt(numberOfBlocks);

        if (id == 0) {
            return new TBlock();
        }
        else {
            return new OBlock();
        }

    }

    public boolean falling() {
        return falling;
    }

    public void shiftRight() {

        asyncXLoc = xLoc;
        asyncXLoc++;

    }

    public void shiftLeft() {

        asyncXLoc = xLoc;
        asyncXLoc--;
    }

}
