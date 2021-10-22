package shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_Operations {
    private DB_Manager dbManager;

    public DB_Operations() {
        dbManager = new DB_Manager();
    }
    
    public ArrayList<Item> getItems() {
        ResultSet rs = null;
        ArrayList<Item> items = new ArrayList<Item>();
        try {

            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from ITEM";

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            
            
            while (rs.next()) {
                Item itm = new Item();
                itm.ID = rs.getInt("ID");
                itm.Name = rs.getString("NAME");
                itm.price = rs.getDouble("PRICE");
                itm.color = rs.getString("COLOR");
                itm.size = rs.getString("SIZE");
                itm.QTY = rs.getInt("QTY");
                items.add(itm);
            }

        } catch (SQLException ex) {
        }
        catch (Exception ex) {
        }
        return items;
    }
    
    public ArrayList<Item> getCart(int id) {
        ResultSet rs = null;
        ArrayList<Item> items = new ArrayList<Item>();
        try {

            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select ITEM.ID,ITEM.NAME,ITEM.PRICE,ITEM.COLOR,ITEM.SIZE,CART.QTY from ITEM, CART "+" where CART.USERID = "+ id +" and CART.ITEMID = ITEM.ID";

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            
            
            while (rs.next()) {
                Item itm = new Item();
                itm.ID = rs.getInt("ID");
                itm.Name = rs.getString("NAME");
                itm.price = rs.getDouble("PRICE");
                itm.color = rs.getString("COLOR");
                itm.size = rs.getString("SIZE");
                itm.QTY = rs.getInt("QTY");
                items.add(itm);
            }

        } catch (SQLException ex) {
        }
        catch (Exception ex) {
        }
        return items;
    }
    
    public int login(String name, String pass) {
        ResultSet rs = null;
        try {
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from USERINFO "+" where NAME = '"+ name.toLowerCase() +"' and PASSWORD = '" + pass+"'";

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            
            
            if (rs.next()) {
                if(rs.getString("TYPE").equals("2"))
                    return 2;
                return 1;
            }
            return 3;

        } catch (SQLException ex) {
        }
        catch (Exception ex) {
        }
        return 3;
    }
    
    public boolean signup(String name, String pass) {
        ResultSet rs = null;
        try {
            Statement statement = dbManager.getConnection().createStatement();

            String sqlQuery = "INSERT INTO USERINFO(NAME,PASSWORD,TYPE) VALUES('"+ name.toLowerCase() +"','" + pass + "',1)";
            statement.executeUpdate(sqlQuery);
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        catch (Exception ex) {
        }
        return false;
    }
    
    public boolean insertIntoCart(int userID,int itemID) {
        ResultSet rs = null;
        try {
            Statement statement = dbManager.getConnection().createStatement();
            if(getItemQuantity(itemID)>0){
            if(isInCart(itemID,userID) == -1){
                String sqlQuery = "insert into CART(USERID,ITEMID,QTY) VALUES("+ userID +"," + itemID + ",1)";
                statement.executeUpdate(sqlQuery);
                updateItemQuantity(itemID,-1);
                return true;
            }
            else{
            String sqlQuery = "update CART set QTY = QTY + 1" +" where USERID = "+ userID + " and ITEMID = " + itemID;
            statement.executeUpdate(sqlQuery);
            updateItemQuantity(itemID,-1);
            }
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return false;
    }
    
    public boolean insertItem(Item itm) {
        ResultSet rs = null;
        try {
            Statement statement = dbManager.getConnection().createStatement();

            String sqlQuery = "insert into ITEM(NAME,SIZE,PRICE,COLOR,QTY) VALUES('"+ itm.Name +"','" + itm.size + "'," + itm.price + ",'" + itm.color + "',"+itm.QTY+")";
            statement.executeUpdate(sqlQuery);
            return true;

        } catch (SQLException ex) {
        }
        catch (Exception ex) {
        }
        return false;
    }
    
    public int getUserID(String Email){
        ResultSet rs = null;
        try {
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from USERINFO "+" where NAME = '"+ Email.toLowerCase() +"'";
            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            if (rs.next()) 
                return rs.getInt("ID");

        } catch (SQLException ex) {
        }
        catch (Exception ex) {
        }
        return 0;
    }
    
    public int getItemQuantity(int id){
        ResultSet rs = null;
        try {
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from ITEM "+" where ID = "+ id;
            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            if (rs.next()) 
                return rs.getInt("QTY");

        } catch (SQLException ex) {
        }
        catch (Exception ex) {
        }
        return 0;
    }
    
    public void updateItemQuantity(int id,int val){
        ResultSet rs = null;
        try {
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            String sqlQuery = "update ITEM set QTY = QTY + "+ val +" where ID = "+ id;
            statement.executeUpdate(sqlQuery);
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        catch (Exception ex) {
        }
    }
    
    public int isInCart(int itmID,int uID){
        ResultSet rs = null;
        try {
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from CART "+" where ITEMID = "+ itmID + " and USERID = " + uID;
            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            if (rs.next()) 
                return rs.getInt("QTY");

        } catch (SQLException ex) {
        }
        catch (Exception ex) {
        }
        return -1;
    }
    
    public boolean deleteFromCart(int userID,int itemID) {
        ResultSet rs = null;
        try {
            Statement statement = dbManager.getConnection().createStatement();
            String sqlQuery;
            if(isInCart(itemID,userID) <= 1)
                sqlQuery = "delete from CART where USERID = "+ userID +" and ITEMID = " + itemID;
            else
                sqlQuery = "update CART set QTY = QTY - 1 where USERID = "+ userID +" and ITEMID = " + itemID;
            statement.executeUpdate(sqlQuery);
            updateItemQuantity(itemID,1);
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        catch (Exception ex) {
        }
        return false;
    }
    
    public boolean deleteItem(int ID) {
        ResultSet rs = null;
        try {
            Statement statement = dbManager.getConnection().createStatement();

            String sqlQuery = "delete from ITEM where ID = "+ ID;
            statement.executeUpdate(sqlQuery);
            return true;

        } catch (SQLException ex) {
        }
        catch (Exception ex) {
        }
        return false;
    }
    
    public boolean deleteCart(int userID) {
        ResultSet rs = null;
        try {
            Statement statement = dbManager.getConnection().createStatement();

            String sqlQuery = "delete from CART where USERID = "+ userID;
            statement.executeUpdate(sqlQuery);
            return true;

        } catch (SQLException ex) {
        }
        catch (Exception ex) {
        }
        return false;
    }

    public static void main(String[] args) {
        DB_Operations dboperations = new DB_Operations();
        boolean tr = dboperations.signup("Raghad@gmail.com", "r12345");
        System.out.println(tr);
        dboperations.dbManager.closeConnections();

    }
}
