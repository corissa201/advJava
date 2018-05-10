<div>
<h2>Employee Search Results</h2>

                <h3>Test: ${searchResult.databaseQueryResult}</h3>
                   <h3>Term: ${searchResult.searchTerm}</h3>
                      <h3>Type: ${searchResult.searchType}</h3>

<%--<c:choose>
    <c:when test="${search!= null}">
        <c:forEach var="search" items="${search}">
            <tr>
                <td>${search.firstName}</td>
                <td>${search.lastName}</td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <h3>No employee was found</h3>
    </c:otherwise>
</c:choose>--%>


</div>