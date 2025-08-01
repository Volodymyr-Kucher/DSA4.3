package second;

public class Main {
    public static void main(String[] args) {
        LinearProbing<String, Integer> table = new LinearProbing<>(25);
        // Adding key-value pairs
        table.put("one", 1);
        table.put("two", 2);
        table.put("three", 3);


        System.out.println("Value for key 'two': " + table.get("two"));
        System.out.println("Size: " + table.size());

        System.out.println("Contains 'three': " + table.contains("three"));
        table.delete("two");
        System.out.println("After deleting 'two', size: " + table.size());
        System.out.println("Contains 'two': " + table.contains("two"));
        for (String key : table.keys()) {
            System.out.println("Key: " + key + ", Value: " + table.get(key));
        }
    }
}