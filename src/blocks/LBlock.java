package blocks;

public class LBlock extends Block {

    public LBlock() {

        bChar = 'L';

        length = 3;
        height = 2;
        model = new Character[length][height];
        model[0][1] = model[1][1] = model[2][1] = model[2][0] = bChar;

    }

}
