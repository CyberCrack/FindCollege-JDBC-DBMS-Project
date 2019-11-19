public class ExecApplication
{
    public static boolean adminLoggedIn;
    public static boolean collegeLoggedIn;
    public static boolean userLoggedIn;
    public static String collegeEmail;
    public static boolean userSignedUp;
    public static boolean marksEntered;

    public static void main(String[] args)
    {
        MainFrame clg = new MainFrame();
        adminLoggedIn = false;
        collegeLoggedIn = false;
        userLoggedIn = false;
        userSignedUp = false;
        marksEntered = false;
        AdminLogin adminLogin = new AdminLogin("mayank@gmail.com", "password");
        //clg.setVisible(true);
        clg.jfrmMain.setVisible(true);
    }
}
