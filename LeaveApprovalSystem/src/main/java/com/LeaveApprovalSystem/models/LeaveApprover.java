package com.LeaveApprovalSystem.models;

public class LeaveApprover {
	
	private int leaveApproverId;
	private String leaveApproverName;
	private String leaveApproverTitle;
	
	
	public LeaveApprover(int leaveApproverId, String leaveApproverName, String leaveApproverTitle) {
		super();
		this.leaveApproverId = leaveApproverId;
		this.leaveApproverName = leaveApproverName;
		this.leaveApproverTitle = leaveApproverTitle;
	}
	
	public int getLeaveApproverId() {
		return leaveApproverId;
	}
	public void setLeaveApproverId(int leaveApproverId) {
		this.leaveApproverId = leaveApproverId;
	}
	public String getLeaveApproverName() {
		return leaveApproverName;
	}
	public void setLeaveApproverName(String leaveApproverName) {
		this.leaveApproverName = leaveApproverName;
	}
	public String getLeaveApproverTitle() {
		return leaveApproverTitle;
	}
	public void setLeaveApproverTitle(String leaveApproverTitle) {
		this.leaveApproverTitle = leaveApproverTitle;
	}
	
	

}
