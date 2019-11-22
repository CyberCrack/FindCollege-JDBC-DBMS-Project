import java.util.ArrayList;

public class Marks_Main
{
    static ArrayList<Marks> marks = new ArrayList<Marks>();

    public static void addStuds(Marks marks1) throws Exception
    {
        marks.add(marks1);
    }

    public static ArrayList<Marks> getMarks()
    {
        return marks;
    }

    public static void setMarks(ArrayList<Marks> marks)
    {
        Marks_Main.marks = marks;
    }
}
