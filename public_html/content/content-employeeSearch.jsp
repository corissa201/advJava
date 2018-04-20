<div>
<h2>Employee Search Form</h2>

<form action="/java112/employeeSearch-servlet" method="GET">
    <input type="text" name="searchTerm" value="Enter search value"/><br />
    <p>Select a search type:</p>
    <input type="radio" name="searchType" value="firstName"/> First Name<br />
    <input type="radio" name="searchType" value="lastName"/> Last Name<br />
    <input type="radio" name="searchType" value="employeeId"/> Employee ID<br />
    <input type="submit" name="" value="Submit" />
</form>
</div>