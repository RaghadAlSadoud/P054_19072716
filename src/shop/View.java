package shop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.*;

class View implements Observer {
    
    private String items, cart;
    //pages
    private JFrame signinPage;
    private JFrame signupPage;
    private JFrame mainPage;
    private JFrame mainPageSeller;
    private JFrame cartPage;
    private user usr;
    
    //signin
    private JTextArea myJTextArea;
    private JButton LoginSubmit, signup;
    private JTextField userName_text;
    private JTextField password_text;
    
    //signup
    private JButton signupSubmit, signin;
    private JTextField userName_textS;
    private JTextField password_textS;    
    //main page
    private DefaultListModel<String> l1;
    private JButton viewCart,addToCart;
    JList<String> listOfItems;
    //main page seller
    private JButton addItem,deleteItem;
    JList<String> listOfItems2;
    private JTextField itemName,itemColor,itemSize,itemPrice,itemQ;
    //cart page
    private DefaultListModel<String> l3;
    private JButton deleteFromCart,back,checkout;
    private JList<String> listOfItemsInCart;
    private JLabel total = new JLabel("Total:0.0$");

    //Components initialization
    public View() {
        signinPage = new JFrame("Shop:Login");
        signupPage = new JFrame("Shop:Signup");
        mainPage = new JFrame("Shop:Main Page");
        mainPageSeller = new JFrame("Shop:Main Page");
        cartPage = new JFrame("Shop:Cart");
        
        // User Label
        JLabel user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        
        // Password
        JLabel password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();

        // Submit
        LoginSubmit = new JButton("SUBMIT");
        
        

        JPanel signinCOmponant = new JPanel(new GridLayout(4, 1));

        signinCOmponant.add(user_label);
        signinCOmponant.add(userName_text);
        signinCOmponant.add(password_label);
        signinCOmponant.add(password_text);

        JLabel message = new JLabel();
        signinCOmponant.add(message);
        signinCOmponant.add(LoginSubmit);
        
        JPanel fl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel SignupL = new JLabel("you don't have an account? ");
        fl.add(SignupL);
        signup = new JButton("Signup Now");
        fl.add(signup);
        signinCOmponant.add(fl);
        JLabel empty = new JLabel();
        signinCOmponant.add(empty);
        signinCOmponant.setSize(300, 100);
        
        
        JPanel Panel = new JPanel(new BorderLayout());
        Panel.add(signinCOmponant,BorderLayout.CENTER);
        JLabel empty1,empty2,empty3,empty4;
        empty1 = new JLabel();
        empty2 = new JLabel();
        empty3 = new JLabel();
        empty4 = new JLabel();
        Panel.add(empty1,BorderLayout.NORTH);
        Panel.add(empty2,BorderLayout.SOUTH);
        Panel.add(empty3,BorderLayout.WEST);
        Panel.add(empty4,BorderLayout.EAST);
        
        signinPage.add(Panel);

        signinPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signinPage.setSize(600, 180);
        signinPage.setLocation(100, 100);
        signinPage.setVisible(true);
        
        //...............................................................................        
        // User Label
        JLabel user_label1 = new JLabel();
        user_label1.setText("User Name :");
        userName_textS = new JTextField();
        
        // Password
        JLabel password_label1 = new JLabel();
        password_label1.setText("Password :");
        password_textS = new JPasswordField();

        // Submit
        signupSubmit = new JButton("SUBMIT");

        JPanel signupCOmponant = new JPanel(new GridLayout(4, 1));

        signupCOmponant.add(user_label1);
        signupCOmponant.add(userName_textS);
        signupCOmponant.add(password_label1);
        signupCOmponant.add(password_textS);

        JLabel message1 = new JLabel();
        signupCOmponant.add(message);
        signupCOmponant.add(signupSubmit);
        
        JPanel f2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel SigninL = new JLabel("you already have an account? ");
        f2.add(SigninL);
        signin = new JButton("Signin Now");
        f2.add(signin);
        signupCOmponant.add(f2);
        signupCOmponant.add(empty2);
        signupCOmponant.setSize(300, 100);
        
        signupPage.add(signupCOmponant);
        
        signupPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signupPage.setSize(600, 180);
        signupPage.setLocation(100, 100);
        signupPage.setVisible(false);
        //.........................................................................
        //main
        
        
        l1 = new DefaultListModel<>(); 
        listOfItems = new JList<>(l1);  
        listOfItems.setBounds(100,100, 75,75);  
        viewCart = new JButton("view cart");
        addToCart = new JButton("+ Add to cart");
        JPanel mainComponant = new JPanel(new BorderLayout());
        JPanel btn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btn.add(viewCart);
        JPanel btn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btn2.add(addToCart);
        mainComponant.add(btn,BorderLayout.NORTH);
        mainComponant.add(listOfItems,BorderLayout.CENTER);
        mainComponant.add(btn2,BorderLayout.SOUTH);
        
        
        mainPage.add(mainComponant);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setSize(600, 600);
        mainPage.setLocation(100, 100);
        mainPage.setVisible(false);
        
        //.........................................................................
        //main seller
        listOfItems2 = new JList<>(l1);  
        listOfItems2.setBounds(100,100, 75,75);  
        deleteItem = new JButton("Delete Item");
        addItem = new JButton("+ Add Item");
        JPanel mainSellerComponant = new JPanel(new BorderLayout());
        JPanel btn3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btn3.add(deleteItem);
        btn3.add(addItem);
        JPanel btn4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        itemName = new JTextField("",7);
        
        itemPrice  = new JTextField(5);
        itemColor= new JTextField("",7);
        itemSize = new JTextField("",7);
        itemQ = new JTextField(5);
        JLabel ll1,ll2,ll3,ll4,ll5;
        ll1 = new JLabel("Item Name");
        ll2 = new JLabel("Item Price");
        ll3 = new JLabel("Item Color");
        ll4 = new JLabel("Item Size");
        ll5 = new JLabel("Item Quantity");
        
        
        btn4.add(addItem);
        btn4.add(ll1);
        btn4.add(itemName);
        btn4.add(ll2);
        btn4.add(itemPrice);
        btn4.add(ll3);
        btn4.add(itemColor);
        btn4.add(ll4);
        btn4.add(itemSize);
        btn4.add(ll5);
        btn4.add(itemQ);
        mainSellerComponant.add(btn3,BorderLayout.NORTH);
        mainSellerComponant.add(listOfItems2,BorderLayout.CENTER);
        mainSellerComponant.add(btn4,BorderLayout.SOUTH);
        
        
        mainPageSeller.add(mainSellerComponant);
        mainPageSeller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPageSeller.setSize(860, 700);
        mainPageSeller.setLocation(20, 20);
        mainPageSeller.setVisible(false);
        
        
        
        //.........................................................................
        //Cart
        l3 = new DefaultListModel<>(); 
        listOfItemsInCart = new JList<>(l3);  
        listOfItemsInCart.setBounds(100,100, 75,75);  
        back = new JButton("Back");
        checkout = new JButton("Checkout");
        deleteFromCart = new JButton("delete selected item");
        JPanel cartComponant = new JPanel(new BorderLayout());
        JPanel btn5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btn5.add(back);
        JPanel btn6 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btn6.add(total);
        btn6.add(checkout);
        btn6.add(deleteFromCart);
        cartComponant.add(btn5,BorderLayout.NORTH);
        cartComponant.add(listOfItemsInCart,BorderLayout.CENTER);
        cartComponant.add(btn6,BorderLayout.SOUTH);
        
        
        cartPage.add(cartComponant);
        cartPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cartPage.setSize(600, 600);
        cartPage.setLocation(100, 100);
        cartPage.setVisible(false);
        
    }

