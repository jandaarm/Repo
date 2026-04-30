import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{

    int size;
    MyNode<T> head;
    MyNode<T> tail;
    public static class MyNode<E> {
        E data;
        MyNode<E> next;
        MyNode<E> previous;
        MyNode(E data){
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void add(T newItem) {
        MyNode<T> newNode = new MyNode<T>(newItem);
        if (head == null){
            head = tail = newNode;
        } else{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        if(index<0 || index >= size){
            return;
        }
        MyNode<T> node = getNode(index);
        if(node != null){
            node.data = item;
        }
    }

    @Override
    public void add(int index, T item) {
        if (index<0 || index>size){
            return;
        }
        MyNode<T> current = head;
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null){
            head = tail = newNode;
        } else if (index == 0){
            current.previous = newNode;
            newNode.next = current;
            head = newNode;
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            if (index == size){
                newNode.previous = tail;
                tail.next = newNode;
                tail = newNode;
            } else {
                newNode.next = current.next;
                current.next.previous = newNode;
                current.next = newNode;
                newNode.previous = current;
            }
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        add (0, item);
    }

    @Override
    public void addLast(T item) {
        add  (size, item);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index>=size){
            return null;
        }
        MyNode<T> node = getNode(index);
        return node == null ? null : node.data;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size-1);
    }

    @Override
    public void remove(int index) {
        if (index<0 || index>=size){
            return;
        }
        MyNode<T> current = head;
        if (index == 0){
            head = current.next;
            if (head != null) {
                head.previous = null;
            } else {
                tail = null;
            }
        } else if (index == size-1){
            current = tail;
            tail = current.previous;
            if (tail != null){
                tail.next = null;
            } else {
                head = null;
            }

        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size-1);
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        MyNode<T> current = head;
        while(current != null){
            if (current.data.equals(object)){
               return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        MyNode<T> current = head;
        Object[] array = new Object[size];
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private MyNode<T> getNode(int index) {
        if (index < 0 || index >= size) return null;

        MyNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.previous;
        }

        return current;
    }
}
