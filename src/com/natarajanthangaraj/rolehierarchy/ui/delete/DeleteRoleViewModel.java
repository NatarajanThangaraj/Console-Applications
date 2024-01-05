package com.natarajanthangaraj.rolehierarchy.ui.delete;

import com.natarajanthangaraj.rolehierarchy.repository.Repository;

public class DeleteRoleViewModel {
	private DeleteRoleView deleteRoleView;

	public DeleteRoleViewModel(DeleteRoleView deleteRoleView) {
		this.deleteRoleView = deleteRoleView;
	}

	public boolean deleteRoleInHierarchical(String deletingRole) {
		return Repository.getInstance().deleteRole(deletingRole);
	}

	

}
