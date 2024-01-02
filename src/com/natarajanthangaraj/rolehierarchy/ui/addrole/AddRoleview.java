package com.natarajanthangaraj.rolehierarchy.ui.addrole;


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
	public void addRootRole(){
		Role role =new Role(); 
		role.setRootRole(getRootRole());
		addroleviewmodel.addRoleInRepositry(role);
	}
	public void addSubRole(){
		Role role =new Role(); 
		role.setSubRole(getInputSubRole());
		role.setReportingRole(getInputReportingRole());
		addroleviewmodel.addRoleInRepositry(role);
	}

	 String getRootRole() {
		System.out.print(" Enter root role name : ");
		String rootRoleName = Utility.getStringInput();
		return rootRoleName.toUpperCase();
	}

	 String getInputSubRole() {
		System.out.print(" Enter Sub Role Name : ");
		String rootSubName = Utility.getStringInput();
		return rootSubName.toUpperCase();

	}

	String getInputReportingRole() {
		System.out.print(" Enter reporting to role Name : ");
		String reportingRoleName = Utility.getStringInput();
		return reportingRoleName.toUpperCase();
	}
	public void display() {
		applicationviewmodel.requestToShowHierarchy();
	}
	
}
