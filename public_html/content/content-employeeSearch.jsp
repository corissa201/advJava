<div>
<h2>Employee Search Form</h2>

<form action="/java112/searchResults-servlet" method="GET">
    Enter search value <input type="text" name="searchTerm" value=""/><br />
    <p>Select a search type:</p>
    <input type="radio" name="searchType" value="firstName" checked="checked"/> First Name<br />
    <input type="radio" name="searchType" value="lastName"/> Last Name<br />
    <input type="radio" name="searchType" value="employeeId"/> Employee ID<br />
    <input type="submit" name="" value="Submit" />
</form>
</div>