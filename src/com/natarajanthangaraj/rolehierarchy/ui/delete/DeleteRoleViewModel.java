package com.natarajanthangaraj.rolehierarchy.ui.delete;

import com.natarajanthangaraj.rolehierarchy.repository.Repository;

public class DeleteRoleViewModel {
	private DeleteRoleView deleteRoleView;
	private DeleteUserView deleteuser;
	public DeleteRoleViewModel(DeleteRoleView deleteRoleView) {
		this.deleteRoleView = deleteRoleView;
	}

	public DeleteRoleViewModel(DeleteUserView deleteUserView) {
		this.deleteuser = deleteUserView;
	}

	public void deleteRoleInHierarchical(String deletingRole) {
		 Repository.getInstance().deleteRole(deletingRole);
	}
//	public void deleteUserInHierarchical(String deletingUser) {
//		 Repository.getInstance().deleteUser(deletingUser);
//	}
	

}
