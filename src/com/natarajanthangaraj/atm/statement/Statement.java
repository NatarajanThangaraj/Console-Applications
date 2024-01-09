package com.natarajanthangaraj.atm.statement;

import java.time.LocalDate;
import java.time.LocalTime;

import com.natarajanthangaraj.atm.dto.CardDetails;

public class Statement {
	public StatementViewModel stmtviewmodel;

	public Statement() {
		this.stmtviewmodel = new StatementViewModel(this);
	}

	public void getStatement(String action, String userID, long Amount) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		CardDetails card = stmtviewmodel.getStatementDetails(userID);
		System.out.println("\n\t\t **************************************\n");
		System.out.println(" \t\t!           CANARA BANK                ! \n");
		System.out.println(" \t\t!  Date : " + date + "                   !");
		System.out.println(" \t\t!  Time : " + time + "           !");
		System.out.println(" \t\t!  Account Number  : xxxx xxxx " + card.getAccountNumber().substring(9) + "    !");
		System.out.println(" \t\t! " + action + " Amount :  Rs." + Amount + "             !");
		System.out.println(" \t\t!  Total  Amount :  Rs." + card.getAmount() + "         !\n");
		System.out.println(" \t\t! ---  THANK YOU FOR BANKING WITH US --!");
		System.out.println(" \t\t *************************************** \n");
	}
}
