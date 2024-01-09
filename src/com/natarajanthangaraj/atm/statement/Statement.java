package com.natarajanthangaraj.atm.statement;

import java.time.LocalDate;
import java.time.LocalTime;

import com.natarajanthangaraj.atm.dto.CardDetails;

public class Statement {
	public StatementViewModel stmtviewmodel;

	Statement() {
		this.stmtviewmodel = new StatementViewModel(this);
	}

	void getStatement(String action ,CardDetails card,long Amount) {
		LocalDate date=LocalDate.now();
		LocalTime time=LocalTime.now();
		System.out.println("\n*********************************\n");
		System.out.println(" !           CANARA BANK           ! ");
		System.out.println(" !  Date : "+date);
		System.out.println(" !  Time : "+time);
		System.out.println(" !  Account Number  : xxxx xxxx xxxx "+card.getAccountNumber().substring(13));
		System.out.println(" ! "+action +" Amount :  Rs."+Amount);
		System.out.println(" !  Balance  Amount :  Rs."+card.getAmount());
		System.out.println(" ! ----- THANK YOU FOR BANKING WITH US -----\n");
		System.out.println("********************************* \n");
	}
}
