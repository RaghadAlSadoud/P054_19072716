
package shop;


public class Seller extends user
{
    String jobTitle;
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Seller() {
        jobTitle = "Admin";
    }
    
    public Seller(String email, String pass){
        this.email = email;
        this.password = pass;
        jobTitle = "Admin";
    }

    public int Type() {
        return 1;
    }
}
