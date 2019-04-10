package text;

public class Display {

    private static final int length = 20;
    private static final int height = 10;

    private static Character[][] screen;

    public Display() {
        screen = new Character[length][height];
        fillBorder();
    }

    private void fillBorder() {
        for (int h = 0; h < height; h++) {
            for (int l = 0; l < length; l++) {
                if (l == 0 || h == 0 || l == length - 1 || h == height - 1) {
                    screen[l][h] = '.';
                }
            }
        }
    }

    public void render(Character[][] model, int x, int y) {
        for (int h = 0; h < model.length; h++) {
            for (int l = 0; l < model[0].length; l++) {
                if (model[l][h] != null) {
                    screen[x + l][y + h] = model[l][h];
                }
            }
        }
    }

    public void update() {

        for (int h = 0; h < height; h++) {
            String currLine = "";
            for (int l = 0; l < length; l++) {
                if (screen[l][h] != null) {
                    currLine += screen[l][h];
                }
                else {
                    currLine += ' ';
                }
            }
            System.out.println(currLine);
        }

    }

}
