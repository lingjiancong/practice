package com.lingjiancong.util;

import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.List;

import javax.imageio.ImageIO;

import jj.play.ns.nl.captcha.Captcha;
import jj.play.ns.nl.captcha.backgrounds.FlatColorBackgroundProducer;
import jj.play.ns.nl.captcha.text.producer.DefaultTextProducer;
import jj.play.ns.nl.captcha.text.renderer.DefaultWordRenderer;

/**
 * 实用类
 *
 * @author lingjiancong
 */
public class UtilSerive {

    /**
     * 生成验证码
     * @param limit 验证码长度
     * @return
     */
    public String generateIdentifyCode(int limit) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < limit; ++i) {
            int rand = random.nextInt(10);
            sb.append(rand);
        }
        return sb.toString();
    }

    @Test
    public void testIdentify() {
        for (int i = 0; i < 10; ++i) {
            String code = generateIdentifyCode(4);
            System.out.println(code);
        }
        Integer i;
    }


    @Test
    public void captcha() throws IOException {
        String s = "1234";
        Color textColor = new Color(0, 144, 255);
        List<Font> textFonts = Arrays.asList(new Font("Arial", Font.BOLD, 40), new Font("Courier", Font.BOLD, 40));
        Color backgroundColor = new Color(41, 46, 65);
        Captcha captcha = new Captcha.Builder(120, 50).addText(new DefaultTextProducer(4),
                new DefaultWordRenderer(textColor, textFonts)).addNoise().addBackground(new FlatColorBackgroundProducer(backgroundColor)).build();
        BufferedImage image = captcha.getImage();
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("captcha.jpg"));
        ImageIO.write(image, "jpeg", outputStream);
        System.out.println(captcha.getAnswer());
    }
}
