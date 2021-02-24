package com.LeaveApprovalSystem.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.LeaveApprovalSystem.dao.LeaveApprovalSystemDao;
import com.LeaveApprovalSystem.models.Employee;
//import com.LeaveApprovalSystem.models.Employee;
import com.LeaveApprovalSystem.models.LeaveApplication;

@Controller
public class LeaveApproverController {
	
	@Autowired
	LeaveApprovalSystemDao leaveApproverDao;
	
    private ModelAndView mv = new ModelAndView();

    
    
    //Maps "/leaveApprover" url and gets applications that are pending displaying them on a table in the view
    @RequestMapping("/leaveApprover")
    public ModelAndView getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession leaveApproverSession = request.getSession(false);
    	String logged_in = (String) leaveApproverSession.getAttribute("logged_in");
    	if (logged_in == null) {
    		mv.setViewName("/leaveApproverLogin");
    		return mv;
    	}else if (logged_in.equals("true")){

        	List <LeaveApplication> deniedLeaveApplications = leaveApproverDao.getDeniedApplications();
        	List <LeaveApplication> pendingLeaveApplications = leaveApproverDao.getPendingApplications();
            List <LeaveApplication> approvedLeaveApplications = leaveApproverDao.getApprovedApplications();
            mv.setViewName("leaveApprover.jsp");
            mv.addObject("pendingLeaveApplications", pendingLeaveApplications);
            mv.addObject("approvedLeaveApplications", approvedLeaveApplications);
            mv.addObject("deniedLeaveApplications", deniedLeaveApplications);

            return mv;
    	} else {
    		mv.setViewName("/leaveApproverLogin");
    		return mv;
    	}

    }
    
    //Leave approver logout
    @RequestMapping("/leaveApproverLogout")
    public ModelAndView leaveApproverLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession leaveApproverSession = request.getSession(false);
    	leaveApproverSession.setAttribute("logged_in", "false");
    	leaveApproverSession.invalidate();
//    	leaveApproverSession = null;
    	mv.setViewName("/leaveApproverLogin");
    	return mv;
    }
    
    //Get leave application details for approver to view and deny/approve
    @RequestMapping("/viewApplicationDetails")
    public ModelAndView getByApplicationId(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	HttpSession leaveApproverSession = request.getSession(false);
    	String logged_in = (String) leaveApproverSession.getAttribute("logged_in");
    	if (logged_in == null) {
    		mv.setViewName("/leaveApproverLogin");
    		return mv;
    	}else if (logged_in.equals("true")){
	    	int applicationId = Integer.parseInt(request.getParameter("applicationId"));
	    	int employeeId = Integer.parseInt(request.getParameter("employeeId"));
	        LeaveApplication leaveApplicationDetails = leaveApproverDao.getByApplicationId(applicationId);
	        Employee employeeData = leaveApproverDao.getEmployeeData(employeeId);
	        mv.setViewName("viewApplicationDetails.jsp");
	        mv.addObject("leaveApplicationDetails", leaveApplicationDetails);
	        mv.addObject("employeeData", employeeData);
	
	        return mv;
    	} else {
    		mv.setViewName("/leaveApproverLogin");
    		return mv;
    	}

    }
     
    //Leave approver login
    @RequestMapping("/leaveApproverLogin")
    public String leaveApproverLogin() {
    	return "redirect:leaveApproverLogin.jsp";
    }

    //Validates leave approver login details	
	@RequestMapping("/login")
	public ModelAndView leaveApproverValidation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String[] logInDetails = leaveApproverDao.getLoginDetails(username, password);
		
//		return mv;
		//Username and password validation
		if (username.equals(logInDetails[0]) && password.equals(logInDetails[1])) {			
	        mv.setViewName("/leaveApprover");
	        HttpSession leaveApproverSession = request.getSession();
	        leaveApproverSession.setAttribute("logged_in", "true");
//			return "redirect:/leaveApprover";
		}else {
			String error = "Incorrect username or password.";
	        mv.setViewName("leaveApproverLogin.jsp");
	        mv.addObject("error", error);
//			return "redirect:/leaveApproverLogin";			
		}
		return mv;
	}
	
	//Approve or deny application and reduce leave days balance where applicable
	@RequestMapping("/amend")
	public ModelAndView submit(HttpServletRequest request, HttpServletResponse response){
    	HttpSession leaveApproverSession = request.getSession(false);
    	String logged_in = (String) leaveApproverSession.getAttribute("logged_in");
    	if (logged_in == null) {
    		mv.setViewName("/leaveApproverLogin");
    		return mv;
    	}else if (logged_in.equals("true")){
			int applicationId = Integer.parseInt(request.getParameter("applicationId"));
			String action = request.getParameter("action");
			int daysRequested = Integer.parseInt(request.getParameter("daysRequested"));
			String leaveType = request.getParameter("leaveType");
			String remark = request.getParameter("remarks");
			int employeeId = Integer.parseInt(request.getParameter("employeeId"));
			int leaveDaysBalance = Integer.parseInt(request.getParameter("leaveDaysBalance"));
			
	        String status;
	        if(action.equals("1")) {
	        	status = "approved";
	        	if(leaveType.equalsIgnoreCase("annual")) {
	        		leaveDaysBalance = leaveDaysBalance - daysRequested;
	        		System.out.println(leaveDaysBalance);
	        		boolean sql_status = leaveApproverDao.updateLeaveBalance(new Employee(leaveDaysBalance, employeeId));
	        		System.out.println(sql_status);
	        	}
	        }else {
	        	status = "denied";
	        }
	        
	        boolean sql_status = false;
	        sql_status = leaveApproverDao.amend(new LeaveApplication(remark, status, applicationId));
			if (sql_status == true) {
			    System.out.println("success");
			} else {
			    System.out.println("fail");
			}
			mv.setViewName("/leaveApprover");
			return mv;
		} else {
			mv.setViewName("/leaveApproverLogin");
			return mv;
		}
	}
}
