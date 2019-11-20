import java.sql.*;

public class JDBC_SQL_Execute
{
    private Connection conn;

    public JDBC_SQL_Execute() throws SQLException
    {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/find_college_db", "Mayank", "apple");
    }

    public int InsertValues(College clg) throws Exception
    {
        ViewAllColleges();
        for (College college : College_Main.clgs)
        {
            if (college.getName().equals(clg.getName())) return 1;
        }
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("insert into Colleges(CNAME,MIN_PERCENTAGE,FEES,LOCATION,CONTACT,EMAIL,WEBSITE) values(?,?,?,?,?,?,?)");
        stmt.setString(1, clg.getName());
        stmt.setFloat(2, clg.getPercentage());
        stmt.setInt(3, clg.getFees());
        stmt.setString(4, clg.getLocation());
        stmt.setString(5, clg.getContact());
        stmt.setString(6, clg.getEmail());
        stmt.setString(7, clg.getWebsite());
        stmt.executeUpdate();

        stmt = conn.prepareStatement("insert into LOGIN_COLLEGES(EMAIL,PASSWRD) values(?,?)");
        stmt.setString(1, clg.getEmail());
        stmt.setString(2, clg.getPassword());
        stmt.executeUpdate();
        return 0;
    }


    public int InsertValues(Student student) throws Exception
    {

        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("insert into students(FNAME , MNAME, LNAME ,DOB ,GENDER ,CONTACT,EMAIL,LOCATION ) values(?,?,?,?,?,?,?,?)");
        stmt.setString(1, student.getFname());
        stmt.setString(2, student.getMname());
        stmt.setString(3, student.getLname());
        stmt.setString(4, student.getDob());
        stmt.setString(5, student.getGender());
        stmt.setString(6, student.getContact());
        stmt.setString(7, student.getEmail());
        stmt.setString(8, student.getLocation());
        stmt.executeUpdate();

        stmt = conn.prepareStatement("insert into LOGIN_STUDENTS(EMAIL,PASSWRD) values(?,?)");
        stmt.setString(1, student.getEmail());
        stmt.setString(2, student.getPassword());
        stmt.executeUpdate();
        return 0;
    }

    public int InsertValues(Marks marks) throws Exception
    {

        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("INSERT INTO MARKS(ENGLISH,HINDI_KANNADA,MATHS,PHYSICS,CHEMISTRY,COMPUTER_BIOLOGY) VALUES(?,?,?,?,?,?);");
        stmt.setInt(1, marks.getEnglish());
        stmt.setInt(2, marks.getHindiKannada());
        stmt.setInt(3, marks.getMaths());
        stmt.setInt(4, marks.getPhysics());
        stmt.setInt(5, marks.getChemistry());
        stmt.setInt(6, marks.getComputerBiology());
        stmt.executeUpdate();

        return 0;
    }


    public void ViewAllColleges() throws Exception
    {
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("select * from colleges");
        ResultSet rs = stmt.executeQuery();
        College_Main.clgs.clear();
        while (rs.next())
        {
            College college = new College();
            college.setCollege_id(rs.getInt("COLLEGE_ID"));
            college.setName(rs.getString("CNAME"));
            college.setPercentage(rs.getFloat("MIN_PERCENTAGE"));
            college.setFees(rs.getInt("FEES"));
            college.setLocation(rs.getString("LOCATION"));
            college.setContact(rs.getString("CONTACT"));
            college.setEmail(rs.getString("EMAIL"));
            college.setWebsite(rs.getString("WEBSITE"));
            College_Main.addClg(college);

        }
    }

    public void DeleteCollege(String nameOrEmail) throws SQLException
    {
        PreparedStatement stmt = null;
        if (!nameOrEmail.contains("@")) stmt = conn.prepareStatement("delete from colleges where cname=?");
        else stmt = conn.prepareStatement("delete from colleges where EMAIL=?");
        stmt.setString(1, nameOrEmail);
        stmt.executeUpdate();
        College_Main.clgs.clear();
    }

    public int CollegeLogin(String email, String password) throws SQLException
    {
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("select COLLEGE_ID from LOGIN_COLLEGES where EMAIL=? and PASSWRD=?");
        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        int count = 0;
        while (rs.next())
        {
            count++;
        }
        if (count != 1)
        {
            return 1;
        }
        return 0;
    }

    public int CollegeUpdate(float percentage, String email) throws SQLException
    {
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("update colleges set MIN_PERCENTAGE=? where EMAIL=?");
        stmt.setFloat(1, percentage);
        stmt.setString(2, email);
        stmt.executeUpdate();
        return 0;
    }

    public int CollegeUpdate(int fees, String name) throws SQLException
    {
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("update colleges set FEES=? where EMAIL=?");
        stmt.setInt(1, fees);
        stmt.setString(2, name);
        stmt.executeUpdate();
        return 0;
    }

    public int CollegeUpdate(String contact, String name) throws SQLException
    {
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("update colleges set CONTACT=? where EMAIL=?");
        stmt.setString(1, contact);
        stmt.setString(2, name);
        stmt.executeUpdate();
        return 0;
    }

    public int StudentLogin(String email, String password) throws SQLException
    {
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("select STUDENT_ID from LOGIN_STUDENTS where EMAIL=? and PASSWRD=?");
        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        int count = 0;
        while (rs.next())
        {
            count++;
        }
        if (count != 1)
        {
            return 1;
        }
        return 0;
    }

    public void DeleteStudent(String idOrEmail) throws SQLException
    {
        PreparedStatement stmt = null;
        if (!idOrEmail.contains("@"))
        {
            int id = Integer.parseInt(idOrEmail);
            stmt = conn.prepareStatement("delete from students where STUDENT_ID=?");
            stmt.setInt(1, id);

        } else
        {
            stmt = conn.prepareStatement("delete from students where EMAIL=?");
            stmt.setString(1, idOrEmail);
        }
        stmt.executeUpdate();
        Student_Main.studs.clear();
    }
}
