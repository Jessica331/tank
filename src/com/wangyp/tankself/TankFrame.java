package com.wangyp.tankself;

import java.awt.*;
import java.awt.event.*;

public class TankFrame  extends Frame{

    int x=200, y=200;

    public TankFrame() {

        setSize(800, 600);
        setVisible(true);
        setTitle("Tank War");

        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
    }

    class MyKeyListener extends KeyAdapter {

        boolean tankLeft = false;
        boolean tankRight = false;
        boolean tankUp = false;
        boolean tankDown = false;

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_UP: tankUp = true; break;
                case KeyEvent.VK_DOWN: tankDown = true; break;
                case KeyEvent.VK_LEFT: tankLeft = true; break;
                case KeyEvent.VK_RIGHT: tankRight = true; break;
                default: break;
            }

            if (tankUp) {
                y -= 50;
            }

            if (tankDown) {
                y += 50;
            }

            if (tankLeft) {
                x -= 50;
            }

            if (tankRight) {
                x += 50;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT: tankLeft = false; break;
                case KeyEvent.VK_RIGHT: tankRight = false; break;
                case KeyEvent.VK_UP: tankUp = false; break;
                case KeyEvent.VK_DOWN: tankDown = false; break;
                default: break;
            }
        }
    }
}
