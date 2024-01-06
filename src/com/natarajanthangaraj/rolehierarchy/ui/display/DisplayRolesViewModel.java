package com.natarajanthangaraj.rolehierarchy.ui.display;

import java.util.Map;

import com.natarajanthangaraj.rolehierarchy.repository.Repository;

public class DisplayRolesViewModel {
	private DisplayRolesView displayView;

	public DisplayRolesViewModel(DisplayRolesView displayRolesView) {
		this.displayView = displayRolesView;
	}
	public Map<String,String> getHierarchy() {
		return Repository.getInstance().getRoleHierarchy();
	}
}
