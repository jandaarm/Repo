import java.util.NoSuchElementException;

public class MyHashTable<K,V> {
    private class HashNode<K,V> {
        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    public HashNode<K,V>[] chainArray;
    private int M = 1000;
    private int size;

    public MyHashTable(){
        chainArray = new HashNode[M];
    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
    }
    private int hash(K key){return Math.abs(key.hashCode()) % M;}
    public void put (K key, V value){
        int index = hash(key);
        HashNode<K,V> node = chainArray[index];
        if (node == null){
            chainArray[index] = new HashNode<>(key, value);
            size++;
            return;
        }
        while (node.next != null){
            if (node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        if (node.key.equals(key)){
            node.value = value;
            return;
        }
        node.next = new HashNode<>(key, value);
        size++;
    }
    public V get(K key){
        int index = hash(key);
        HashNode<K,V> node = chainArray[index];
        while (node != null){
            if (node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public V remove(K key){
        int index = hash(key);
        HashNode<K,V> node = chainArray[index];
        if (node == null){
            return null;
        }
        if (node.key.equals(key)){
            chainArray[index] = node.next;
            size--;
            return node.value;
        }
        while (node.next != null){
            if (node.next.key.equals(key)){
                V value = node.next.value;
                node.next = node.next.next;
                size--;
                return value;
            }
            node = node.next;
        }

        return null;
    }
    public boolean contains(V value){
        for (int i = 0; i < M; i++){
            HashNode<K,V> node = chainArray[i];
            while (node != null){
                if (node.value.equals(value)){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
    public K getKey(V value){
        for (int i = 0; i < M; i++){
            HashNode<K,V> node = chainArray[i];
            while (node != null){
                if (node.value.equals(value)){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    public static class MyTestingClass {
        int a;
        int b;
        public MyTestingClass(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode(){
            return 31 * a + b;
        }
    }

    public int getBucketSize(int index){
        int bs = 0;
        HashNode<K,V> node = chainArray[index];
        while (node != null){
            bs++;
            node = node.next;
        }
        return bs;
    }
}

