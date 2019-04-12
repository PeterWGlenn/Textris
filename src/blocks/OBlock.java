package blocks;

import text.Display;

public class OBlock extends Block {

    public OBlock() {
        length = 2;
        height = 2;
        model = new Character[2][2];
        model[0][0] = model[0][1] = model[1][0] = model[1][1] = bChar;

        xLoc = (Display.length / 2) - (length / 2);
        yLoc = -height;
    }

    public OBlock(int x) {
        length = 2;
        height = 2;
        model = new Character[2][2];
        model[0][0] = model[0][1] = model[1][0] = model[1][1] = bChar;

        xLoc = x;
        yLoc = 0;
    }

}
