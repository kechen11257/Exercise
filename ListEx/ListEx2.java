package ListEx;

import java.util.ArrayList;
import java.util.List;

public class ListEx2 {
    public static void main(String[] args) {
        /*
        使用List的实现类添加三本图书，并遍历，打印如下效果：
        名称：xx    价格：xx    作者：xx
        名称：xx    价格：xx    作者：xx
        名称：xx    价格：xx    作者：xx
        要求：
        1。按价格排序，从低到高（使用冒泡法）
        2。要求使用ArrayList, LinedList和vector三种集合实现
         */
        List list = new ArrayList();
        list.add(new Book("红楼梦","曹雪芹",1.0));
        list.add(new Book("红楼梦","曹雪芹",2.0));
        list.add(new Book("红楼梦","曹雪芹",3.0));
        list.add(new Book("红楼梦","曹雪芹",4.0));
        list.add(new Book("红楼梦","曹雪芹",5.0));

        for(Object o : list){
            System.out.println(o);
        }
    }


    public static void sort(List list){
        for(int i = 0; i < list.size()-1; i++){
            for(int j = 0; j < list.size() - 1 - i; j++){
                //取出对象 Book
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {//交换
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
    }

}

class Book{
    private String name;
    private  String author;
    private  double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name:" + name  +
                "author:" + author +
                "price:" + price;
    }
}