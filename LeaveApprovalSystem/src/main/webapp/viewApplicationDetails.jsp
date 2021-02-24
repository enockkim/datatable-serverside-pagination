<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
   <head>
      <title>Leave Approver</title>
      <link rel="stylesheet"
         href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
         integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
         crossorigin="anonymous">
   </head>
         <div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <a class="navbar-brand" href="index">Home</a>
  <a class="nav navbar-nav navbar-right" href="leaveApproverLogout">Logout</a>
  <!-- <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div> -->
</nav>
</div>
   <body>
      <div class="container">
	      <h1>Leave Application</h1>
	      <form method="post" action="amend">
	            <div class="form-row">
		             <div class="form-group col-md-4">
		               <label for="applicationId">Employee ID</label>
		               <input type="text" class="form-control" id="employeeId" name="employeeId" value="${leaveApplicationDetails.employeeId}" readonly>
		            </div>
		             <div class="form-group col-md-4">
		               <label for="applicationId">Name</label>
		               <input type="text" class="form-control" value="${employeeData.employeeName}" readonly>
		            </div>
		             <div class="form-group col-md-4">
		               <label for="applicationId">Gender</label>
		               <input type="text" class="form-control" value="${employeeData.employeeGender}" readonly>
		            </div>
	            </div>
	            <div class="form-row">
		             <div class="form-group col-md-4">
		               <label for="applicationId">Title</label>
		               <input type="text" class="form-control" value="${employeeData.employeeTitle}" readonly>
		            </div>
		             <div class="form-group col-md-4">
		               <label for="applicationId">Department</label>
		               <input type="text" class="form-control" value="${employeeData.employeeDepartment}" readonly>
		            </div>	            
		             <div class="form-group col-md-4">
		               <label for="applicationId">Station</label>
		               <input type="text" class="form-control" value="${employeeData.employeeStation}" readonly>
		            </div>
	            </div>
	            <div class="form-row">
		           	<div class="form-group col-md-4">
		           		<label for="applicationId">Leave Days Balance</label>
		               <input type="text" class="form-control" id="leaveDaysBalance" name="leaveDaysBalance" value="${employeeData.leaveDaysBalance}" readonly>
		            </div>	            
		             <div class="form-group col-md-4">
		               <label for="applicationId">Employee Date of Joining</label>
		               <input type="text" class="form-control" value="${employeeData.dateOfJoining}" readonly>
		            </div>
	            </div>
	            <div class="form-row">
		            <div class="form-group col-md-4">
		               <label for="applicationId">Application ID</label>
		               <input type="text" class="form-control" id="applicationId" name="applicationId" value="${leaveApplicationDetails.applicationId}" readonly>
		            </div>
		            <div class="form-group col-md-4">
		               <label for="applicationId">Leave Type</label>
		               <input type="text" class="form-control" name="leaveType" value="${leaveApplicationDetails.leaveType}" readonly>
		            </div>
		           	<div class="form-group col-md-4">
		               <label for="applicationId">Days Requested</label>
		               <input type="text" class="form-control" name="daysRequested" value="${leaveApplicationDetails.daysRequested}" readonly>
		            </div>
	            </div>
	            <div class="form-row">
		            <div class="form-group col-md-3">
		               <label for="applicationId">Date of Application</label>
		               <input type="text" class="form-control" value="${leaveApplicationDetails.applicationDate}" readonly>
		            </div>
		            <div class="form-group col-md-3">
		               <label for="applicationId">Start Date</label>
		               <input type="text" class="form-control" value="${leaveApplicationDetails.startDate}" readonly>
		            </div>
		            <div class="form-group col-md-3">
		               <label for="applicationId">End Date</label>
		               <input type="text" class="form-control" value="${leaveApplicationDetails.endDate}" readonly>
		            </div>
		            <div class="form-group col-md-3">
		               <label for="applicationId">Application Status</label>
		               <input type="text" class="form-control" value="${leaveApplicationDetails.applicationStatus}" readonly>
		            </div>
	            </div>
	            <div class="form-group">
	               <label for="applicationId">Remarks</label>
	               <input type="text" class="form-control" id="remarks" name="remarks" value="${leaveApplicationDetails.remarks}">
	            </div>
	            <div class="form-check">
				  <input class="form-check-input" type="radio" name="action" value="1" checked>
				  <label class="form-check-label" for="1">
				    Approve
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input" type="radio" name="action" value="0">
				  <label class="form-check-label" for="0">
				    Deny
				  </label>
				</div>
	            <input type="submit" class="btn btn-outline-success" value="Sumbit"/>
	         </form>
      </div>
   </body>
</html>