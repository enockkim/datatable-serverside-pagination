package com.LeaveApprovalSystem.models;

public class Employee {
	

	private int employeeId;
	private String employeeName;
	private String employeeGender;
	private String employeeTitle;
	private String employeeDepartment;
	private String employeeGrade;
	private String employeeStation;
	private String employeeNumber;
	private String dateOfJoining;
	private int leaveDaysBalance;
//	private int pendingLeaveDays;
	
	public Employee() {
	}
	
	public Employee(int employeeId, String employeeName, String employeeGender, String employeeTitle,
			String employeeDepartment, String employeeGrade, String employeeStation, String employeeNumber,
			String dateOfJoining, int leaveDaysBalance) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.employeeTitle = employeeTitle;
		this.employeeDepartment = employeeDepartment;
		this.employeeGrade = employeeGrade;
		this.employeeStation = employeeStation;
		this.employeeNumber = employeeNumber;
		this.dateOfJoining = dateOfJoining;
//		this.leaveDaysBalance = leaveDaysBalance;
	}
	
	public Employee(int leaveDaysBalance, int employeeId) {
		super();
		this.leaveDaysBalance = leaveDaysBalance;
		this.employeeId = employeeId; 
	}

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	public String getEmployeeTitle() {
		return employeeTitle;
	}
	public void setEmployeeTitle(String employeeTitle) {
		this.employeeTitle = employeeTitle;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public String getEmployeeGrade() {
		return employeeGrade;
	}
	public void setEmployeeGrade(String employeeGrade) {
		this.employeeGrade = employeeGrade;
	}
	public String getEmployeeStation() {
		return employeeStation;
	}
	public void setEmployeeStation(String employeeStation) {
		this.employeeStation = employeeStation;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public int getLeaveDaysBalance() {
		return leaveDaysBalance;
	}
	public void setLeaveDaysBalance(int leaveDaysBalance) {
		this.leaveDaysBalance = leaveDaysBalance;
	}
//	public int getPendingLeaveDays() {
//		return pendingLeaveDays;
//	}
//	public void setPendingLeaveDays(int pendingLeaveDays) {
//		this.pendingLeaveDays = pendingLeaveDays;
//	}
//	
	

}
