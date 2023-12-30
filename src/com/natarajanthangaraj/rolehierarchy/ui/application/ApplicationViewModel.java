package com.natarajanthangaraj.rolehierarchy.ui.application;

import java.util.LinkedList;

import com.natarajanthangaraj.rolehierarchy.repository.Repository;

public class ApplicationViewModel {
	public ApplicationView applicationview;

	public ApplicationViewModel(ApplicationView applicationView) {
		this.applicationview = applicationView;
	}

	public LinkedList<String> getRolehirearchy() {
		
		return Repository.getInstance().roleHierarchyList();
	}

	

}
