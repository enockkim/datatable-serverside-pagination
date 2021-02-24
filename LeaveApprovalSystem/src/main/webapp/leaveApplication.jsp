<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <title>Leave Application</title>
      <link rel="stylesheet"
         href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
         integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
         crossorigin="anonymous">
      <link rel="stylesheet",href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css">
      <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
      <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
      <script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
   </head>
   <div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="index">Home</a>
  <a class="nav navbar-nav navbar-right" href="employeeLogin">Logout</a>
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
         
         <br> <br>
         <form action="submit" method="post">
         <div class="form-row">
            <div class="form-group col-md-2">
       	      <label for="applicationId">Employee ID</label>
	          <input type="text" class="form-control" id="employeeId" name="employeeId" value="${employeeId}" readonly>
	        </div>
	        </div>
	        <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="leaveType">Leave Type</label>
		      <select id="leaveType" name="leaveType" class="form-control">
		        <option selected>Annual</option>
		        <option>Sick</option>
		        <option>Compassionate</option>
		        <option>Maternity</option>
		      </select>
		      <h6 style="color:red">${error}</h6>
		    </div>
            </div>
            <div class="form-row">
	            <div class="form-group col-md-4">
	               <label for="daysRequested">Days Requested</label>
	               <input type="text" class="form-control" id="daysRequested" name="daysRequested" >
	               <h6 style="color:red">${leaveError}</h6>
	            </div>
	            <div class="form-group col-md-4">
	               <label for="startDate">Start Date</label>
	               <input type="date" class="form-control" id="startDate" min="${todaysDate}" name="startDate" >
	            </div>
	            <div class="form-group col-md-4">
	               <label for="endDate">End Date</label>
	               <input type="date" class="form-control" min="${todaysDate}" id="endDate" name="endDate" >
	            </div>
            </div>
            <button type="submit" class="btn btn-outline-success">Submit</button>
         </form>
      </div>
   </body>
</html>