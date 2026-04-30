import java.util.NoSuchElementException;

public class MyStack<T> {
    private final MyLinkedList<T> list = new MyLinkedList<>();

    public boolean empty(){
        return list.getSize() == 0;
    }

    public int size(){
        return list.getSize();
    }

    public T peek(){
        if (empty()){
            throw new NoSuchElementException();
        }
        return list.getLast();
    }

    public T push(T item){
        list.add(item);
        return item;
    }

    public T pop(){
        if(empty()){
            throw new NoSuchElementException();
        }
        T removed = peek();
        list.removeLast();
        return removed;
    }
}
