package third;

public class HashCode<K,V> {
    public K key;
    public V value;
    public int hashCode;
    public HashCode<K,V> next;

    public HashCode(K key, V value) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
        this.next = null;
    }
}