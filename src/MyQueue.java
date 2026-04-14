public class MyQueue<T> {

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

    public T enqueue(T item) {
        list.addLast(item);
        return item;
    }

    public T dequeue() {
        T removingItem = peek();
        list.removeFirst();
        return removingItem;
    }
}