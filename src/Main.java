public class Main{
    public static void main(String[] args){
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Apple");
        list.add("Pen");

        for (String i : list) {
            System.out.println(i);
        }

        list.addFirst("Start");
        list.addLast("End");

        System.out.println("\nAfter addFirst and addLast:");
        for (String i : list) {
            System.out.println(i);
        }

        list.add(2, "Middle");

        System.out.println("\nAfter add at index 2:");
        for (String i : list) {
            System.out.println(i);
        }

        list.set(1, "Changed");

        System.out.println("\nAfter set index 1:");
        for (String i : list) {
            System.out.println(i);
        }

        System.out.println("\nGet index 2: " + list.get(2));
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        list.remove(2);

        System.out.println("\nAfter remove index 2:");
        for (String i : list) {
            System.out.println(i);
        }

        list.removeFirst();
        list.removeLast();

        System.out.println("\nAfter removeFirst and removeLast:");
        for (String i : list) {
            System.out.println(i);
        }

        System.out.println("\nIndex of 'Pen': " + list.indexOf("Pen"));
        System.out.println("Exists 'Book': " + list.exists("Book"));

        list.add("Zebra");
        list.add("Alpha");
        list.sort();

        System.out.println("\nAfter sort:");
        for (String i : list) {
            System.out.println(i);
        }

        Object[] array = list.toArray();

        System.out.println("\nArray:");
        for (Object o : array) {
            System.out.println(o);
        }

        System.out.println("\nSize: " + list.getSize());

        list.clear();

        System.out.println("\nAfter clear, size: " + list.getSize());
    }
}