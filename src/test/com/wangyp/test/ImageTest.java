package com.wangyp.test;

import com.wangyp.tank.ResourceMgr;
import org.junit.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageTest {

    @Test
    public void test() {

        try {
            BufferedImage tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            System.out.println(tankL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

