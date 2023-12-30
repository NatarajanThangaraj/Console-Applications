package com.natarajanthangaraj.rolehierarchy.dto;

public class Role {
	private String rootRole;
	private String role;
	private String subRole;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSubRole() {
		return subRole;
	}

	public void setSubRole(String subRole) {
		this.subRole = subRole;
	}

	public String getRootRole() {
		return rootRole;
	}

	public void setRootRole(String rootRole) {
		this.rootRole = rootRole;
	}
}
