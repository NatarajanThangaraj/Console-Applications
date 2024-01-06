package com.natarajanthangaraj.atm.balanceenquary;

import org.json.simple.JSONObject;

import com.natarajanthangaraj.atm.repository.Repository;

public class BalanceEnquiryViewModel {
public BalanceEnquiryView enquiryview;
	public BalanceEnquiryViewModel(BalanceEnquiryView balanceEnquiryView) {
		this.enquiryview=balanceEnquiryView;
	}
	public void BalanceDetails(String userId) {
		 JSONObject accountDetails= Repository.getInstance().BalanceEnquiry(userId);
		 enquiryview.showDetails((Long)accountDetails.get("BankAccountNumber"),(Double)accountDetails.get("Amount"));
	}

}
