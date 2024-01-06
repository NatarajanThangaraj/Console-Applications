package com.natarajanthangaraj.rolehierarchy.ui.application;

import com.natarajanthangaraj.rolehierarchy.Utility;
import com.natarajanthangaraj.rolehierarchy.ui.add.AddRoleview;
import com.natarajanthangaraj.rolehierarchy.ui.add.AddUser;
import com.natarajanthangaraj.rolehierarchy.ui.delete.DeleteRoleView;
import com.natarajanthangaraj.rolehierarchy.ui.display.DisplayRolesView;
import com.natarajanthangaraj.rolehierarchy.ui.display.DisplayUserView;

public class ApplicationViewModel {
	public ApplicationView applicationview;
	public AddRoleview addroleview;
	public DisplayRolesView displayRolesView;
	public DisplayUserView displayUsersView;
    public DeleteRoleView deleteRoleView;
    public AddUser addUser;
	public ApplicationViewModel(ApplicationView applicationView) {
		this.applicationview = applicationView;
		this.addroleview = new AddRoleview(this);
		this.addUser=new AddUser(this);
		this.displayRolesView = new DisplayRolesView();
		this.deleteRoleView=new DeleteRoleView();
		this.displayUsersView=new DisplayUserView();
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
			System.out.print("Enter the starting Role : ");
			displayRolesView.showHierarchy(Utility.getStringInput());
		}
		case 5 -> {
			deleteRoleView.deleteRole();
		}case 6->{
			addUser.addUser();
		}case 7->{
			displayUsersView.showUsers();
		}default->{
			System.err.println("Invalid select !!! ");
			applicationview.showFeatures();
			}
		}
		

	}

	public void successMessage() {
		applicationview.succssMessage();

	}

	public void errorMessage() {
		applicationview.errorMessage();
	}

}
