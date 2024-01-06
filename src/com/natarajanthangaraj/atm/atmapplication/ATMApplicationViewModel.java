package com.natarajanthangaraj.atm.atmapplication;

import com.natarajanthangaraj.atm.balanceenquary.BalanceEnquiryView;
import com.natarajanthangaraj.atm.deposit.DepositView;
import com.natarajanthangaraj.atm.dto.CardDetails;
import com.natarajanthangaraj.atm.pinchange.ChangePinView;
import com.natarajanthangaraj.atm.validate.InputValidater;
import com.natarajanthangaraj.atm.withdrawel.WithdrawelView;
import com.natarajanthangaraj.atm.repository.Repository;

public class ATMApplicationViewModel {
	ATMApplicationview atmview;
	DepositView deposit;
	WithdrawelView withdraw;
	BalanceEnquiryView enquiry;
	ChangePinView changePin;
	public ATMApplicationViewModel(ATMApplicationview atmApplicationview) {
		this.atmview=atmApplicationview;
		this.deposit=new DepositView();
		this.withdraw=new WithdrawelView();
		this.enquiry=new BalanceEnquiryView();
		this.changePin=new ChangePinView();
	}
	public boolean formatValidate(CardDetails carddetail) {
		
		return InputValidater.validateCardDetails(carddetail);
	}
	public void datavalidate(CardDetails carddetail) {
		if(Repository.getInstance().validation(carddetail)) {
			atmview.printMenu();
			features(carddetail, atmview.userSelection());
		}else {
			atmview.errorMessage();
		}
		
	}
	private void features(CardDetails cardDetails,int userSelection) {
		switch(userSelection) {
		case 1->{
			deposit.getdepositAmount(cardDetails.getATMCardNumber());
		}
		case 2->{
			withdraw.getWithdrawAmount(cardDetails.getATMCardNumber());
		}
		case 3->{
			enquiry.getBalanceDetails(cardDetails.getATMCardNumber());
		}
		case 4->{
			changePin.changePinListener(cardDetails);
		}
		default ->{
			System.out.println("\n Thank you for Banking with us...\n");
		}
		}
		
	}

}
