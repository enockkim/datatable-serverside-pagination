package com.LeaveApprovalSystem.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class EmployeeController {
	

	@Autowired
	LeaveApprovalSystemDao leaveApproverDao;
	
    private ModelAndView mv = new ModelAndView();
    private String todaysDate;
    private String error;
    private Calendar calender = Calendar.getInstance();
    
    @RequestMapping("/index")
    public ModelAndView goHome() {
    	mv.setViewName("index.jsp");
    	
    	return mv;
    }

    //Open employee home page and show table containing previously applied leaves
    @RequestMapping("/employeeHome")
    public ModelAndView getByEmployeeId(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	int employeeId = Integer.parseInt(request.getParameter("employeeId"));
    	System.out.println(employeeId);
        List <LeaveApplication> pendingEmployeeLeaveApplications = leaveApproverDao.getPendingByEmployeeId(employeeId);
        List <LeaveApplication> employeeLeaveApplications = leaveApproverDao.getByEmployeeId(employeeId);
        mv.setViewName("employeeHome.jsp");
        mv.addObject("pendingEmployeeLeaveApplications", pendingEmployeeLeaveApplications);
        mv.addObject("employeeLeaveApplications", employeeLeaveApplications);
        mv.addObject("employeeId", employeeId);

        return mv;
    }
    
    //Employee login
    @RequestMapping("/employeeLogin")
    public String employeeLogin() {
    	return "redirect:employeeIdCheck.jsp";
    }
    
    //Opens form for new leave application
	@RequestMapping("/apply")
	public ModelAndView openLeaveApplication(HttpServletRequest request, HttpServletResponse response) {
		error = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		todaysDate = (dtf.format(now));
		System.out.println(todaysDate);
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		mv.setViewName("leaveApplication.jsp");
		mv.addObject("employeeId", employeeId);
		mv.addObject("todaysDate", todaysDate);
		mv.addObject("error", error);
		mv.addObject("leaveError", error);
		
		return mv;
	}
	
	//Submits leave applications and saves to database
	@RequestMapping("/submit")
	public ModelAndView submitLeaveApplication(HttpServletRequest request, HttpServletResponse response) {
//	    int applicationId;
	    int employeeId = Integer.parseInt(request.getParameter("employeeId"));
	    String leaveType = request.getParameter("leaveType");
	    int daysRequested = Integer.parseInt(request.getParameter("daysRequested"));
	    String applicationDate = request.getParameter("applicationDate");
	    String startDate = request.getParameter("startDate");
	    String endDate = request.getParameter("endDate");
	    
	    boolean status = false;
	    
	    Employee employee = leaveApproverDao.getEmployeeData(employeeId);
	    String employeeGender = employee.getEmployeeGender();
	    int leaveDaysBalance = employee.getLeaveDaysBalance();
	    if (leaveType.equalsIgnoreCase("annual")) {
		    if (daysRequested > leaveDaysBalance) {
		    	error = "You do not qualify for the number of leave days requested.";
		    	mv.setViewName("leaveApplication.jsp");
		    	mv.addObject("leaveError", error);
		    	return mv;
		    }
	    }

//	    String employeeGender = leaveApproverDao.getEmployeeGender(employeeId);
	    if (leaveType.equalsIgnoreCase("maternity") && employeeGender.equalsIgnoreCase("male")) {
	    	error = "You do not qualify for maternity leave.";
	    	mv.setViewName("leaveApplication.jsp");
	    	mv.addObject("error", error);
	    	return mv;
	    }
	    
	    
	    List <LeaveApplication> leaveApplication = null;
	    
//	    int pendingLeaveDays = employee.getPendingLeaveDays() + daysRequested;
//	    boolean update_status = leaveApproverDao.updatePendingLeaveDays(new Employee(employeeId, pendingLeaveDays));
//	    System.out.println(update_status);
	    status = leaveApproverDao.submit(new LeaveApplication(employeeId, leaveType, daysRequested, applicationDate, startDate, endDate));
	    if (status == true) {
//	    	leaveApplication = leaveApproverDao.getAll();
	        mv.setViewName("employeeHome");
	        mv.addObject("leaveApplication", leaveApplication);
	        mv.addObject("employeeId", employeeId);
	        System.out.println("success");
	    } else {
//	    	leaveApplication = leaveApproverDao.getAll();
	        mv.setViewName("index.jsp");
	        mv.addObject("leaveApplication", leaveApplication);
	        System.out.println("fail");
	    }
	    return mv;
	}
	
	//Checks if employee id exists in database
	@RequestMapping("/employeeIdCheck")
	public ModelAndView employeeIdCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int status = leaveApproverDao.checkEmployeeId(employeeId);
        Employee employee = leaveApproverDao.getEmployeeData(employeeId);

        System.out.println(status);
        if (status == 1) {
        	mv.setViewName("/employeeHome");
        	mv.addObject("employeeId",employeeId);
        	mv.addObject("employee", employee);
        	System.out.println("valid employeeId");
        }else {
            String error = "The employee ID entered does not exist";
        	mv.setViewName("employeeIdCheck.jsp");
        	mv.addObject("error",error);
        	System.out.println("invalid employeeId");
        }
        
//        mv.addObject("pendingLeaveApplications", pendingLeaveApplications);

        return mv;
	}
    
	@RequestMapping("/downloadLeaveApplication")
    public void downloadLeaveApplication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int applicationId = Integer.parseInt(request.getParameter("applicationId"));
        List<LeaveApplication> leaveApplicationReport = leaveApproverDao.getLeaveApplicationReport(applicationId);
       System.out.println(leaveApplicationReport);
        try {
            final InputStream stream = this.getClass().getResourceAsStream("/application-report.jrxml");

            // Compile the Jasper report from .jrxml to .japser
            final JasperReport report = JasperCompileManager.compileReport(stream);

            // Fetching the employees from the data source.
            final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(leaveApplicationReport);

            // Adding the additional parameters to the pdf.
            final Map < String, Object > parameters = null;


            // Filling the report with the employee data and additional parameters information.
            final JasperPrint print = JasperFillManager.fillReport(report, parameters, source);

            //final String filePath = "C://Users//user//Documents//" + "Employee_report"+date.getDate()+date.getMonth()+date.getYear()+"_"+date.getHours()+"_"+date.getMinutes()+"_"+date.getSeconds()+".pdf";
            // Export the report to a PDF file.
            Integer month = calender.get(Calendar.MONTH);
            response.setContentType("application/x-download");
            response.addHeader("Content-disposition", "attachment; filename=" + "Employee_report" + calender.get(Calendar.DATE) + "-" + String.valueOf(month + 1) + "-" + calender.get(Calendar.YEAR) + ".pdf");
            OutputStream out = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(print, out);
            out.flush();
            out.close();



        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
