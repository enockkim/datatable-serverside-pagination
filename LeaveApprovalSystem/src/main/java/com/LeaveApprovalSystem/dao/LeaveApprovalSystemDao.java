package com.LeaveApprovalSystem.dao;

import java.util.List;

import com.LeaveApprovalSystem.models.Employee;
import com.LeaveApprovalSystem.models.LeaveApplication;


public interface LeaveApprovalSystemDao {
	
	//Submit leave application
	public boolean submit(LeaveApplication leaveApplication);

	//Get pending leave applications
	public List<LeaveApplication> getPendingApplications();
	
	//Get approved leave applications
	public List<LeaveApplication> getApprovedApplications();
	
	//Get approved leave applications
	public List<LeaveApplication> getDeniedApplications();
	
	//Get leave application report data
	public List<LeaveApplication> getLeaveApplicationReport(int applicationId);
	
	//Get denied and approved leave applications
	public List<LeaveApplication> getDeniedAndApprovedApplications();
	
	//Get pending leave applications according to Employee ID
	public List<LeaveApplication> getPendingByEmployeeId(int employeeId);
	
	//Get approved and denied leave applications according to Employee ID
	public List<LeaveApplication> getByEmployeeId(int employeeId);
	
	//Get employee gender for validation
	public String getEmployeeGender(int employeeId);
	
	//Get employee gender for validation
//	public boolean updatePendingLeaveDays(Employee employee);
	
	//Check existence of employee
	public int checkEmployeeId(int employeeId);
	
	//Amend leave application
	public boolean amend(LeaveApplication leaveApplication);
	
	//Reduce leave balance
	public boolean updateLeaveBalance(Employee employee);
	
	//Get employee details by Employee ID to auto fill leave application form
	public Employee getEmployeeData(int employeeId);
	
	//Get username and password of leave approver
	public String[] getLoginDetails(String username, String password);
	
	//Get application by application ID to object
	public LeaveApplication getByApplicationId(int applicationId);
	
	//Get application by application ID to list
	public List<LeaveApplication> getByApplicationIdList(int applicationId);
}
