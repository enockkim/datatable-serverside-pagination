package com.LeaveApprovalSystem.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.LeaveApprovalSystem.models.Employee;
import com.LeaveApprovalSystem.models.LeaveApplication;
import com.LeaveApprovalSystem.util.LeaveApprovalSystemUtil;
import com.LeaveApprovalSystem.util.LeaveApproverUtil;
import com.mysql.cj.Session;

public class LeaveApprovalSystemImpl implements LeaveApprovalSystemDao {

	public boolean submit(LeaveApplication leaveApplication) {
	    boolean status = false;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	        session.insert("LeaveApplication.submit", leaveApplication);
	        session.commit();
	        status = true;
	        session.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    // TODO: handle exception
	    return status;
	}

	public List<LeaveApplication> getPendingApplications() {
		    List <LeaveApplication> pendingLeaveApplications = null;
		    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
		    try {
		    	pendingLeaveApplications = session.selectList("LeaveApplication.getPendingApplications");
		        session.commit();
		        session.close();
	
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		return pendingLeaveApplications;
	}
	
	public List<LeaveApplication> getApprovedApplications() {
	    List <LeaveApplication> approvedLeaveApplications = null;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	approvedLeaveApplications = session.selectList("LeaveApplication.getApprovedApplications");
	        session.commit();
	        session.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return approvedLeaveApplications;
	}
	
	public List<LeaveApplication> getDeniedApplications() {
	    List <LeaveApplication> deniedLeaveApplications = null;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	deniedLeaveApplications = session.selectList("LeaveApplication.getDeniedApplications");
	        session.commit();
	        session.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return deniedLeaveApplications;
	}


	public List<LeaveApplication> getDeniedAndApprovedApplications() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LeaveApplication> getPendingByEmployeeId(int employeeId) {
	    List <LeaveApplication> employeeLeaveApplications = null;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	employeeLeaveApplications = session.selectList("LeaveApplication.getPendingByEmployeeId", employeeId);
	        session.commit();
	        session.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return employeeLeaveApplications;
	}
	
	public List<LeaveApplication> getByEmployeeId(int employeeId) {
	    List <LeaveApplication> employeeLeaveApplications = null;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	employeeLeaveApplications = session.selectList("LeaveApplication.getByEmployeeId", employeeId);
	        session.commit();
	        session.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return employeeLeaveApplications;
	}

	public boolean amend(LeaveApplication leaveApplication) {
        boolean status = false;
        SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
        try {
			session.update("LeaveApplication.amend", leaveApplication);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public String[] getLoginDetails(String username, String password) {
		String[] logInDetails = new String[2];
		logInDetails[0] = "Patrick";
		logInDetails[1] = "Patrick@123";
		
		return logInDetails;
	}

	public int checkEmployeeId(int employeeId) {	    
	    int status = 0;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	status = session.selectOne("Employee.checkEmployeeId", employeeId);
	        session.commit();
	        session.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return status;
	}
	
	public Employee getEmployeeData(int employeeId) {
		Employee employeeData = null;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	employeeData = session.selectOne("Employee.getEmployeeData", employeeId);
	        session.commit();
	        session.close();
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return employeeData;
	}

	public LeaveApplication getByApplicationId(int applicationId) {
		LeaveApplication employeeLeaveApplication = null;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	employeeLeaveApplication = session.selectOne("LeaveApplication.getByApplicationId", applicationId);
	        session.commit();
	        session.close();
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return employeeLeaveApplication;
	}
	
	public List<LeaveApplication> getByApplicationIdList(int applicationId) {
		List<LeaveApplication> employeeLeaveApplication = null;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	employeeLeaveApplication = session.selectList("LeaveApplication.getByApplicationId", applicationId);
	        session.commit();
	        session.close();
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return employeeLeaveApplication;
	}

	public boolean updateLeaveBalance(Employee employee) {
        boolean status = false;
        SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
        try {
			session.update("Employee.updateLeaveBalance", employee);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public List<LeaveApplication> getLeaveApplicationReport(int applicationId) {
		System.out.println("getLeaveApplicationReport running");
		List<LeaveApplication> leaveApplicationReport = null;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	leaveApplicationReport = session.selectList("LeaveApplication.getLeaveApplicationReport", applicationId);
	        session.commit();
	        session.close();
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return leaveApplicationReport;
	}

	public String getEmployeeGender(int employeeId) {
		String employeeGender = null;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	employeeGender = session.selectOne("Employee.getEmployeeGender", employeeId);
	        session.commit();
	        session.close();
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return employeeGender;
	}

	public boolean updatePendingLeaveDays(Employee employee) {
        boolean status = false;
        SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
        try {
			session.update("Employee.updatePendingLeaveDays", employee);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
