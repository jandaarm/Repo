public class Human {
    //attributes
    private int Age;
    private String Name;
    private boolean Alive;

    //all attributes constructor
    public Human(int Age, String Name, boolean Alive){
        this.Age=Age;
        this.Name=Name;
        this.Alive=Alive;
    }

    //empty constructor
    public Human(){}

    //setters
    public void setAge(int Age){this.Age=Age;}
    public void setName(String Name){this.Name=Name;}
    public void setAlive(boolean Age){this.Alive=Alive;}

    //getters
    public int getAge(){return Age;}
    public String getName(){return Name;}
    public boolean getAlive(){return Alive;}

    //getter of Full info (method getInfo)
    public String getInfo(){return "Age: " + Age + "\nName: " + Name + "\nAlive: " + Alive;}

    //method Sing
    public void Sing(){
        System.out.println("But I'm only human after all\nI'm only human after all");
    }
}
