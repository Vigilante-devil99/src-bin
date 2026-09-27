import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> regularMap = new HashMap<>();
        Map<Integer, String> identityMap = new IdentityHashMap<>();

        Integer k1 = new Integer(10);
        Integer k2 = new Integer(10);

       
        regularMap.put(k1, "First");
        regularMap.put(k2, "Second");
        System.out.println("HashMap size: " + regularMap.size()); // 1

       
        identityMap.put(k1, "First");
        identityMap.put(k2, "Second");
        System.out.println("IdentityHashMap size: " + identityMap.size()); // 2
    }
}
