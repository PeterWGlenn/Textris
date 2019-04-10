package text;

public class Display {

    private static final int length = 20;
    private static final int height = 10;

    private static char[][] screen;

    public Display() {
        screen = new char[length][height];
    }

    public void populate() {
        for (int h = 0; h < height; h++) {
            for (int l = 0; l < length; l++) {
                screen[l][h] = '#';
            }
        }
    }

    public void update() {

        for (int h = 0; h < height; h++) {
            String currLine = "";
            for (int l = 0; l < length; l++) {
                currLine += screen[l][h];
            }
            System.out.println(currLine);
        }

    }

}
