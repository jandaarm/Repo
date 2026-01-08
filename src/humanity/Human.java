package humanity;

public abstract class Human {
    //attributes
    protected int age;
    protected String name;
    protected boolean isAlive;

    //all attributes constructor
    public Human(int age, String name, boolean isAlive){
        this.age=age;
        this.name=name;
        this.isAlive=isAlive;
    }

    //empty constructor
    public Human(){}

    //getter of Full info (method getInfo)
    public String getInfo(){return "Age: " + age + "\nName: " + name + "\nAlive: " + isAlive;}

    //method sing
    public void sing(){
        System.out.println("But I'm only human after all\nI'm only human after all");
    }

    //abstract method
    public abstract void toBreathe();

    //setters
    public void setAge(int age){this.age=age;}
    public void setName(String name){this.name=name;}
    public void setAlive(boolean isAlive){this.isAlive=isAlive;}

    //getters
    public int getAge(){return age;}
    public String getName(){return name;}
    public boolean getAlive(){return isAlive;}


}
