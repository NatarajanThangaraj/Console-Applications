package com.natarajanthangaraj.rolehierarchy.ui.delete;

import com.natarajanthangaraj.rolehierarchy.Utility;

public class DeleteRoleView {
public DeleteRoleViewModel deleteRoleViewModel;
   public DeleteRoleView(){
	this.deleteRoleViewModel=new DeleteRoleViewModel(this);
}
public void deleteRole() {
	 deleteRoleViewModel.deleteRoleInHierarchical(getDeletingRole());
}
private String getDeletingRole() {
	System.out.print("Enter Role u want to Delete : ");
	return Utility.getStringInput();
}
}
