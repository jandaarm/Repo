import java.util.Iterator;

public class BST<K extends Comparable<K>,V>{
    private BSTNode<K,V> root;
    private int size = 0;
    private static class BSTNode<K,V> {
        K key;
        V value;
        BSTNode<K,V> left;
        BSTNode<K,V> right;
        BSTNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public void put(K key, V value){
        BSTNode<K,V> newNode = new BSTNode<>(key, value);
        BSTNode<K,V> current = root;
        if (root == null){
            root = newNode;
            size++;
            return;
        }
        while(true){
            int cmp = key.compareTo(current.key);
            if (cmp < 0){
                if (current.left == null){
                    current.left = newNode;
                    size++;
                    break;
                } else{
                    current = current.left;
                }
            } else if(cmp > 0){
                if (current.right == null){
                    current.right = newNode;
                    size++;
                    break;
                } else{
                    current = current.right;
                }
            } else {
                current.value = value;
                break;
            }
        }
    }
    public V get(K key){
        BSTNode<K,V> current = root;
        while(current != null){
            int cmp = key.compareTo(current.key);
            if (cmp < 0){
                current = current.left;
            } else if (cmp > 0){
                current = current.right;
            } else {return current.value;}
        }
        return null;
    }

    public Iterable<K> iterator(){
    }

    private class MyIterator implements Iterator<K> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public K next() {
            return null;
        }
    }

    public void inOrder(){
        // need to: find start, remember trace back, implement traversal
        MyStack<BSTNode<K,V>> trace = new MyStack<>();
        BSTNode<K,V> current;
        current = root;
        if (current == null){
            return;
        }

        while(current.left != null){
            trace.push(current);
            current = current.left;
        }
        trace.push(current);

        while (!trace.empty()){
            current = trace.pop();
            System.out.println(current.key);
            if (current.right != null){
                current=current.right;
                while(current.left != null){
                    //restack next trace above old trace
                    trace.push(current);
                    current = current.left;
                }
                trace.push(current);
            }
        }
    }
}