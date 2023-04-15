package Generic;

import org.testng.annotations.Test;

import java.util.*;

public class genericEx2 {
    /*
    定义个泛型类DAO<T>,在其中定义一个map成员变量，map的键为String类型，值为T类型

    分别创建一下方法：
    public void save(String id, T entity): 保存T类型的对象到Map变量成员中
    public T get(String id): 从map中获取id对应的对象
    public void update(String id, T entity): 替换map中key为id的内容，改为entity对象
    public List<T> list():返回map中存放的所有T对象
    public void delete(String id):删除指定id对象

    定义一个User类：
    该类包含：private成员变量（int类型），id，age，（String类型） name

    创建DAO类的对象，分别调用其save，get，update，list，delete方法来操作User对象，
    使用Junit单元测试类进行测试
     */
    public static void main(String[] args) {

    }

    @Test
    public void testList(){
        DAO<User> dao = new DAO<>();
        dao.save("001", new User(1,10,"jack"));
        dao.save("002", new User(2,20,"tom"));
        dao.save("003", new User(3,30,"henry"));

        List<User> list = dao.list();

        dao.update("003,", new User(3,35,"henry"));

        dao.get("003");

        dao.delete("001");

    }
}

/*
    定义一个User类：该类包含：private成员变量（int类型），id，age，（String类型） name
 */
class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

/*
    定义个泛型类DAO<T>,在其中定义一个map成员变量，map的键为String类型，值为T类型

    分别创建以下方法：
    public void save(String id, T entity): 保存T类型的对象到Map变量成员中
    public T get(String id): 从map中获取id对应的对象
    public void update(String id, T entity): 替换map中key为id的内容，改为entity对象
    public List<T> list():返回map中存放的所有T对象
    public void delete(String id):删除指定id对象
 */
class DAO<T>{
    private Map<String,T> map = new HashMap<>();

    @Test
    public void save(String id, T entity){
        map.put(id,entity);
    }

    @Test
    public T get(String id){
        return map.get(id);
    }

    @Test
    public void update(String id, T entity){
        map.put(id, entity);
    }

    @Test
    public List<T> list(){
        ArrayList<T> list = new ArrayList<>();
        Set<String> keyset = map.keySet();
        for(String key : keyset){
            list.add(get(key));
        }
        return list;
    }

    @Test
    public void delete(String id){
        map.remove(id);
    }

}
