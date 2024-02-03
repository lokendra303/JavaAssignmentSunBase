<%@ page import="com.sunbase.javaassignment.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sunbase.javaassignment.DAO.CustomerDAOImpl" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.sunbase.javaassignment.DBConnect" %>
<%--
  Created by IntelliJ IDEA.
  User: Lokendra Kushwah
  Date: 1/31/2024
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>CustomerList</title>
    <%@include file="components/allCss.jsp" %>
</head>
<body>
<div>'
    <div style="text-align: center">
        <h2>Customer List</h2>
        <div>
            <c:if test="${not empty Msg}">
                <p style="color: green">${Msg}</p>
                <c:remove var="Msg" scope="session"></c:remove>
            </c:if>
            <c:if test="${not empty FailedMsg}">
                <p style="color: red">${FailedMsg}</p>
                <c:remove var="FailedMsg" scope="session"></c:remove>
            </c:if>
        </div>
    </div>
    <a type="button" class="btn btn-primary" href="sync">Sync</a>
    <div>
    <div class="col-md-6">
        <div style="margin: 10px">
            <a type="button" class="btn btn-primary" href="addCustomer.jsp">Add Customer</a>
            <label for="searchBy">Search By:</label>
            <select id="searchBy">
                <option value="FirstName">FirstName</option>
                <option value="LastName">LastName</option>
                <option value="City">City</option>
                <option value="Email">Email</option>
                <option value="Phone">Phone</option>
                <!-- Add more options based on your table columns -->
            </select>
            <input type="text" id="searchInput" placeholder="Search...">
<%--            <button type="submit"><i class="fa fa-search"></i></button>--%>
        </div>


    </div>
        <table class="table" id="dataTable">
            <thead>
            <tr>
                <th>FirstName</th>
                <th>LastName</th>
                <th>City</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Address</th>
                <th>State</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                CustomerDAOImpl dao = new CustomerDAOImpl(DBConnect.getConn());
                List<Customer> list =dao.getCustomerList();
                for (Customer b : list) {
            %>
            <tr>
                <td><%=b.getFirst_name()%></td>
                <td><%=b.getLast_name()%></td>
                <td><%=b.getCity()%></td>
                <td><%=b.getEmail()%></td>
                <td><%=b.getPhone()%></td>
                <td><%=b.getAddress()%></td>
                <td><%=b.getState()%></td>
                <td>
<%--                    <a href="editCustomer.jsp">Edit</a>--%>
                    <a href="editCustomer.jsp?uuid=<%=b.getUuid()%>" class="btn btn-small btn-primary">Edit</a>
                    <a href="./delete?uuid=<%=b.getUuid()%>" class="btn btn-small btn-danger">Delete</a>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

</div>
<%-- javascript code for search from table --%>
<script>
    document.getElementById('searchBy').addEventListener('change', filterTable);
    document.getElementById('searchInput').addEventListener('input', filterTable);

    function filterTable() {
        var input, filter, table, tr, td, i, columnIndex;

        input = document.getElementById("searchInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("dataTable");
        tr = table.getElementsByTagName("tr");
        columnIndex = document.getElementById("searchBy").selectedIndex;

        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[columnIndex];

            if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
</body>
</html>
