package day03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.Random;

public class SeaDemo {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setTitle("海底世界");
        jf.setSize(1024,768);
        SeaJp jp=new SeaJp();
        jf.add(jp);
        jf.setVisible(true);
        jp.st();
    }
}
class SeaJp extends JPanel implements MouseMotionListener{
    int x1=250,y1=200;//第一条鱼的位置
    int x2=500,y2=500;
    int x3=700,y3=100;
    int x4=100,y4=300;



    int yy1[], yy2[];//气泡数组
    public SeaJp(){
        yy1=new int[15];
        yy2=new int[15];
        Random rd=new Random();
        for (int i=0;i<15;i++){
            yy1[i]=rd.nextInt(1500);
            yy2[i]=rd.nextInt(1500);
        }
        this.addMouseMotionListener(this);
    }
    public void paint(Graphics g) {
        super.paint(g);
        //得到图片的资源
        URL img=getClass().getResource("2.jpg");
        //把资源转换成img类型
        ImageIcon icon=new ImageIcon(img);
        g.drawImage(icon.getImage(),0,0,this);
        URL fish1=getClass().getResource("1.png");
        ImageIcon fish1Img=new ImageIcon(fish1);
        g.drawImage(fish1Img.getImage(),x1,y1,this);
        URL fish2=getClass().getResource("3.png");
        ImageIcon fish2Img=new ImageIcon(fish2);
        g.drawImage(fish2Img.getImage(),x2,y2,this);
        URL fish3=getClass().getResource("4.png");
        ImageIcon fish3Img=new ImageIcon(fish3);
        g.drawImage(fish3Img.getImage(),x3,y3,this);
        URL fish4=getClass().getResource("5.png");
        ImageIcon fish4Img=new ImageIcon(fish4);
        g.drawImage(fish4Img.getImage(),x4,y4,this);

        //画气泡
        for (int i=0;i<15;i++){
            g.setColor(Color.WHITE);
            g.drawOval(100,yy1[i],20,20);
            g.drawOval(500,yy2[i],20,20);
        }
    }

    public void st(){
        Thread t=new Thread(){
            public void run() {
                while (true){
                    x1--;
                    if (x1<=-250){
                        x1=1000;
                    }
                    x2--;
                    if (x2<=-200){
                        x2=900;
                    }
                    x3--;
                    if (x3<=-150){
                        x3=900;
                    }
                    x4++;
                    if (x4>=1000){
                        x4=-50;
                    }
                    //气泡动起来
                    for(int i=0;i<15;i++){
                        yy1[i]-=1;
                        yy2[i]-=1;
                        if (yy1[i]<=0){
                            yy1[i]=1000;
                        }
                        if (yy2[i]<=0){
                            yy2[i]=1000;
                        }
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        };
        t.start();

    }

    @Override
    //鼠标拖动事件
    public void mouseDragged(MouseEvent e) {
        x4=e.getX()-100;//e.getX()得到鼠标点击时的横坐标
        y4=e.getY()-100;
        repaint();
    }
    @Override
    public void mouseMoved(MouseEvent m) {
        x1=m.getX()-100;
        y1=m.getY()-100;
    }
}
