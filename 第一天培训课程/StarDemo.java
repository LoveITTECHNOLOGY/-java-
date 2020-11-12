package day01;

import javax.swing.*;
import java.awt.*;

public class StarDemo {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setSize(1024,768);
        jf.setTitle("满天星");
        StarJp jp=new StarJp();
        jf.add(jp);
        jf.setVisible(true);
    }
}
class StarJp extends JPanel{
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        for(int i=0;i<300;i++){
            //随机生成一个颜色
            g.setColor(new Color((int)(Math.random()*0xffffff)));
            //(int)(Math.random()*0xffffff)==16进制的整数
            //画字符的方法 参数为字符、字符出现的横坐标、字符出现的纵坐标
            g.drawString("*",
                    (int)(Math.random()*1024),
                    (int)(Math.random()*768)
            );
        }
        g.setColor(Color.WHITE);
        //画圆  (横坐标，纵坐标，圆的半径，圆的半径)
        g.fillOval(800,120,80,80);
        g.setColor(Color.BLACK);
        g.fillOval(780,100,80,80);
    }
}