package shop;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {
    private DB_Operations op;

    public Model() {
        op = new DB_Operations();
    }

    public void Signup(String Name, String Pass){
        boolean res = op.signup(Name, Pass);
        setChanged();
        notifyObservers("Signup?"+res);
    }
    
    public void Login(String Name, String Pass){
        int res = op.login(Name, Pass);
        setChanged();
        if(res != 3){
            notifyObservers("Login?true"+res);
        }
        else
            notifyObservers("Login?false");
    }
    
    public void AddToCart(int itmId,String Email){
        int id = op.getUserID(Email);
        boolean res = op.insertIntoCart(id, itmId);
        GetCart(id);
    }
    
    public void DeleteFromCart(int itmId,String Email){
        int id = op.getUserID(Email);
        boolean res = op.deleteFromCart(id,itmId);
        GetCart(id);
    }
    
    public void DeleteCart(String email){
        int iId = op.getUserID(email);
        boolean res = op.deleteCart(iId);
        setChanged();
        notifyObservers("Checkout?");
    }
    
    public void AddItem(Item itm){
        boolean res = op.insertItem(itm);
        GetAllItems();
    }
    
    public void DeleteItem(int itm){
        boolean res = op.deleteItem(itm);
        GetAllItems();
    }
    
    public void GoToSignup(){
        setChanged();
        notifyObservers("GoToSignup?");
    }
    
    public void GoToSignin(){
        setChanged();
        notifyObservers("GoToSignin?");
    }
    
    public void GoToCart(){
        setChanged();
        notifyObservers("GoToCart?");
    }
    
    public void GoToMainPage(){
        setChanged();
        notifyObservers("GoToMainPage?");
    }
    
    public void GetAllItems(){
        ArrayList<Item> itms = op.getItems();
        String res = "";
        for(Item i : itms){
            res+=i.toString()+"\n";
        }
        setChanged();
        notifyObservers(res);
    }
    
    public void GetCart(int id){
        ArrayList<Item> itms = op.getCart(id);
        String res = "";
        for(Item i : itms){
            res+="Item: " + i.toString()+"\n";
        }
        setChanged();
        notifyObservers(res);
    }
    
    public void GetCart(String str){
        int id = op.getUserID(str);
        ArrayList<Item> itms = op.getCart(id);
        String res = "";
        for(Item i : itms){
            res+="Item: " + i.toString()+"\n";
        }
        setChanged();
        notifyObservers(res);
    }
}
