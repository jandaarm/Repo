import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{

    private Object[] instance;
    public int size;
    private int capacity = 5;

    public MyArrayList(){
        instance = new Object[capacity];
    }


    @Override
    public void add(Object item) {
        if (size==capacity){
            increaseBuffer();
        }
        instance[size++] = item;
    }

    private void increaseBuffer(){
        capacity = (int)(2*capacity);
        Object[]instance2 = new Object[capacity];
        for (int i = 0; i < size; i++){
            instance2[i] = instance[i];
        }
        instance = instance2;
    }

    @Override
    public void set(int index, Object item) {

    }

    @Override
    public void add(int index, Object item) {

    }

    @Override
    public void addFirst(Object item) {

    }

    @Override
    public void addLast(Object item) {

    }

    @Override
    public T get(int index) {
        return (T) instance[index];
    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

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
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        int cursor;


        @Override
        public boolean hasNext() {
            return cursor != getSize();
        }

        @Override
        public T next() {
            T nextItem = get(cursor);
            cursor++;
            return nextItem;
        }
    }
}
