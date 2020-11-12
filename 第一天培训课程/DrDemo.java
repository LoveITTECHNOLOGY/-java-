package day01;

import javax.swing.*;
import java.awt.*;

public class DrDemo {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        //实例化一个JFrame(窗口类)
        jf.setSize(1024,768);
        //通过  对象.方法()   调用对象的方法
        //设置窗口的大小
        jf.setTitle("画一个图形");
        //设置窗口的标题
        jf.setVisible(true);
        MyJpanel jp=new MyJpanel();
        jf.add(jp);
    }
}

class MyJpanel extends JPanel{
    public void paint(Graphics g) {
        //写一个JPanel自带的画的方法，传了一个画笔的参数
        super.paint(g);
        this.setBackground(Color.BLACK);
        //设置当前画板的背景颜色为黑色
        //this关键字指的是“我”,谁用就是谁
        //设置画笔的颜色为白色
        g.setColor(Color.WHITE);
        //画长方形
        g.drawRect(200,100,80,80);
        //画一个实心的四边形
        g.fillRect(200,200,100,100);
        //画三角形(x坐标集，y坐标集，点数)
        int[] x=new int[]{10,55,90};
        int[] y=new int[]{32,91,26};
        g.drawPolygon(x,y,3);
        //画一条直线
        //g.drawLine() 参数是两个点的横纵坐标
        g.setColor(Color.RED);
        g.drawLine(100,200,200,400);
    }
}
