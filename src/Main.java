public class Main{
    public static void main(String[] args){
        BST<Integer, String> tree = new BST<>();
        tree.put(20, "Karagandy");
        tree.put(13, "Almaty");
        tree.put(15, "Kokshetau");
        tree.put(24, "Astana");

        System.out.println("Size: " + tree.size());
        System.out.println(tree.get(13));
        System.out.println("Delete 13");
        tree.delete(13);
        for (var element : tree) {

            System.out.println("key is " + element.getKey() + " and value is " + element.getValue());

        }
    }
}