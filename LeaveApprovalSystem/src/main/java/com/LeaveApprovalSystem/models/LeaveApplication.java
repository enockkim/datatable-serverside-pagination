package com.LeaveApprovalSystem.models;

public class LeaveApplication {
	
	private int applicationId;
	private int employeeId;
	private	String leaveType;
	private int daysRequested;
	private String applicationDate;
	private String startDate;
	private String endDate;
	private String remarks;
	private String applicationStatus;
	private Employee employee;
	
	

	public LeaveApplication(int applicationId, int employeeId, String leaveType, int daysRequested,
			String applicationDate, String startDate, String endDate, String remarks, String applicationStatus) {
		super();
		this.applicationId = applicationId;
		this.employeeId = employeeId;
		this.leaveType = leaveType;
		this.daysRequested = daysRequested;
		this.applicationDate = applicationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.remarks = remarks;
		this.applicationStatus = applicationStatus;
	}
	
	public LeaveApplication(String remarks, String applicationStatus, int applicationId) {
		super();
		this.remarks = remarks;
		this.applicationStatus = applicationStatus;
		this.applicationId = applicationId;
	}

	public LeaveApplication(int employeeId, String leaveType, int daysRequested, String applicationDate,
			String startDate, String endDate) {
		super();
		this.employeeId = employeeId;
		this.leaveType = leaveType;
		this.daysRequested = daysRequested;
		this.applicationDate = applicationDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public LeaveApplication() {
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public int getDaysRequested() {
		return daysRequested;
	}
	public void setDaysRequested(int daysRequested) {
		this.daysRequested = daysRequested;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	@Override
	public String toString() {
		return "LeaveApplication [applicationId=" + applicationId + ", employeeId=" + employeeId + ", leaveType="
				+ leaveType + ", daysRequested=" + daysRequested + ", applicationDate=" + applicationDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", remarks=" + remarks + ", applicationStatus="
				+ applicationStatus + ", employee=" +getEmployee() + "]";
	}
	
	

}
