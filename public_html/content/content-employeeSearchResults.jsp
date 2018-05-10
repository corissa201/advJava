<div>
<h2>Employee Search Results</h2>
<%--<h2>Array: ${searchResult.databaseQueryResult}</h2>
<h2>Term: ${searchResult.searchTerm}</h2>
<h2>Type: ${searchResult.searchType}</h2>--%>

<c:choose>
    <c:when test="${searchResult.queryFoundEmployee.equals(true)}">

        <table border="3px solid black" border-collapse="collapse">
        <tr bgcolor="blue" height="25">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>SSN</th>
            <th>Dept</th>
            <th>Room #</th>
            <th>Phone #</th>
        </tr>
        <c:forEach var="employee" items="${searchResult.databaseQueryResult}">
        <tr>
                <td>${employee.employeeId}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.socialSecurityNumber}</td>
                <td>${employee.department}</td>
                <td>${employee.roomNumber}</td>
                <td>${employee.phoneNumber}</td>
            </tr>
        </c:forEach>
        </table
    </c:when>
    <c:otherwise>
        <h3>No employee was found</h3>
    </c:otherwise>
</c:choose>


</div>