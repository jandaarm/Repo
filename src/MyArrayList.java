import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{

    private Object[] instance;
    public int size;
    private int capacity = 5;

    public MyArrayList(){
        instance = new Object[capacity];
    }


    @Override
    public void add(T item) {
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
    public void set(int index, T item) {
        instance[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (size == capacity){
            increaseBuffer();
        }
        for (int i = size; i > index; i--){

            instance[i] = instance[i-1];
        }
        set(index, item);
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        if (size == capacity){
            increaseBuffer();
        }
        instance[size++] = item;
    }

    @Override
    public T get(int index) {
        return (T) instance[index];
    }

    @Override
    public T getFirst() {
        return (T) instance[0];
    }

    @Override
    public T getLast() {
        return (T) instance[size-1];
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < size - 1; i++){
            instance[i] = instance[i+1];
        }
        instance[--size]=null;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        instance[--size] = null;
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++){

            if (instance[i] == null ? object == null : instance[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size-1; i >= 0 ; i--){
            if (instance[i] == null ? object == null : instance[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        int t = indexOf(object);
        if (t == -1){
            return false;
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++){
            array[i] = instance[i];
        }
        return array;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            instance[i] = null;
        }
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
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
