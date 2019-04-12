package text;

public class Display {

    public static final int length = 20;
    public static final int height = 10;

    private static Character[][] screen;

    public Display() {
        screen = new Character[length][height];
        fillBorder();
    }

    private void fillBorder() {
        for (int h = 0; h < height; h++) {
            for (int l = 0; l < length; l++) {
                // Bottom
                if (l == 0 || l == length - 1) {
                    screen[l][h] = '|';
                }
                // Sides
                if (h == height - 1) {
                    screen[l][h] = '-';
                }
            }
        }
    }

    public void render(Character[][] model, int x, int y) {
        for (int h = 0; h < model.length; h++) {
            for (int l = 0; l < model[0].length; l++) {
                if (model[l][h] != null && y + h >= 0) {
                    screen[x + l][y + h] = model[l][h];
                }
            }
        }
    }

    public void erase(Character[][] model, int x, int y) {
        for (int h = 0; h < model.length; h++) {
            for (int l = 0; l < model[0].length; l++) {
                if (y + h >= 0) {
                    screen[x + l][y + h] = ' ';
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

    public Character[][] getScreen() {
        return screen;
    }

}
