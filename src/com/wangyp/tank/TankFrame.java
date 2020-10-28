package com.wangyp.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    int x = 200, y=200;

    public TankFrame() {
        // 设置窗口大小
        setSize(800, 600);
        // 是否可以改变大小
        setResizable(false);
        // 填写标题
        setTitle("Tank War");
        // 可见
        setVisible(true);

        // 键盘的监听
        this.addKeyListener(new MyKeyListener());

        // 监听器
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 系统退出
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        //x += 10;
        //y += 10;

    }

    class MyKeyListener extends KeyAdapter {

        boolean tankLeft = false;
        boolean tankRight = false;
        boolean tankUp = false;
        boolean tankDown = false;

        // 键被按下去 被调用
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_UP: tankUp = true; break;
                case KeyEvent.VK_DOWN: tankDown =true; break;
                case KeyEvent.VK_LEFT: tankLeft = true; break;
                case KeyEvent.VK_RIGHT: tankRight = true; break;
                default: break;
            }
            move();
        }

        // 键抬起来 被调用
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_UP: tankUp = false; break;
                case KeyEvent.VK_DOWN: tankDown =false; break;
                case KeyEvent.VK_LEFT: tankLeft = false; break;
                case KeyEvent.VK_RIGHT: tankRight = false; break;
                default: break;
            }
        }

        public void move() {
            if (tankLeft) {
                x -= 50;
            }
            if (tankRight) {
                x += 50;
            }
            if (tankUp) {
                y -= 50;
            }
            if (tankDown) {
                y += 50;
            }
        }
    }

}
