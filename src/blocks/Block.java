package blocks;

import java.util.Random;

import main.Game;
import text.Display;

public abstract class Block {

    protected Character bChar;
    protected int length, height;
    protected Character[][] model, asyncModel;
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

        if ((loops % (1 + ((int) ((1000 / BLOCKSPEED) / (1000 / FPS)))) == 0
                && canFall(display))) {
            yLoc++;
        }
        // Shifting
        if (canShift(display)) {
            xLoc = asyncXLoc;
        }
        else {
            asyncXLoc = xLoc;
        }
        // Rotating
        if (canRotate(display)) {
            model = asyncModel;
        }
        else {
            asyncModel = model;
        }
        display.render(model, xLoc, yLoc);
    }

    private boolean canRotate(Display display) {

        Character[][] screen = display.getScreen();

        for (int h = 0; h < asyncModel[0].length; h++) {
            for (int l = 0; l < asyncModel.length; l++) {
                if (asyncModel[l][h] != null
                        && screen[l + xLoc][h + yLoc] != null
                        && screen[l + xLoc][h + yLoc] != ' ') {

                    return false;
                }
            }
        }

        return true;
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

        int numberOfBlocks = 6;

        Random random = new Random();
        int id = random.nextInt(numberOfBlocks);

        if (id == 0) {
            return new TBlock();
        }
        else if (id == 1) {
            return new IBlock();
        }
        else if (id == 2) {
            return new JBlock();
        }
        else if (id == 3) {
            return new ZBlock();
        }
        else if (id == 4) {
            return new SBlock();
        }
        else if (id == 5) {
            return new LBlock();
        }
        else {
            return new OBlock();
        }

    }

    public void rotate() {
        Character[][] newModel = new Character[model[0].length][model.length];

        // Swap rows and columns and reverse rows
        for (int h = 0; h < model[0].length; h++) {
            for (int l = 0; l < model.length; l++) {
                newModel[newModel.length - 1 - h][l] = model[l][h];
            }
        }

        asyncModel = newModel;
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
