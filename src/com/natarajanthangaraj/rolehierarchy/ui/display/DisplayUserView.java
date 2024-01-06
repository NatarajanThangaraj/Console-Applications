package com.natarajanthangaraj.rolehierarchy.ui.display;

import java.util.List;
import java.util.Map;

public class DisplayUserView {
	public DisplayRolesViewModel displayViewModel;
	
	public DisplayUserView() {
		this.displayViewModel = new DisplayRolesViewModel(this);
		 
	}
	public void showUsers() {
		for(Map.Entry<String,String>map:displayViewModel.userMap.entrySet()) {
			System.out.println(map.getKey()+" "+map.getValue());
		}
	}
	public void showHierarchy(String startingFromThisUser){
		for(Map.Entry<String,List<String>>map:displayViewModel.getSubUsers().entrySet()) {
			System.out.print(map.getKey()+" -> ");
			printSubUsers(map.getValue());
		}
	}
	void printSubUsers(List<String> list) {
		for(String each:list) {
			if(!each.equals(""))
			System.out.print(each+" , ");
		}
		System.out.println();
	}
	
}
