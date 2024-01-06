package com.natarajanthangaraj.rolehierarchy.ui.add;

import com.natarajanthangaraj.rolehierarchy.Utility;
import com.natarajanthangaraj.rolehierarchy.dto.User;
import com.natarajanthangaraj.rolehierarchy.ui.application.ApplicationViewModel;

public class AddUser  {
	public AddRoleviewmodel addroleviewmodel;
	public ApplicationViewModel applicationviewmodel;

	public AddUser(ApplicationViewModel applicationViewModel) {
		applicationviewmodel=applicationViewModel;
		addroleviewmodel = new AddRoleviewmodel(this);
	}
	public void addUser(){
		User user=new User(); 
		// add condition if add root user
		user.setUserName(getUserName());
		user.setUserRole(getRoleName());
		if(addroleviewmodel.addUserInRepositry(user)) {
			applicationviewmodel.successMessage();
		}else {
			applicationviewmodel.errorMessage();
		}
	}
	String getUserName() {
		System.out.print(" Enter  User Name : ");
		String rootSubName = Utility.getStringInput();
		return rootSubName.toUpperCase();

	}
	String getRoleName() {
		System.out.print(" Enter  role Name : ");
		String reportingRoleName = Utility.getStringInput();
		return reportingRoleName.toUpperCase();
	}

}
