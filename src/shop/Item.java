
package shop;


public class Item {
    int ID;
    String Name;
    String color;
    String size;
    double price;
    int QTY;

    @Override
    public String toString() {
        return "ID-" + ID + ", Name=" + Name + ", color=" + color + ", size=" + size  + ", Quantity="+QTY + ", price=" + price;
    }
    

    
    public boolean addItem()
    {  
       return false;
    }
    
  public  boolean removeItem()
  {
      return false;
  }

    
}
