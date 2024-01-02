package com.natarajanthangaraj.rolehierarchy.dto;

public class Role {
	private String rootRole;
	private String subRole;
	private String reportingRole;


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

	public String getReportingRole() {
		return reportingRole;
	}

	public void setReportingRole(String reportingRole) {
		this.reportingRole = reportingRole;
	}
}
