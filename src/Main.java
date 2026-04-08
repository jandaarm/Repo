public class Main{
    public static void main(String[] args){
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);

        for (int i : list) {
            System.out.println(i);
        }
    }
}
