package com.natarajanthangaraj.rolehierarchy.ui.addrole;

import com.natarajanthangaraj.rolehierarchy.dto.Role;
import com.natarajanthangaraj.rolehierarchy.repository.Repository;


public class AddRoleviewmodel {
 public AddRoleview addroleview;
	public AddRoleviewmodel(AddRoleview addRoleview) {
		addroleview=addRoleview;
	}
	public boolean addRoleInRepositry(Role role) {
		return  Repository.getInstance().insertRole(role);
		
	}
	

}
