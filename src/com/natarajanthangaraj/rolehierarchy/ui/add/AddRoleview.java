package com.natarajanthangaraj.rolehierarchy.ui.add;


import com.natarajanthangaraj.rolehierarchy.Utility;
import com.natarajanthangaraj.rolehierarchy.dto.Role;
import com.natarajanthangaraj.rolehierarchy.ui.application.ApplicationViewModel;

public class AddRoleview {
	public AddRoleviewmodel addroleviewmodel;
	public ApplicationViewModel applicationviewmodel;
	
	public AddRoleview(ApplicationViewModel applicationViewModel2) {
		this.applicationviewmodel=applicationViewModel2;
		this.addroleviewmodel = new AddRoleviewmodel(this);
	}

	public void addRole(){
		Role role =new Role(); 
		// add condition if add root role
		role.setRole(getInputSubRole());
		role.setReportingRole(getInputReportingRole());
		if(addroleviewmodel.addRoleInRepositry(role)) {
			applicationviewmodel.successMessage();
		}else {
			applicationviewmodel.errorMessage();
		}
	}


	 String getInputSubRole() {
		System.out.print(" Enter  Role Name : ");
		String rootSubName = Utility.getStringInput();
		return rootSubName.toUpperCase();

	}

	String getInputReportingRole() {
		System.out.print(" Enter reporting to role Name : ");
		String reportingRoleName = Utility.getStringInput();
		return reportingRoleName.toUpperCase();
	}

	
}
