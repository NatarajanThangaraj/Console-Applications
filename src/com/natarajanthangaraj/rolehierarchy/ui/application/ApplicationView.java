package com.natarajanthangaraj.rolehierarchy.ui.application;

import java.util.LinkedList;

import com.natarajanthangaraj.rolehierarchy.ui.addrole.AddRoleview;

public class ApplicationView {
	public ApplicationViewModel applicationviewmodel;
	public AddRoleview addroleview;;
	public ApplicationView() {
		this.applicationviewmodel = new ApplicationViewModel(this);
		this.addroleview=new AddRoleview(this);
	}

	public void startApplication() {
		addroleview.addRootRole();
	}

	public void showHirearchy() {
		LinkedList<String>list=applicationviewmodel.getRolehirearchy();
		for(String role : list) {
			System.out.println(role);
		}
	}
	

}
