<div>
<h2>Employee Search Results</h2>

<h3>${searchMessage}<h3>
<c:remove var="searchMessage"/>

<%--<c:if test="${noTermMessage.equals(null)}">--%>
<c:choose>
    <c:when test="${searchResult.queryFoundEmployee.equals(true)}">

        <table class="searchTable">
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
        <tr class="employeeTable">
                <td>${employee.employeeId}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.socialSecurityNumber}</td>
                <td>${employee.department}</td>
                <td>${employee.roomNumber}</td>
                <td>${employee.phoneNumber}</td>
            </tr>
        </c:forEach>
        </table>
    </c:when>

    <c:otherwise>
      <h3>${searchMessage}<h3>
      <c:remove var="searchMessage"/>
    </c:otherwise>
</c:choose>
<%--</c:if>--%>


</div>