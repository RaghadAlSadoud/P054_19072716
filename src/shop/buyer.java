package shop;


public class buyer extends user 
{
    private String Birthdate;
    private address addr;

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }

    public void setAddr(address addr) {
        this.addr = addr;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public address getAddr() {
        return addr;
    }

    public int Type() {
        return 0;
    }
    
}
