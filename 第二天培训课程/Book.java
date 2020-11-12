package day02;

public class Book {
    int id;//版本号
    String name;//书名
    public void read(){
        System.out.println("你正在读"+this.name);
    }

    //有参的构造函数
    public Book(int id,String name){
        this.id=id;
        this.name=name;
    }

    //只有一个参数的构造函数
    public Book(String name){
        this.name=name;
    }

    //无参的构造函数
    public Book(){
        System.out.println("调用了无参的构造函数");
    }
}
