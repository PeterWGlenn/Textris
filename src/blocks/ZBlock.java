package blocks;

public class ZBlock extends Block {

    public ZBlock() {

        bChar = 'Z';

        length = 3;
        height = 2;
        model = new Character[length][height];
        model[0][0] = model[1][0] = model[1][1] = model[2][1] = bChar;

    }

}
