package com.natarajanthangaraj.rolehierarchy.ui.application;

import java.util.LinkedList;

import com.natarajanthangaraj.rolehierarchy.Utility;


public class ApplicationView {
	public ApplicationViewModel applicationviewmodel;
	public ApplicationView() {
		this.applicationviewmodel = new ApplicationViewModel(this);
		
	}

	public void startApplication() {
		applicationviewmodel.toAddRole();
		operations();
		applicationviewmodel.selectedOperation(getChoice());
	}

	private int getChoice() {
		System.out.print(" Enter the choice : ");
		return Utility.getNumericValue();
	}

	private void operations() {
		System.out.println(" +---------------------+");
		System.out.println(" |  1.Add Sub Role     |");
		System.out.println(" +---------------------+");
		
	}

	public void showHirearchy() {
		LinkedList<String>list=applicationviewmodel.getRolehirearchy();
		for(String role : list) {
			System.out.println(role);
		}
	}
	

}
