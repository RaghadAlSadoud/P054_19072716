package shop;

public class address
{
    String streetNumber;
    String Province;
    String city;
    String PostCode;

    @Override
    public String toString() {
        return "address{" + "streetNumber=" + streetNumber + ", Province=" + Province + ", city=" + city + ", PostCode=" + PostCode + '}';
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getProvince() {
        return Province;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setProvince(String Province) {
        this.Province = Province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }

    
}
