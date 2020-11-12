package day02;

public class Runa {
    public static void main(String[] args) {
        Runm x=new Runm();
        Runn y=new Runn();
        //把整个对象作为一个线程体
        Thread t=new Thread(x);
        Thread t2=new Thread(y);
        //启动线程
        t.start();
        t2.start();
    }
}
class Runm implements Runnable{
    public void run() {
        //线程要做的事情
        for (int i=1;i<101;i++){
            System.out.println("m"+i);
        }
    }
}


class Runn implements Runnable{
    public void run() {
        for (int i=1;i<101;i++){
            System.out.println("n"+i);
        }
    }
}