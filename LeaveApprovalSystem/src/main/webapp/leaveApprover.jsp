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
      <h1>Pending Leave Applications</h1>
         <table class="table table-striped table-bordered">
            <caption>Above are summaries of each leave application. Click view to see more details and perform an action.</caption>
            <thead>
               <tr>
                  <th scope="col">Application ID</th>
                  <th scope="col">Employee ID</th>
                  <th scope="col">Leave Type</th>
                  <th scope="col">Days Requested</th>
                  <th scope="col">Application</th>
                  <th scope="col">Start Date</th>
                  <th scope="col">End Date</th>
                  <th scope="col">Remarks</th>
                  <th scope="col">Status</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${pendingLeaveApplications}" var="LeaveApplication">
                  <tr>
                     <td>
                        <c:out value="${LeaveApplication.applicationId}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.employeeId}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.leaveType}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.daysRequested}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.applicationDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.startDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.endDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.remarks}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.applicationStatus}" />
                     </td>
                     <td><a href="viewApplicationDetails?applicationId=${LeaveApplication.applicationId}&employeeId=${LeaveApplication.employeeId}"><button
                        class="btn btn-outline-danger" type="button">View</button></a></td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
      <div class="container">
      <h1>Approved Leave Applications</h1>
         <table class="table table-striped table-bordered">
            <caption>Above are summaries of each leave application. Click view to see more details and perform an action.</caption>
            <thead>
               <tr>
                  <th scope="col">Application ID</th>
                  <th scope="col">Employee ID</th>
                  <th scope="col">Leave Type</th>
                  <th scope="col">Days Requested</th>
                  <th scope="col">Application</th>
                  <th scope="col">Start Date</th>
                  <th scope="col">End Date</th>
                  <th scope="col">Remarks</th>
                  <th scope="col">Status</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${approvedLeaveApplications}" var="LeaveApplication">
                  <tr>
                     <td>
                        <c:out value="${LeaveApplication.applicationId}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.employeeId}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.leaveType}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.daysRequested}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.applicationDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.startDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.endDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.remarks}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.applicationStatus}" />
                     </td>
                     <td><a href="viewApplicationDetails?applicationId=${LeaveApplication.applicationId}&employeeId=${LeaveApplication.employeeId}"><button
                        class="btn btn-outline-danger" type="button">View</button></a></td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
      <div class="container">
      <h1>Denied Leave Applications</h1>
         <table class="table table-striped table-bordered">
            <caption>Above are summaries of each leave application. Click view to see more details and perform an action.</caption>
            <thead>
               <tr>
                  <th scope="col">Application ID</th>
                  <th scope="col">Employee ID</th>
                  <th scope="col">Leave Type</th>
                  <th scope="col">Days Requested</th>
                  <th scope="col">Application</th>
                  <th scope="col">Start Date</th>
                  <th scope="col">End Date</th>
                  <th scope="col">Remarks</th>
                  <th scope="col">Status</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${deniedLeaveApplications}" var="LeaveApplication">
                  <tr>
                     <td>
                        <c:out value="${LeaveApplication.applicationId}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.employeeId}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.leaveType}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.daysRequested}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.applicationDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.startDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.endDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.remarks}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.applicationStatus}" />
                     </td>
                     <td><a href="viewApplicationDetails?applicationId=${LeaveApplication.applicationId}&employeeId=${LeaveApplication.employeeId}"><button
                        class="btn btn-outline-danger" type="button">View</button></a></td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
   </body>
</html>