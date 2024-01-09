package com.natarajanthangaraj.atm.balanceenquary;

public class BalanceEnquiryView {
public BalanceEnquiryViewModel enquiryviewmodel;
public BalanceEnquiryView(){
	this.enquiryviewmodel=new BalanceEnquiryViewModel(this);
}
public void getBalanceDetails(String userId) {
	enquiryviewmodel.BalanceDetails(userId);
}
public void showDetails(String string,Double balance) {
	System.out.println("\n Account Number : "+string);
	System.out.println("\n Balance :  Rs."+balance);
}

}
