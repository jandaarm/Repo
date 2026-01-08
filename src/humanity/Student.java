package humanity;

import interfaces.INeeds;

public final class Student extends Human implements INeeds{
    //unique attributes for student
    private String major;
    private float gpa;
    //final field
    private final String university = "AITU";

    //all attributes constructor
    public Student(int age, String name, boolean isAlive, String major, float gpa){
        super(age, name, isAlive);
        this.major=major;
        this.gpa=gpa;
    }

    //empty constructor
    public Student(){}

    //setters for unique attributes
    public void setMajor(String major){this.major=major;}
    public void setGPA(float gpa){this.gpa=gpa;}

    //getters for unique attributes
    public String getMajor(){return major;}
    public float getGPA(){return gpa;}
    //final method
    public final String getUniversity() {return university;}



    //Overridden getter of full info for student
    @Override
    public String getInfo(){
        return super.getInfo() + "\nMajor: " + major + "\nGPA: " + gpa;
    }


    //implementing method toBreath
    @Override
    public void toBreathe() {
        System.out.println("Student is breathing");
    }


    //implementing method toEat
    @Override
    public void toEat() {
        System.out.println("Student has eaten!");
    }

    //implementing method toDrink
    @Override
    public void toDrink() {
        System.out.println("Student has drunk!");
    }
}
