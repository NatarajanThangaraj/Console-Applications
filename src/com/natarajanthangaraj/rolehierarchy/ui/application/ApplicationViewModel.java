package com.natarajanthangaraj.rolehierarchy.ui.application;

import java.util.LinkedList;

import com.natarajanthangaraj.rolehierarchy.repository.Repository;
import com.natarajanthangaraj.rolehierarchy.ui.addrole.AddRoleview;

public class ApplicationViewModel {
	public ApplicationView applicationview;
	public AddRoleview addroleview;
	public ApplicationViewModel(ApplicationView applicationView) {
		this.applicationview = applicationView;
		this.addroleview=new AddRoleview(this);
	}
	// call from applicationview
	public LinkedList<String> getRolehirearchy() {
		return Repository.getInstance().roleHierarchyList();
	}
	// select the user prefered operation
	public void selectedOperation(int choice) {
		switch(choice) {
		case 1->{
		//addroleview.addSubRole();
		}
		}
		
	}

	public void toAddRole() {
		addroleview.addRootRole();
	}
	//call from other views
	public void requestToShowHierarchy() {
		applicationview.showHirearchy();
	}

	

}
