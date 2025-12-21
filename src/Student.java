public class Student extends Human{
    //unique attributes for student
    private String Major;
    private float GPA;

    //all attributes constructor
    public Student(int Age, String Name, boolean Alive, String Major, float GPA){
        super(Age, Name, Alive);
        this.Major=Major;
        this.GPA=GPA;
    }

    //empty constructor
    public Student(){}

    //setters for unique attributes
    public void setMajor(String Major){this.Major=Major;}
    public void setGPA(float GPA){this.GPA=GPA;}

    //getters for unique attributes
    public String getMajor(){return Major;}
    public float getGPA(){return GPA;}


    //Overriden getter of full info for student
    @Override
    public String getInfo(){
        return super.getInfo() + "\nMajor: " + Major + "\nGPA: " + GPA;
    }

    //static field
    public static String University;

}
