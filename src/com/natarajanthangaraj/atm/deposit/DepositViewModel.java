package com.natarajanthangaraj.atm.deposit;

import com.natarajanthangaraj.atm.repository.Repository;

public class DepositViewModel {
	DepositView depositview;
	
	public DepositViewModel(DepositView depositView2) {
		this.depositview = depositView2;
	}

	public boolean depositAmount(String userId,long amount) {
		Repository.getInstance().isDeposited(userId,amount);
		return true;
	}
	

}
