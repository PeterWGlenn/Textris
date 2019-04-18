package blocks;

public class OBlock extends Block {

    public OBlock() {

        bChar = 'O';

        length = 2;
        height = 2;
        model = new Character[length][height];
        model[0][0] = model[0][1] = model[1][0] = model[1][1] = bChar;
        asyncModel = model;

    }

    public OBlock(int x) {
        length = 2;
        height = 2;
        model = new Character[2][2];
        model[0][0] = model[0][1] = model[1][0] = model[1][1] = bChar;
        asyncModel = model;

        xLoc = x;
        yLoc = 0;
    }

}
