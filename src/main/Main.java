package main;

import humanity.Human;
import humanity.Student;
import humanity.Employee;
import interfaces.INeeds;
import interfaces.IWork;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //Creating 1 empty and 2 filled objects
        //Human human = new Human();

        //Creation of objects
        Student student1 = new Student(18, "Daulet", true, "Smart Technology", 3.4f);
        Employee employee1 = new Employee(25, "Bob", true, "Builder", 13.7f, true);

        Human student2 = new Student();
        Human employee2 = new Employee();

        INeeds student3 = student1;
        INeeds employee3 = employee1;

        IWork employee4 = employee1;


        //filling attributes of human with scanner (setters used)
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Age: ");
        human.setAge(sc.nextInt());
        System.out.print("Name: ");
        human.setName(sc.nextLine());
        human.setName(sc.nextLine());
        System.out.print("Alive: ");
        human.setAlive(sc.nextBoolean());*/

        //using method getInfo (getters used)
        //System.out.println("\nHuman info: \n" + human.getInfo() + "\n");
        System.out.println("Student info: \n" + student1.getInfo() + "\n");
        System.out.println("Employee info: \n" + employee1.getInfo() + "\n");

        //using method Sing
        //human.sing();

        //using methods
        employee1.toWork();
        employee1.getPaid();
        employee1.toDrink();
        employee1.toEat();
        student1.toDrink();
        student1.toEat();
        employee2.toBreathe();
        student2.toBreathe();
    }

}