package hashmapsandfunctions.customhashmap;

public class CustomHashMap {
    public static void main(String[] args) {
        HashMapClone hashMap = new HashMapClone();


        hashMap.put(1, 10);
        hashMap.put(2, 20);
        hashMap.put(102, 30); // Causes collision with key 2 (102 % 1000 = 2)


        System.out.println("Value for key 1: " + hashMap.get(1)); // 10
        System.out.println("Value for key 2: " + hashMap.get(2)); // 20
        System.out.println("Value for key 102: " + hashMap.get(102)); // 30


        hashMap.remove(2);
        System.out.println("Value for key 2 after removal: " + hashMap.get(2));
    }
}


