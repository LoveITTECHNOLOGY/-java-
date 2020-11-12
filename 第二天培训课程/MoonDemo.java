package day02;

import javax.swing.*;
import java.awt.*;

public class MoonDemo {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setTitle("月食");
        jf.setSize(1024,768);
        Myjp jp=new Myjp();
        jf.add(jp);
        jf.setVisible(true);
        Thread t=new Thread(jp);
        t.start();
    }
}
class Myjp extends JPanel implements Runnable{
    int x=810;//黑色的月亮
    int y=170;

    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        //画月亮
        g.fillOval(860,120,60,60);

        //会动的黑色的圆
        g.setColor(Color.BLACK);
        g.fillOval(x,y,60,60);

    }

    public void run() {
        while (true){
            x++;
            y--;
            if (x>1024&&y<0){
                x=810;
                y=170;
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //更新画板
            repaint();
        }

    }
}