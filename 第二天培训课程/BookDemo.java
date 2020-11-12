package day02;

public class BookDemo {
    public static void main(String[] args) {
        Book b1=new Book();
        Book b2=new Book(101,"三国演义");
        System.out.println("b2的名字是"+b2.name);
        Book b3=new Book("西游记");
        b2.read();
        b3.read();
    }
}
