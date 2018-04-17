<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />

    <title>Employee Search</title>
  </head>

  <body>
    <h4>Employee Search Form</h4>

    <form action="/java112/employeeSearch-servlet" method="GET">
      <input type="text" name="searchTerm" value=""/><br />
       <input type="radio" name="searchType" value="firstName"/> First Name<br />
       <input type="radio" name="searchType" value="lastName"/> Last Name<br />
       <input type="radio" name="searchType" value="employeeId"/> Employee ID<br />
       <input type="submit" name="" value="Submit" />
    </form>
  </body>
</html>