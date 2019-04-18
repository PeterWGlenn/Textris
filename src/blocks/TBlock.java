package blocks;

public class TBlock extends Block {

    public TBlock() {

        bChar = 'T';

        length = 3;
        height = 2;
        model = new Character[length][height];
        model[0][0] = model[1][0] = model[2][0] = model[1][1] = bChar;
        asyncModel = model;
    }

}
