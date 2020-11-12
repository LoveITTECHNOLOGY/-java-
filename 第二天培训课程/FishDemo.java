package day02;

import javax.swing.*;
import java.awt.*;

public class FishDemo {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setTitle("美丽的小金鱼儿");
        jf.setSize(1024,768);
        MyJpanel jp=new MyJpanel();
        jf.add(jp);
        jf.setVisible(true);
        jp.st();
    }
}
class MyJpanel extends JPanel{
    int[] x=new int[10];
    int[] y=new int[10];
    public MyJpanel(){
        for (int i=0;i<10;i++){
            x[i]=(int)(Math.random()*1024);
            y[i]=(int)(Math.random()*768);
        }
    }
    //画小鱼儿
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.CYAN);
        for (int i=0;i<10;i++){
            //画嘴巴
            g.setColor(Color.RED);
            g.fillOval(x[i],y[i],5,8);
            //画身体
            g.setColor(Color.ORANGE);
            g.fillOval(x[i]-48,y[i]-13,50,30);
            //画眼睛
            g.setColor(Color.BLACK);
            g.fillOval(x[i]-13,y[i]-8,5,10);
            //画尾巴
            g.setColor(Color.BLACK);
            g.fillOval(x[i]-63,y[i]-3,20,15);
            g.setColor(Color.CYAN);
            g.fillOval(x[i]-73,y[i]-3,20,15);
        }
    }

    //线程
    public void st(){
        Thread t=new Thread(){
            public void run(){
                //线程要做的事
                while (true){
                    for (int i=0;i<10;i++){
                        x[i]++;
                        if (x[i]>1024){
                            x[i]=0;
                        }
                    }
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        };
        t.start();
    }

}