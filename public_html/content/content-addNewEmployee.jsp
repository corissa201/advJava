<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content">
<h2>Add New Employee</h2>

<h3>${project4Message}<h3>
<c:remove var="project4Message"/>

<form action="/java112/employeeAddAction-servlet" method="post">
    First Name <input type="text" name="firstName"/><br />
    Last Name <input type="text" name="lastName"/> <br />
    Social Security Number <input type="text" name="socialSecurityNumber"/> <br />
    Department <input type="text" name="department"/> <br />
    Room Number <input type="text" name="roomNumber"/> <br />
    Phone Number <input type="text" name="phoneNumber"/> <br />
    <input type="submit" name="" value="Submit" />
</form>
</div>