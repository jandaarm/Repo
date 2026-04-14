public class MyStack<T> {

    private MyLinkedList<T> list = new MyLinkedList<>();

    public boolean empty() {
        return list.getSize() == 0;
    }

    public int size() {
        return list.getSize();
    }

    public T peek() {
        return list.get(0);
    }

    public T push(T item) {
        list.addFirst(item);
        return item;
    }

    public T pop() {
        T removingItem = peek();
        list.removeFirst();
        return removingItem;
    }
}