    public JTextField getItemQ() {
        return itemQ;
    }

    @Override
    public void update(Observable obs, Object obj) {
        try{
        String str = obj.toString();
        l3.clear();
        l1.clear();
        total.setText("Total:0.0$");
        if(str.contains("GoToMainPage")){
                    mainPageSeller.setVisible(false);
                    signinPage.setVisible(false);
                    signupPage.setVisible(false);
                    mainPage.setVisible(true);
                    cartPage.setVisible(false);
        }
        else if(str.contains("GoToSignin")){
                    mainPageSeller.setVisible(false);
                    signinPage.setVisible(true);
                    signupPage.setVisible(false);
                    mainPage.setVisible(false);
                    cartPage.setVisible(false);
        }
        else if(str.contains("GoToSignup")){
                    mainPageSeller.setVisible(false);
                    signinPage.setVisible(false);
                    signupPage.setVisible(true);
                    mainPage.setVisible(false);
                    cartPage.setVisible(false);
        }
        else if(str.contains("GoToCart")){
                    mainPageSeller.setVisible(false);
                    signinPage.setVisible(false);
                    signupPage.setVisible(false);
                    mainPage.setVisible(false);
                    cartPage.setVisible(true);
        }
        else if(str.contains("Checkout")){
            JOptionPane.showMessageDialog(cartPage,
                "Thank you.",
                "success",
                JOptionPane.INFORMATION_MESSAGE);      
        }
        else if(str.contains("Signup")){
            if(str.contains("true")){
                mainPageSeller.setVisible(false);
                usr = new buyer();
                usr.email = userName_textS.getText();
                usr.password = password_textS.getText();
                signinPage.setVisible(false);
                signupPage.setVisible(false);
                mainPage.setVisible(true);
                cartPage.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(signupPage,
                "Invalid Information.",
                "error",
                JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else if(str.contains("Login")){
            if(str.toLowerCase().contains("true")){
                if(str.toLowerCase().contains("2")){
                    mainPageSeller.setVisible(true);
                    usr.email = userName_text.getText();
                    usr.password = password_text.getText();
                    signinPage.setVisible(false);
                    signupPage.setVisible(false);
                    mainPage.setVisible(false);
                    cartPage.setVisible(false);
                }
                else{
                    mainPageSeller.setVisible(false);
                    usr.email = userName_text.getText();
                    usr.password = password_text.getText();
                    signinPage.setVisible(false);
                    signupPage.setVisible(false);
                    mainPage.setVisible(true);
                    cartPage.setVisible(false);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(signupPage,
                "Email or password is worng.",
                "error",
                JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        
        else if(str.contains("Item: ")){
            double sum = 0;
            l3.addElement("Please select an item");
            String []a = str.split("\n");
            for(int i =0;i<a.length;i++){
                String [] st =a[i].split(",");
                sum+=Double.parseDouble(st[st.length-1].split("=")[1])*Integer.parseInt(st[st.length-2].split("=")[1]);
                l3.addElement(a[i]);
            }
            total.setText("Total:"+sum+"$");
        }
        else if(str.contains("ID-")){
            l1.clear();
            l1.addElement("Please select an item");
            String []a = str.split("\n");
            for(int i =0;i<a.length;i++){
                l1.addElement(a[i]);
            }
             if(l1.size() == 0)
                listOfItems.removeAll();       
        }
        }
        catch(Exception e){
            
        }
    }

    public void setUsr(user usr) {
        this.usr = usr;
    }

    public void addController(Controller controller) {
        LoginSubmit.addActionListener(controller);
        signupSubmit.addActionListener(controller);
        addToCart.addActionListener(controller);
        deleteFromCart.addActionListener(controller);
        addItem.addActionListener(controller);
        deleteItem.addActionListener(controller);
        signup.addActionListener(controller);
        signin.addActionListener(controller);
        viewCart.addActionListener(controller);
        back.addActionListener(controller);
        checkout.addActionListener(controller);
    }

    public JButton getCheckout() {
        return checkout;
    }

    public user getUsr() {
        return usr;
    }

    public JButton getBack() {
        return back;
    }

    public JTextField getUserName_text() {
        return userName_text;
    }

    public JTextField getPassword_text() {
        return password_text;
    }

    public JTextField getUserName_textS() {
        return userName_textS;
    }

    public JTextField getPassword_textS() {
        return password_textS;
    }

    public JList<String> getListOfItems() {
        return listOfItems;
    }

    public JList<String> getListOfItems2() {
        return listOfItems2;
    }

    public JTextField getItemName() {
        return itemName;
    }

    public JTextField getItemColor() {
        return itemColor;
    }

    public JTextField getItemSize() {
        return itemSize;
    }

    public JTextField getItemPrice() {
        return itemPrice;
    }

    public JList<String> getListOfItemsInCart() {
        return listOfItemsInCart;
    }

    public JButton getLoginSubmit() {
        return LoginSubmit;
    }

    public JButton getSignup() {
        return signup;
    }

    public JButton getSignupSubmit() {
        return signupSubmit;
    }

    public JButton getSignin() {
        return signin;
    }

    public JButton getViewCart() {
        return viewCart;
    }

    public JButton getAddToCart() {
        return addToCart;
    }

    public JButton getAddItem() {
        return addItem;
    }

    public JButton getDeleteItem() {
        return deleteItem;
    }

    public JButton getDeleteFromCart() {
        return deleteFromCart;
    }

}
