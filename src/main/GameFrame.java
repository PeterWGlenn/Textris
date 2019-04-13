package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import text.Display;

public class GameFrame extends JPanel implements Runnable {

    /**
     * The scale at which the game is rendered
     */
    public static final double SCALE = 1.0;
    /**
     * The width of the frame in pixels
     */
    public static final int WIDTH = (int) (1080 * SCALE);
    /**
     * The height of the frame in pixels
     */
    public static final int HEIGHT = (int) (1080 * SCALE);
    /**
     * The frames per second of the game
     */
    public static final int FPS = 60;

    private static final long serialVersionUID = 1L;
    private static boolean isRunning;
    private static GameFrame gameComponent = new GameFrame();
    private static JFrame frame = new JFrame();

    /**
     * Initializes a new GameFrame object
     */
    private GameFrame() {
        start();
    }

    /**
     * Starts the GameFrame by setting isRunning to true.
     */
    private void start() {
        isRunning = true;
        new Thread(this).start();
    }

    @Override
    public void run() {

        while (isRunning) {

            try {

                // Repaint
                repaint();

                double tick = 1000.0 / FPS;
                Thread.sleep((long) tick);

            }
            catch (Exception e) {
                System.out.println("Game loop exception: " + e.toString());
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int pixCharAmount = (int) (WIDTH / Display.length);

        // Paint World
        for (int h = 0; h < Display.height; h++) {
            for (int l = 0; l < Display.length; l++) {

                g.setColor(Color.BLACK);
                Character c = Game.display.getScreen()[l][h];
                if (c != null && c != ' ') {

                    // Pick Color
                    if (c == '#') {
                        g.setColor(Color.ORANGE);
                    }

                    // Draw
                    g.fillRect((int) (l * pixCharAmount * SCALE),
                            (int) ((h * pixCharAmount * SCALE)
                                    - pixCharAmount),
                            (int) (pixCharAmount * SCALE),
                            (int) (pixCharAmount * SCALE));
                    g.setColor(Color.BLACK);
                    g.drawRect((int) (l * pixCharAmount * SCALE),
                            (int) ((h * pixCharAmount * SCALE)
                                    - pixCharAmount),
                            (int) (pixCharAmount * SCALE),
                            (int) (pixCharAmount * SCALE));
                }
            }
        }

    }

    public static void startFrame() {
        Dimension size = new Dimension(WIDTH, HEIGHT);
        frame.setTitle("Textris");
        frame.setVisible(true);
        frame.setSize(size);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameComponent);

        // Controls
        frame.addKeyListener(new Controls());
    }

}
