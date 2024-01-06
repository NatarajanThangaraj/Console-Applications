package com.natarajanthangaraj.rolehierarchy.ui.application;

import com.natarajanthangaraj.rolehierarchy.Utility;
import com.natarajanthangaraj.rolehierarchy.ui.addrole.AddRoleview;
import com.natarajanthangaraj.rolehierarchy.ui.delete.DeleteRoleView;
import com.natarajanthangaraj.rolehierarchy.ui.display.DisplayRolesView;

public class ApplicationViewModel {
	public ApplicationView applicationview;
	public AddRoleview addroleview;
	public DisplayRolesView displayRolesView;
    public DeleteRoleView deleteRoleView;
	public ApplicationViewModel(ApplicationView applicationView) {
		this.applicationview = applicationView;
		this.addroleview = new AddRoleview(this);
		this.displayRolesView = new DisplayRolesView();
		this.deleteRoleView=new DeleteRoleView();
	}

	// select the user preferred operation
	public void selectedOperation(int choice) {
		switch (choice) {
		case 1 -> {

			addroleview.addRole();
		}
		case 2 -> {
			addroleview.addRole();
		}
		case 3 -> {
			displayRolesView.showHierarchy("CEO");
		}
		case 4 -> {
			displayRolesView.showHierarchy(getStartingRole());
		}
		case 5 -> {
			deleteRoleView.deleteRole();
		}
		}

	}
	private String getStartingRole() {
		System.out.print("Enter the starting Role : ");
		return Utility.getStringInput();
	}

	public void successMessage() {
		applicationview.succssMessage();

	}

	public void errorMessage() {
		applicationview.errorMessage();
	}

}
