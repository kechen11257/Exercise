import java.util.ArrayList;
import java.util.Iterator;

public class CollectionEx {
    /*
    创建3个Dog{name, age}对象，放入到ArrayList中，赋给list引用
    用迭代器和增强for循环两种方式来遍历
    重写Dog的toString方法，输出name和age
     */
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add(new Dog("dog1", 3));
        list.add(new Dog("dog2", 4));
        list.add(new Dog("dog3", 5));
        //方式1：使用迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog =  iterator.next();
            System.out.println(dog);
        }
        //方式二：使用增强for循环
        for(Object dog: list){
            System.out.println(dog);
        }
    }
}

class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
