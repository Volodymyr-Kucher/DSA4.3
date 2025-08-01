package third;

public class Main {
    public static void main(String[] args) {

        SeparateChaining<String,Integer> hashTable = new SeparateChaining(10);

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);
        // Отримання значень
        System.out.println("Value for 'two': " + hashTable.get("two")); // 2
        System.out.println("Current size: " + hashTable.size()); // 3
        // Чи існує ключ
        System.out.println("Contains 'three': " + hashTable.contains("three")); // true
        // Видалення ключа
        hashTable.delete("two");
        System.out.println("Contains 'two' after deletion: " + hashTable.contains("two")); // false
        System.out.println("Current size after deletion: " + hashTable.size()); // 2
    }
}