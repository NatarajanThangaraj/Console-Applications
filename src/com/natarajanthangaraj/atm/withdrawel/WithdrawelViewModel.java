package com.natarajanthangaraj.atm.withdrawel;

import com.natarajanthangaraj.atm.repository.Repository;

public class WithdrawelViewModel {
	WithdrawelView withdrawview;
	public WithdrawelViewModel(WithdrawelView withdrawelView) {
		this.withdrawview=withdrawelView;
	}
	public boolean possibleForWithdraw(String userId,Long Amount) {
		return Repository.getInstance().isWithdrawened(userId,Amount);
	}

}
