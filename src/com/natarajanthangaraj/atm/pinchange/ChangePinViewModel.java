package com.natarajanthangaraj.atm.pinchange;

import com.natarajanthangaraj.atm.dto.CardDetails;
import com.natarajanthangaraj.atm.repository.Repository;

public class ChangePinViewModel {
	public ChangePinView changepinview;

	public ChangePinViewModel(ChangePinView changePinView) {
		this.changepinview = changePinView;
	}

	public boolean changePinNumber(CardDetails cardDetails, long newPinNumber) {
		return Repository.getInstance().changePinNumber(cardDetails, newPinNumber);
	}

}
