import java.util.ArrayList;

public class Student_Main
{
    static ArrayList<Student> studs = new ArrayList<Student>();

    public static void addStuds(Student stud) throws Exception
    {
        studs.add(stud);
    }

    public static ArrayList<Student> getStuds()
    {
        return studs;
    }

    public static void setStuds(ArrayList<Student> studs)
    {
        Student_Main.studs = studs;
    }

}
