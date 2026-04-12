import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{

    private class MyNode<T>{
        T element;
        MyNode<T> next;
        MyNode<T> previous;

        MyNode(T element){
            this.element = element;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= length) return;
        MyNode<T> node = getNode(index);
        if (node != null) node.element = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) return;

        if (index == 0) {
            addFirst(item);
            return;
        }

        if (index == length) {
            addLast(item);
            return;
        }

        MyNode<T> nextNode = getNode(index);
        if (nextNode == null) return;

        MyNode<T> prevNode = nextNode.previous;
        MyNode<T> newNode = new MyNode<>(item);

        prevNode.next = newNode;
        newNode.previous = prevNode;

        newNode.next = nextNode;
        nextNode.previous = newNode;

        length++;
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        length++;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        length++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) return null;
        MyNode<T> node = getNode(index);
        return node == null ? null : node.element;
    }

    @Override
    public T getFirst() {
        return head == null ? null : head.element;
    }

    @Override
    public T getLast() {
        return tail == null ? null : tail.element;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= length) return;

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == length - 1) {
            removeLast();
            return;
        }

        MyNode<T> node = getNode(index);
        if (node == null) return;

        node.previous.next = node.next;
        node.next.previous = node.previous;

        length--;
    }

    @Override
    public void removeFirst() {
        if (head == null) return;

        head = head.next;

        if (head != null) {
            head.previous = null;
        } else {
            tail = null;
        }

        length--;
    }

    @Override
    public void removeLast() {
        if (tail == null) return;

        tail = tail.previous;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }

        length--;
    }

    @Override
    public void sort() {
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        int index = 0;

        while (current != null) {
            if ((object == null && current.element == null) ||
                    (object != null && object.equals(current.element))) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        int index = length - 1;

        while (current != null) {
            if ((object == null && current.element == null) ||
                    (object != null && object.equals(current.element))) {
                return index;
            }
            current = current.previous;
            index--;
        }

        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        MyNode<T> current = head;
        int i = 0;

        while (current != null) {
            array[i++] = current.element;
            current = current.next;
        }

        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public int getSize() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor < getSize();
        }

        @Override
        public T next() {
            T nextItem = get(cursor);
            cursor++;
            return nextItem;
        }
    }

    private MyNode<T> getNode(int index) {
        if (index < 0 || index >= length) return null;

        MyNode<T> current;

        if (index < length / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = length - 1; i > index; i--) current = current.previous;
        }

        return current;
    }
}