package com.natarajanthangaraj.rolehierarchy.ui.add;

import com.natarajanthangaraj.rolehierarchy.dto.Role;
import com.natarajanthangaraj.rolehierarchy.dto.User;
import com.natarajanthangaraj.rolehierarchy.repository.Repository;


public class AddRoleviewmodel {
 public AddRoleview addroleview;
 public AddUser adduserview;
	public AddRoleviewmodel(AddRoleview addRoleview) {
		addroleview=addRoleview;
	}
	public AddRoleviewmodel(AddUser adduser) {
		adduserview=adduser;
	}
	
	public boolean addRoleInRepositry(Role role) {
		return  Repository.getInstance().insertRole(role);
		
	}
	public boolean addUserInRepositry(User user) {
		return  Repository.getInstance().insertUser(user);
		
	}
	

}
