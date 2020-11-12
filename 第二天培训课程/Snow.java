package day02;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Snow {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setSize(1024,768);
        jf.setTitle("雪花一片片飘落");
        MySnow jp=new MySnow();
        jf.add(jp);
        jf.setVisible(true);
        jp.st();
    }
}
class MySnow extends JPanel{
    Font[] allFonts;//字体
    int[] xx;
    int[] yy;//雪花的坐标
    //构造函数,
    public MySnow(){
        allFonts=new Font[4];
        allFonts[0]=new Font("宋体", Font.BOLD,14);
        allFonts[1]=new Font("宋体", Font.BOLD,18);
        allFonts[2]=new Font("宋体", Font.BOLD,20);
        allFonts[3]=new Font("宋体", Font.BOLD,26);
        xx=new int[300];
        yy=new int[300];
        Random rd=new Random();
        for (int i=0;i<300;i++){
            //rd.nextInt(1024)得到1-1024之间的随机整数
            xx[i]=rd.nextInt(1024);
            yy[i]=rd.nextInt(768);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        for (int i=0;i<300;i++){
            g.setFont(allFonts[(int)(Math.random()*4)]);
            g.drawString("*",xx[i],yy[i]);
        }
    }
    //线程
    public void st(){
        Thread t=new Thread(){
            public void run() {
                while (true){
                    for (int i=0;i<300;i++){
                        yy[i]++;
                        if (yy[i]>768){
                            yy[i]=0;
                        }
                    }
                    //执行完for循环实现睡眠效果
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //捕获异常后重置画板
                    repaint();
                }
            }
        };
        t.start();
    }
}