import java.util.Iterator;
import java.util.NoSuchElementException;

public class BST<K extends Comparable<K>,V> implements Iterable<BST.Entry<K,V>>{
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

    public int size() {return size;}

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
    public void delete(K key){
        BSTNode<K,V> current = root;
        BSTNode<K,V> parent = null;
        while(current != null){
            int cmp = key.compareTo(current.key);
            if (cmp < 0){
                parent = current;
                current = current.left;
            } else if (cmp > 0){
                parent = current;
                current = current.right;
            } else {
                if (current.right != null && current.left != null){
                    BSTNode<K,V> p = current;
                    BSTNode<K,V> successor = current.right;
                    while(successor.left != null){
                        p = successor;
                        successor = successor.left;
                    }
                    current.key = successor.key;
                    current.value = successor.value;
                    if (p.left == successor) {
                        p.left = successor.right;
                    } else {
                        p.right = successor.right;
                    }
                    size--;
                    break;
                } else{
                    BSTNode<K,V> child = (current.left != null) ? current.left : current.right;
                    if (parent == null){
                        root = child;
                    } else if(parent.left == current){
                        parent.left = child;
                    } else {
                        parent.right = child;
                    }
                    size--;
                    break;
                }
            }
        }
    }

    public Iterator<Entry<K,V>> iterator(){return new MyIterator();}

    private class MyIterator implements Iterator<Entry<K,V>> {
        MyStack<BSTNode<K,V>> trace = new MyStack<>();

        MyIterator(){
            BSTNode<K,V> current = root;
            while(current != null){
                trace.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !trace.empty();
        }

        @Override
        public Entry<K,V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            BSTNode<K,V> nextItem = trace.pop();
            BSTNode<K,V> current = nextItem;
            if (current.right != null){
                current = current.right;
                while(current != null){
                    trace.push(current);
                    current = current.left;
                }
            }
            return new Entry<>(nextItem.key, nextItem.value);
        }
    }

    public static class Entry<K,V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
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