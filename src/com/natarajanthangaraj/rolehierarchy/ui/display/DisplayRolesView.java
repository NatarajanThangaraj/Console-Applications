package com.natarajanthangaraj.rolehierarchy.ui.display;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DisplayRolesView {
	public DisplayRolesViewModel displayViewModel;

	public DisplayRolesView() {
		this.displayViewModel = new DisplayRolesViewModel(this);
	}

	public void showHierarchy(String startingFromThisRole) {
		Map<String, String> map = displayViewModel.getHierarchy();
		Deque<String> queue = new LinkedList<String>();
		List<String> list = new LinkedList<>();
		String role;
		queue.add(startingFromThisRole);
		while (queue.size() != 0) {
			role = queue.pollFirst();
			list.add(role);
			for (Map.Entry<String, String> entry : map.entrySet()) {
				if (entry.getValue().equals(role)) {
					queue.add(entry.getKey());
				}
			}
		}
		System.out.println(list);
	}
}
