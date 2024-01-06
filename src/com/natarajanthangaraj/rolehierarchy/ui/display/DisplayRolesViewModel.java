package com.natarajanthangaraj.rolehierarchy.ui.display;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import com.natarajanthangaraj.rolehierarchy.repository.Repository;

public class DisplayRolesViewModel {
	private DisplayRolesView displayView;
	private DisplayUserView displayuserview;
	Map<String, String> userMap=Repository.getInstance().getUserHierarchy();
	Map<String, String> roleMap;

	public DisplayRolesViewModel(DisplayRolesView displayRolesView) {
		this.displayView = displayRolesView;
	}

	public DisplayRolesViewModel(DisplayUserView displayUsersView) {
		this.displayuserview = displayUsersView;
	}

	public List<String> getRoleHierarchy(String startingFromThisRole) {
		roleMap = Repository.getInstance().getRoleHierarchy();
		Deque<String> queue = new LinkedList<String>();
		List<String> list = new LinkedList<>();
		String role;
		queue.add(startingFromThisRole);
		while (queue.size() != 0) {
			role = queue.pollFirst();
			list.add(role);
			for (Map.Entry<String, String> entry : roleMap.entrySet()) {
				if (entry.getValue().equals(role)) {
					queue.add(entry.getKey());
				}
			}
		}
		return list;
	}

	public List<String> getUserHierarchy(String User) {
		Deque<String> queue = new LinkedList<String>();
		List<String> list = new LinkedList<>();
		String role;
		queue.add(User);
		while (queue.size() != 0) {
			role = queue.pollFirst();
			list.add(role);
			for (Map.Entry<String, String> entry : userMap.entrySet()) {
				if (entry.getValue().equals(role)) {
					queue.add(entry.getKey());
				}
			}
		}
		return list;
	}

	public Map<String,List<String>> getSubUsers() {
		Map<String,List<String>>subUserMap=new LinkedHashMap<>();
		List<String>list=getRoleHierarchy("CEO");
		List<String>eachList;
		for(int i=0;i<list.size();i++) {
			eachList=new ArrayList<>();
			for(int j=i+1;j<list.size();j++) {
				eachList.add(getUser(list.get(j)));
			}
			subUserMap.put(getUser(list.get(i)), eachList);
		}
		return subUserMap;
		
	}

	private String getUser(String string) {
		for(Map.Entry<String,String>entry:userMap.entrySet()) {
			if(entry.getValue().equals(string)) {
				return entry.getKey();
			}
		}
		return "";
		
	}
}
