public class Employee extends Human{
    //unique attributes for employee
    private String Position;
    private float Salary;

    //all attributes constructor
    public Employee(int Age, String Name, boolean Alive, String Position, float Salary){
        super(Age, Name, Alive);
        this.Position=Position;
        this.Salary=Salary;
    }

    //empty constructor
    public Employee(){}

    //setters for unique attributes
    public void setPosition(String Position){this.Position=Position;}
    public void setSalary(float Salary){this.Salary=Salary;}

    //getters for unique attributes
    public String getPosition(){return Position;}
    public float getSalary(){return Salary;}


    //Overriden getter of full info for employee
    @Override
    public String getInfo(){
        return super.getInfo() + "\nPosition: " + Position + "\nSalary: $" + Salary;
    }
}
