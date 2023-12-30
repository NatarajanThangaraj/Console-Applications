package com.natarajanthangaraj.rolehierarchy.ui.addrole;

import com.natarajanthangaraj.rolehierarchy.Utility;
import com.natarajanthangaraj.rolehierarchy.dto.Role;
import com.natarajanthangaraj.rolehierarchy.ui.application.ApplicationView;

public class AddRoleview {
	public AddRoleviewmodel addroleviewmodel;
	public ApplicationView applicationview;
	public AddRoleview(ApplicationView applicationview) {
		this.applicationview= applicationview;
		this.addroleviewmodel = new AddRoleviewmodel(this);
	}
	public void addRootRole(){
		Role role =new Role(); 
		role.setRootRole(getRootRole());;
		addroleviewmodel.addRootRoleInRepositry(role);
	}

	 String getRootRole() {
		System.out.print(" Enter root role name : ");
		String rootRoleName = Utility.getStringInput();
		return rootRoleName;
	}

	 String getSubRole() {
		System.out.print(" Enter Sub Role Name : ");
		String rootSubName = Utility.getStringInput();
		return rootSubName;

	}

	String getReportingRole() {
		System.out.print(" Enter reporting to role Name : ");
		String reportingRoleName = Utility.getStringInput();
		return reportingRoleName;
	}
	public void display() {
		applicationview.showHirearchy();
	}
}
