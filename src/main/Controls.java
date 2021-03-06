package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Controls extends KeyAdapter implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int c = e.getKeyCode();

        // Movement
        if (c == KeyEvent.VK_D || c == KeyEvent.VK_RIGHT) {
            Game.block.shiftRight();
        }
        if (c == KeyEvent.VK_A || c == KeyEvent.VK_LEFT) {
            Game.block.shiftLeft();
        }

        // Rotate
        if (c == KeyEvent.VK_W || c == KeyEvent.VK_UP) {
            Game.block.rotate();
        }

        // Drop
        if (c == KeyEvent.VK_S || c == KeyEvent.VK_DOWN) {
            Game.setBSM(15.0);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        int c = e.getKeyCode();

        // Drop
        if (c == KeyEvent.VK_S || c == KeyEvent.VK_DOWN) {
            Game.setBSM(1.0);
        }

    }

}
