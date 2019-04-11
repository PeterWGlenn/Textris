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
        if (canFall()) {
            yLoc++;
        }
        display.render(model, xLoc, yLoc);
    }

    private boolean canFall() {
        return true;
    }

}
