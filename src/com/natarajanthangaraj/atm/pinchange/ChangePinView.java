package com.natarajanthangaraj.atm.pinchange;

import com.natarajanthangaraj.atm.dto.CardDetails;
import com.natarajanthangaraj.atm.validate.InputHandler;

public class ChangePinView {
	public ChangePinViewModel changepinviewmodel;

	public ChangePinView() {
		this.changepinviewmodel = new ChangePinViewModel(this);
	}
	public void changePinListener(CardDetails cardDetails) {
		System.out.print(" Enter your Account Number : ");
		cardDetails.setAccountNumber(InputHandler.getStringValue());
		System.out.print(" Enter new Pin Number  : ");
		long newPinNumber=InputHandler.getNumber();
		 if(changepinviewmodel.changePinNumber(cardDetails,newPinNumber)) {
			 System.out.println("\n"+"\u001B[32m"+" Pin Changed SuccessFully !!! "+"\u001B[32m"+"\n");
		 }else {
			 System.err.println(" Invalid account Number !!! ");
		 }
	}
}
