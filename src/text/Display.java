package text;

public class Display {

    public static final int length = 20;
    public static final int height = 20;

    private static Character[][] screen;

    public Display() {
        screen = new Character[length][height];
        fillBorder();
    }

    public void clearCompleteLines() {
        // Loop through each line
        for (int h = 0; h < height - 1; h++) {

            boolean bubble = false;

            // Loop through the row
            for (int l = 1; l < length - 1; l++) {
                if (screen[l][h] == null || screen[l][h] == ' ') {
                    bubble = true;
                }
            }

            // If there are no bubbles, then clear the row
            if (!bubble) {
                clearRow(h);
            }
        }

    }

    private void clearRow(int row) {
        for (int l = 1; l < screen.length - 1; l++) {
            screen[l][row] = ' ';
        }
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
        for (int h = 0; h < model[0].length; h++) {
            for (int l = 0; l < model.length; l++) {
                if (model[l][h] != null && y + h >= 0) {
                    screen[x + l][y + h] = model[l][h];
                }
            }
        }
    }

    public void erase(Character[][] model, int x, int y) {
        for (int h = 0; h < model[0].length; h++) {
            for (int l = 0; l < model.length; l++) {
                if (y + h >= 0 && model[l][h] != null) {
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
            // System.out.println(currLine);
        }

    }

    public Character[][] getScreen() {
        return screen;
    }

}
