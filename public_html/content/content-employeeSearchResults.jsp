<div>
<h2>Employee Search Results</h2>

<c:choose>
    <c:when test="${searchResult.databaseQueryResult!= null}">

        <table>
        <tr>
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