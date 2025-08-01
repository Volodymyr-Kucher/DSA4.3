package third;

import java.util.ArrayList;
import java.util.List;

public class SeparateChaining<K,V> {

    private List<HashCode<K,V>> buckets;
    private int capacity;
    private int countOfItems;

    public SeparateChaining() {
    }

    public SeparateChaining(int capacity) {
        this.capacity = capacity;
        this.buckets = new ArrayList<>(capacity);
        for(int i = 0; i < capacity; i++){
            buckets.add(null);
        }
    }

    public int size(){
        return countOfItems;
    }

    public boolean isEmpty(){
        return countOfItems == 0;
    }

    public int hash(K key){
        return key.hashCode() % capacity;
    }

    private int getBucketIndex(K key) {
        if (key == null) return 0;
        int hashCode = key.hashCode();
        return (hashCode & 0x7fffffff) % capacity;
    }

    public void delete(K key) {
        int bucketIndex = getBucketIndex(key);
        HashCode<K, V> current = buckets.get(bucketIndex);
        HashCode<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    buckets.set(bucketIndex, current.next);
                } else {
                    previous.next = current.next;
                }
                countOfItems--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashCode<K, V> current = buckets.get(bucketIndex);

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashCode<K, V> head = buckets.get(bucketIndex);

        HashCode<K, V> current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        countOfItems++;
        HashCode<K, V> newNode = new HashCode<>(key,value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);

        return null;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }
}