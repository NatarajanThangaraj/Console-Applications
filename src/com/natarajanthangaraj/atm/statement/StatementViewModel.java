package com.natarajanthangaraj.atm.statement;

import com.natarajanthangaraj.atm.dto.CardDetails;
import com.natarajanthangaraj.atm.repository.Repository;

public class StatementViewModel {
	public Statement stmt;

	StatementViewModel(Statement stmt) {
		this.stmt = stmt;
	}

	CardDetails getStatementDetails(String userID) {
		return Repository.getInstance().getStatement(userID);
	}
}
