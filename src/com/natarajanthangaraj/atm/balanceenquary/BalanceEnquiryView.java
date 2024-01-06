package com.natarajanthangaraj.atm.balanceenquary;

public class BalanceEnquiryView {
public BalanceEnquiryViewModel enquiryviewmodel;
public BalanceEnquiryView(){
	this.enquiryviewmodel=new BalanceEnquiryViewModel(this);
}
public void getBalanceDetails(String userId) {
	enquiryviewmodel.BalanceDetails(userId);
}
public void showDetails(Long accountNumber,Double balance) {
	System.out.println("\n Account Number : "+accountNumber);
	System.out.println("\n Balance :  Rs."+balance);
}

}
