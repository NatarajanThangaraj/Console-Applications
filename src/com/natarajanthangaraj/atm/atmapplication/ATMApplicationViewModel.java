package com.natarajanthangaraj.atm.atmapplication;

import com.natarajanthangaraj.atm.balanceenquary.BalanceEnquiryView;
import com.natarajanthangaraj.atm.deposit.DepositView;
import com.natarajanthangaraj.atm.dto.CardDetails;
import com.natarajanthangaraj.atm.validate.InputValidater;
import com.natarajanthangaraj.atm.withdrawel.WithdrawelView;
import com.natarajanthangaraj.atm.repository.Repository;

public class ATMApplicationViewModel {
	ATMApplicationview atmview;
	DepositView deposit=new DepositView();
	WithdrawelView withdraw=new WithdrawelView();
	BalanceEnquiryView enquiry=new BalanceEnquiryView();
	public ATMApplicationViewModel(ATMApplicationview atmApplicationview) {
		this.atmview=atmApplicationview;
	}
	public boolean formatValidate(CardDetails carddetail) {
		
		return InputValidater.validateCardDetails(carddetail);
	}
	public void datavalidate(CardDetails carddetail) {
		if(Repository.getInstance().validation(carddetail)) {
			atmview.printMenu();
			features(carddetail.getATMCardNumber(), atmview.userSelection());
		}else {
			atmview.errorMessage();
		}
		
	}
	private void features(String userID,int userSelection) {
		switch(userSelection) {
		case 1->{
			deposit.getdepositAmount(userID);
		}
		case 2->{
			withdraw.getWithdrawAmount(userID);
		}
		case 3->{
			enquiry.getBalanceDetails(userID);
		}
		default ->{
			System.out.println("\n Thank you for Banking with us...\n");
		}
		}
		
	}

}
