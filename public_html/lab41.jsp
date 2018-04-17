<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />

    <title>Form Data</title>
  </head>

  <body>
    <h4>A Sample Form</h4>

    <form action="/java112/lab41-servlet" method="GET">
      <input type="text" name="param1" value="First Name"/><br />
      <br />
       <input type="text" name="param2" value="Last Name" /><br />
      <br />
       <input type="submit" name="" value="Enter" />
    </form>
  </body>
</html>