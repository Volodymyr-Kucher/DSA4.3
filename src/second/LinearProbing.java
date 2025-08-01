package second;

import java.util.LinkedList;
import java.util.Queue;


public class LinearProbing<K, V> {

    private static final int INIT_CAPACITY = 16;

    private final double loadFactor;

       private int threshold;

    private int countOfItems;

    private int capacity;

    private K[] keys;

    private V[] values;

    public LinearProbing() {
        this(INIT_CAPACITY);
    }

    public LinearProbing(int capacity) {
        this.capacity = capacity;
        this.loadFactor = 0.5; // За умовою
        this.threshold = (int) (capacity * loadFactor);
        this.countOfItems = 0;

        keys = (K[]) new Object[capacity];
        values = (V[]) new Object[capacity];
    }

    public int size() {
        return countOfItems;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(K key) {
        if (key == null) throw new IllegalArgumentException("Ключ не може бути null");
        return get(key) != null;
    }

    public int hash(K key) {

        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Ключ не може бути null");
        if (value == null) {
            delete(key);
            return;
        }

        if (countOfItems >= threshold) {
            resize(2 * capacity);
        }

        int i;
        // Лінійне зондування:
        for (i = hash(key); keys[i] != null; i = (i + 1) % capacity) {

            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        countOfItems++;
    }

    public int getBucketIndex(K key) {
        if (key == null) throw new IllegalArgumentException("Ключ не може бути null");

        for (int i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (keys[i].equals(key)) {
                return i; // Ключ знайдено
            }
        }
        return -1; // Ключ не знайдено
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    public void delete(K key) {
        if (!contains(key)) return;

        int i = getBucketIndex(key);

        keys[i] = null;
        values[i] = null;
        countOfItems--;

        i = (i + 1) % capacity;
        while (keys[i] != null) {
            K keyToRehash = keys[i];
            V valToRehash = values[i];

            keys[i] = null;
            values[i] = null;
            countOfItems--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % capacity;
        }

        if (countOfItems > 0 && countOfItems <= capacity / 8) {
            resize(capacity / 2);
        }
    }

    public Iterable<K> keys() {
        Queue<K> queue = new LinkedList<>();
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                queue.add(keys[i]);
            }
        }
        return queue;
    }

    private void resize(int newCapacity) {
        System.out.println("LOG: Resizing table to " + newCapacity);
        LinearProbing<K, V> temp = new LinearProbing<>(newCapacity);

        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }

        this.keys = temp.keys;
        this.values = temp.values;
        this.capacity = temp.capacity;
        this.threshold = temp.threshold;
    }
}