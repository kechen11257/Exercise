package Generic;

import java.util.ArrayList;
import java.util.Comparator;

public class genericEx {
    /*
    定义 Employee 类
    1) 该类包含：private 成员变量 name,sal,birthday，其中 birthday 为 Generic.MyDate 类的对象；
    2) 为每一个属性定义 getter, setter 方法；
    3) 重写 toString 方法输出 name, sal, birthday
    4) Generic.MyDate 类包含: private 成员变量 month,day,year；并为每一个属性定义 getter, setter 方法；
    5) 创建该类的 3 个对象，并把这些对象放入 ArrayList 集合中（ArrayList 需使用泛型来定义），
    对集合中的元素进 行排序，并遍历输出：
    排序方式： 调用 ArrayList 的 sort 方法 , 传入 Comparator 对象[使用泛型]，
    先按照 name 排序，如果 name 相同，则按生日日期的先后排序。【即：定制排序】
     */

    public static void main(String[] args) {

        ArrayList<Employee03> employees = new ArrayList<>();
        employees.add(new Employee03("chen", 70, new MyDate(2,7,2021)));
        employees.add(new Employee03("huang", 60, new MyDate(2,5,2020)));
        employees.add(new Employee03("chen", 50, new MyDate(2,6,1980)));

        System.out.println(employees);

        employees.sort(new Comparator<Employee03>() {
            @Override
            public int compare(Employee03 o1, Employee03 o2) {
                //先按照 name 排序，如果 name 相同，则按生日日期的先后排序。【即：定制排序】
                int i = o1.getName().compareTo(o2.getName());
                if(i != 0){
                    return i;
                }
                //下面是对 birthday 的比较，因此，我们最好把这个比较，放在 Generic.MyDate 类完成
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
    }
}

class Employee03{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee03(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Generic.MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    // 把对年月日的比较放在这里比较
    @Override
    public int compareTo(MyDate o) {
        int yearMinus = year - o.getYear();
        if(yearMinus != 0){
            return yearMinus;
        }

        int monthMinus = month - o.getMonth();
        if(monthMinus != 0){
            return monthMinus;
        }
        return day - o.getDay();
    }

}
