package shop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controller implements ActionListener {

    Model model;
    View view;

    Controller() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getSignupSubmit()){
            try{
            if(view.getUserName_textS().getText().equals("")||view.getPassword_textS().getText().equals(""))
                return;
            model.Signup(view.getUserName_textS().getText(), view.getPassword_textS().getText());
            model.GetAllItems();
            }
            catch(Exception ex){
                
            }
        }
        else if(e.getSource() == view.getLoginSubmit()){
            view.setUsr(UserFactory.getInstance(view.getUserName_text().getText(), view.getPassword_text().getText()));
            model.Login(view.getUserName_text().getText(), view.getPassword_text().getText());
            model.GetAllItems();
        }
        else if(e.getSource() == view.getSignin()){
            model.GoToSignin();
        }
        else if(e.getSource() == view.getSignup()){
            model.GoToSignup();
        }
        else if(e.getSource() == view.getBack()){
            model.GoToMainPage();
            model.GetAllItems();
        }
        else if(e.getSource() == view.getViewCart()){
            model.GoToCart();
            model.GetCart(view.getUsr().getEmail());
        }
        else if(e.getSource() == view.getAddItem()){
            try{
            if(view.getItemName().getText().equals("")||view.getItemColor().getText().equals("")||view.getItemSize().getText().equals(""))
                return;
            Item itm = new Item();
            itm.Name = view.getItemName().getText();
            itm.color = view.getItemColor().getText();
            itm.size = view.getItemSize().getText();
            itm.price = Double.parseDouble(view.getItemPrice().getText());
            itm.QTY = Integer.parseInt(view.getItemQ().getText());
            model.AddItem(itm);
            model.GetAllItems();
            view.getItemName().setText("");
            view.getItemSize().setText("");
            view.getItemColor().setText("");
            }
            catch(Exception ex){
                
            }
        }
        else if(e.getSource() == view.getDeleteItem()){
            try{
            String [] ar = view.getListOfItems2().getSelectedValue().split("-")[1].split(",");
            int id = Integer.parseInt(ar[0]);
            model.DeleteItem(id);
            model.GetAllItems();
            }
            catch(Exception ex){
            }
        }
        else if(e.getSource() == view.getAddToCart()){
            try{
            String [] ar = view.getListOfItems().getSelectedValue().split("-")[1].split(",");
            int id = Integer.parseInt(ar[0]);
            model.AddToCart(id,view.getUsr().email);
            model.GetAllItems();
            }
            catch(Exception ex){
            }
        }
        
        else if(e.getSource() == view.getDeleteFromCart()){
            try{
            String [] ar = view.getListOfItemsInCart().getSelectedValue().split("-")[1].split(",");
            int id = Integer.parseInt(ar[0]);
            model.DeleteFromCart(id,view.getUsr().email);
            model.GetCart(view.getUsr().getEmail());
            }
            catch(Exception ex){
            }
        }
        
        else if(e.getSource() == view.getCheckout()){
            try{
            model.DeleteCart(view.getUsr().email);
            }
            catch(Exception ex){
            }
        }
    }

    public void addModel(Model m) {
        this.model = m;
    }

    public void addView(View v) {
        this.view = v;
    }

    public void initModel() {
        model.GetAllItems();
    }
}
