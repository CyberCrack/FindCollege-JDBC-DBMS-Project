public class College
{
    private int college_id;
    private String name;
    private float percentage;
    private int fees;
    private String location;
    private String contact;
    private String email;
    private String website;
    private String password;


    public College()
    {
    }

    public College(String name, float percentage, int fees, String location, String contact, String email, String website,String password)
    {
        this.name = name;
        this.percentage = percentage;
        this.fees = fees;
        this.location = location;
        this.contact = contact;
        this.email = email;
        this.website = website;
        this.password = password;
    }

    public void setCollege_id(int college_id)
    {
        this.college_id = college_id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPercentage(float percentage)
    {
        this.percentage = percentage;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setFees(int fees)
    {
        this.fees = fees;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public String getName()
    {
        return name;
    }

    public float getPercentage()
    {
        return percentage;
    }

    public int getFees()
    {
        return fees;
    }

    public String getLocation()
    {
        return location;
    }

    public String getContact()
    {
        return contact;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getWebsite()
    {
        return website;
    }

    public String getDetailsAsString()
    {
        return college_id + ":" + name + ":" + percentage + ":" + fees + ":" + location + ":" + contact + ":" + email + ":" + website;
    }
}
