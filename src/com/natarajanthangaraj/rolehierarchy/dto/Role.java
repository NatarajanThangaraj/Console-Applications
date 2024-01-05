package com.natarajanthangaraj.rolehierarchy.dto;

public class Role {

	private String Role;
	private String reportingRole;

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		this.Role = role;
	}

	public String getReportingRole() {
		return reportingRole;
	}

	public void setReportingRole(String reportingRole) {
		this.reportingRole = reportingRole;
	}
}
