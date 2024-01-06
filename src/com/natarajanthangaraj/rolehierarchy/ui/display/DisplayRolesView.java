package com.natarajanthangaraj.rolehierarchy.ui.display;


public class DisplayRolesView {
	public DisplayRolesViewModel displayViewModel;

	public DisplayRolesView() {
		this.displayViewModel = new DisplayRolesViewModel(this);
	}

	public void showHierarchy(String startingFromThisRole) {
		System.out.println(displayViewModel.getRoleHierarchy(startingFromThisRole));
		
		
	}
}
