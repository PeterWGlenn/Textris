package blocks;

public class IBlock extends Block {

    public IBlock() {

        bChar = 'I';

        length = 1;
        height = 4;
        model = new Character[length][height];
        model[0][0] = model[0][1] = model[0][2] = model[0][3] = bChar;
        asyncModel = model;
    }

}
