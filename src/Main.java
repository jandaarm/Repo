public class Main{
    public static void main(String[] args){
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Apple");
        list.add("Pen");

        for (String i : list) {
            System.out.println(i);
        }
    }
}
