package day03;

import javax.swing.*;
import java.awt.*;

public class MoonDemo {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setTitle("月食");
        jf.setSize(1024,768);
        Myjpanel jp=new Myjpanel();
        jf.add(jp);
        jf.setVisible(true);
        jp.st();
    }
}
class Myjpanel extends JPanel{
    int x=810;
    int y=170;

    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);

        //画月亮
        g.setColor(Color.WHITE);
        g.fillOval(860,120,60,60);

        //画黑色的月亮
        g.setColor(Color.BLACK);
        g.fillOval(x,y,60,60);
    }
        public void  st(){
            Thread t=new Thread(){
                public void run() {
                  while (true){
                      x++;
                      y--;
                      if (x>1024&&y<0){
                          x=810;
                          y=170;
                      }
                      try {
                          Thread.sleep(40);
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