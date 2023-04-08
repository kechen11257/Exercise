import java.util.Arrays;
import java.util.Comparator;

public class ArraysEx {
    /*
    自定义book类，里面包含name和price，
    1. 按price排序，从小到大排序
    2. 按price排序，从大到小排序
    3. 按照书名长度从大到小排序
    有一个 Book[] books = new Book[4]
    books[0] = new Book["红楼梦", 100];
    books[1] = new Book["金瓶梅新", 90];
    books[2] = new Book["青年文摘20年", 5];
    books[3] = new Book["java从入门到放弃", 300];

    使用学习过的传递，实现Comparator接口匿名内部类，也称为定制排序
     */
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘20年", 5);
        books[3] = new Book("java从入门到放弃", 300);

        //按照价格从大到小 & 从小到大
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double res = o2.getPrice() - o1.getPrice();
                if(res > 0){
                    // return 1； 从小到大
                    return -1;
                }else if(res < 0){
                    // return -1；从小到大
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        System.out.println(Arrays.toString(books));

        //按照书名长度从大到小
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getName().length() - o1.getName().length();
            }
        });

        System.out.println(Arrays.toString(books));
    }
}

class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
