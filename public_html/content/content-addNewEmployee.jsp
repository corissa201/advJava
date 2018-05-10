<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content">
<h2>Add New Employee</h2>

<h3>${project4message}<h3>
<c:remove var="project4message"/>

<form action="/java112/employeeAddAction-servlet" method="post">
    <label>First Name</label> <input type="text" name="firstName"/><br />
    <label>Last Name</label> <input type="text" name="lastName"/> <br />
    <label>Social Security Number</label> <input type="text" name="socialSecurityNumber"/> <br />
    <label>Department</label> <input type="text" name="department"/> <br />
    <label>Room Number</label> <input type="text" name="roomNumber"/> <br />
    <label>Phone Number</label> <input type="text" name="phoneNumber"/> <br />
    <input type="submit" name="" value="Submit" />
</form>


</div>