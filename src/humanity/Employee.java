package humanity;

import interfaces.INeeds;
import interfaces.IWork;

public class Employee extends Human implements INeeds, IWork{
    //unique attributes for employee
    private String position;
    private float salary;
    private boolean isWorked = false;

    //all attributes constructor
    public Employee(int age, String name, boolean isAlive, String position, float salary, boolean isWorked){
        super(age, name, isAlive);
        this.position=position;
        this.salary=salary;
    }

    //empty constructor
    public Employee(){}

    //setters for unique attributes
    public void setPosition(String position){this.position=position;}
    public void setSalary(float salary){this.salary=salary;}
    public void setWorked(boolean isWorked){this.isWorked=isWorked;}

    //getters for unique attributes
    public String getPosition(){return position;}
    public float getSalary(){return salary;}


    //Overridden getter of full info for employee
    @Override
    public String getInfo(){
        return super.getInfo() + "\nPosition: " + position + "\nSalary: $" + salary;
    }

    //implementing method toBreath
    @Override
    public void toBreathe() {
        System.out.println("Employee is breathing");
    }

    //implementing method toEat
    @Override
    public void toEat() {
        System.out.println("Employee has eaten!");
    }

    //implementing method toDrink
    @Override
    public void toDrink() {
        System.out.println("Employee has drunk!");
    }

    //implementing method toWork
    @Override
    public void toWork() {
        this.isWorked = true;
        }

    //implementing method getPaid
    @Override
    public void getPaid() {
        if (isWorked){
            System.out.println("\nEmployee got paid $" + salary);
        }
        else {
            System.out.println("\nEmployee didn't work");
        }
        }
}
