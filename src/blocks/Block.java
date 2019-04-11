package blocks;

import text.Display;

public abstract class Block {

    protected final Character bChar = '#';
    protected int length, height;
    protected Character[][] model;

    protected int xLoc, yLoc;

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public Character[][] getModel() {
        return model;
    }

    public void update(Display display) {
        display.erase(model, xLoc, yLoc);
        if (canFall(display)) {
            yLoc++;
        }
        display.render(model, xLoc, yLoc);
    }

    private boolean canFall(Display display) {

        Character[][] screen = display.getScreen();

        for (int l = 0; l < model[0].length; l++) {
            if (model[l][height - 1] != null
                    && screen[l + xLoc][height + yLoc] != null) {
                return false;
            }

        }

        return true;
    }

}
