class ExecApplication
{
    public static boolean adminLoggedIn;
    public static boolean collegeLoggedIn;
    public static boolean userLoggedIn;
    public static String collegeEmail;
    public static String userEmail;
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
        new AdminLogin("mayank@gmail.com", "password");
        clg.jfrmMain.setVisible(true);
    }
}
