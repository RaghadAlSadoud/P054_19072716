package shop;

import java.util.Scanner;


public class CreditCard implements Payment
{
    String CardNumber;
    String CardHolder;
    int CVN;

    @Override
    public String toString() {
        return "CreditCard{" + "CardNumber=" + CardNumber + ", CardHolder=" + CardHolder + ", CVN=" + CVN + '}';
    }

    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    public void setCardHolder(String CardHolder) {
        this.CardHolder = CardHolder;
    }

    public void setCVN(int CVN) {
        this.CVN = CVN;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public String getCardHolder() {
        return CardHolder;
    }

    public int getCVN() {
        return CVN;
    }
    
    @Override
    public String paymentMethod() {
        System.out.println("please enter card number: ");
        Scanner scan = new Scanner(System.in);
        CardNumber = scan.nextLine();
                
        int flag = 1;
        System.out.println("please enter CVN number: ");
        while(flag == 1){
            try{
                CVN = scan.nextInt();
                flag = 0;
            }
            catch(Exception ex){
                System.out.println("Wrong input! CVN should be a number");
                System.out.println("please enter CVN number: ");
            }
        }
        
        return "Credit card";
    }

}
