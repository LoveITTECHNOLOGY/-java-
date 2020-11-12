package day02;

public class ThreadDemo {
    public static void main(String[] args) {
        Threada a=new Threada();
        Threadb b=new Threadb();
        a.start();
        b.start();
    }
}
//extends
class Threada extends Thread{
    //run
    public void run() {
       for (int i=1;i<101;i++){
           System.out.println("a"+i);
       }
    }
}
class Threadb extends Thread{
    public void run() {
        for (int i=1;i<101;i++){
            System.out.println("b"+i);
        }
    }
}