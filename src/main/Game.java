package main;

import text.Display;

public class Game {

    private static final int FPS = 1;

    public static void main(String[] args) throws InterruptedException {

        // Create Display
        Display display = new Display();

        Character[][] model = new Character[3][3];
        model[0][0] = '#';
        model[1][0] = '#';
        model[2][0] = '#';
        model[1][1] = '#';
        display.render(model, 6, 7);

        // Game Loop
        while (true) {

            display.update();
            Thread.sleep((long) (1000.0 / FPS));
        }
    }

}
