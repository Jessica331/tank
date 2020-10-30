package com.wangyp.tank;

import java.awt.*;
import java.util.ConcurrentModificationException;

public class Bullet {

    private static final int SPEED = 10;
    private static final int WIDTH = 30, HEIGHT = 30;

    private int x, y;
    private Dir dir;

    private TankFrame tankFrame = null;

    private boolean live = true;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {

        if (!live) {
            //  ConcurrentModificationException
            tankFrame.bullets.remove(this);
        }

        Color color = g.getColor();
        g.setColor( Color.red );
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);

        move();
    }

    public void move() {

        switch (dir) {
            case LEFT:
                x -=  SPEED;
                break;
            case RIGHT:
                x +=  SPEED;
                break;
            case UP:
                y -=  SPEED;
                break;
            case DOWN:
                y +=  SPEED;
                break;
            default:
                break;
        }

        if (x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) {
            this.live = false;
        }
    }

}
