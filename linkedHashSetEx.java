import java.util.LinkedHashSet;

public class linkedHashSetEx {
    /*
    Car类（属性：name，price），如果name和price一样，则认为是相同元素，就不能添加
     */
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("aotuo", 10000));
        linkedHashSet.add(new Car("aodi", 20000));
        linkedHashSet.add(new Car("falali", 30000));
        linkedHashSet.add(new Car("aodi", 20000));
        linkedHashSet.add(new Car("baoshijie", 40000));
        linkedHashSet.add(new Car("aodi", 20000));

        System.out.println(linkedHashSet);

    }
}

class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (Double.compare(car.price, price) != 0) return false;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
