package blocks;

public class SBlock extends Block {

    public SBlock() {

        bChar = 'S';

        length = 3;
        height = 2;
        model = new Character[length][height];
        model[0][1] = model[1][1] = model[1][0] = model[2][0] = bChar;

    }

}
