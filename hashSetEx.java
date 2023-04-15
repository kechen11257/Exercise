import java.util.HashSet;

public class hashSetEx {
    public static void main(String[] args) {
        /*
        定义一个Employee类，该类包含：private成员属性name，age
        1。 创建3个Employee放入hashset中
        2。 当name和age的值相同时，认为是相同员工，不能添加到hashset集合中
         */
        HashSet hashset = new HashSet();
        hashset.add(new Employee("小王",56));
        hashset.add(new Employee("小红",58));
        hashset.add(new Employee("小王",56));

        System.out.println(hashset);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
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
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
