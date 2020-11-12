package day02;

public class SleepDemo {
    public static void main(String[] args) {
        Tha a=new Tha();
        Thread t=new Thread(a);
        t.start();
    }
}
class Tha implements Runnable{
    public void run() {
       for (int i=1;i<101;i++){
           //每执行一次，休息两秒
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }//捕获异常
           System.out.println("牛逼！");
       }
    }
}