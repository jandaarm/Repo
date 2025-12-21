import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //Creating 1 empty and 2 filled objects
        Human human = new Human();
        Student student = new Student(18, "Daulet", true, "Smart Technology", 3.4f);
        Employee employee = new Employee(25, "Bob", true, "Builder", 13.7f);

        //filling attributes of human with scanner (setters used)
        Scanner sc = new Scanner(System.in);
        System.out.print("Age: ");
        human.setAge(sc.nextInt());
        System.out.print("Name: ");
        human.setName(sc.nextLine());
        human.setName(sc.nextLine());
        System.out.print("Alive: ");
        human.setAlive(sc.nextBoolean());

        //using method getInfo (getters used)
        System.out.println("\nHuman info: \n" + human.getInfo() + "\n");
        System.out.println("Student info: \n" + student.getInfo() + "\n");
        System.out.println("Employee info: \n" + employee.getInfo() + "\n");

        //using method Sing
        human.Sing();
    }

}