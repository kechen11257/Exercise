import java.util.HashMap;

public class hashMapEx {
    public static void main(String[] args) {
        HashMap hashmap = new HashMap();
        hashmap.put("java", 10);
        hashmap.put("php", 10);
        hashmap.put("java", 20);

        System.out.println(hashmap);

    }
}
