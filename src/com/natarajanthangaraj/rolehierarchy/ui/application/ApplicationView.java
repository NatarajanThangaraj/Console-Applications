package com.natarajanthangaraj.rolehierarchy.ui.application;

import com.natarajanthangaraj.rolehierarchy.Utility;

public class ApplicationView {
	public ApplicationViewModel applicationviewmodel;

	public ApplicationView() {
		this.applicationviewmodel = new ApplicationViewModel(this);

	}

	public void startApplication() {
		showFeatures();
	}

	void showFeatures() {
		int select;
		while (true) {
			operations();
			select = getChoice();
			if (select == 0) {
				break;
			}
			applicationviewmodel.selectedOperation(select);
		}

	}

	private int getChoice() {
		System.out.print(" Enter the choice : ");
		return Utility.getNumericValue();
	}

	private void operations() {
		System.out.println(" +--------------------------+");
		System.out.println(" |  1. Add Root Role        |");
		System.out.println(" |  2. Add Sub Role         |");
		System.out.println(" |  3. Display Role         |");
		System.out.println(" |  4. Display Sub Role     |");
		System.out.println(" |  5. Delete Role          |");
		System.out.println(" |  6. Add User             |");
		System.out.println(" |  7. Display User         |");
		System.out.println(" |  8. Display SubUsers     |");
		System.out.println(" |  9. Delete  User         |");
		System.out.println(" |  0. Exit                 |");
		System.out.println(" +--------------------------+");

	}

	public void succssMessage() {
		System.out.println(Utility.color + " Operation Successed !!! " + "\u001B[0m");

	}

	public void errorMessage() {
		System.err.println(" The Data was already exists !");
	}

}
