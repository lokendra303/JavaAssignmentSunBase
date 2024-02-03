
<%--
  Created by IntelliJ IDEA.
  User: Lokendra Kushwah
  Date: 1/31/2024
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add New_Customer</title>
  <%@include file="components/allCss.jsp" %>
</head>
<body>
<div class="container p-2">
  <div class="row">
    <div class="col-md-6 offset-md-3">
      <div class="card">
        <div class="card-body">
          <div class="row">
            <form autocomplete="off" class="row g-3" action="./newCustomer" method="post">
              <h4 class="text-center">Add New Customer</h4>
              <div style="text-align: center">
                <c:if test="${not empty Msg}">
                  <p style="color: green">${Msg}</p>
                  <c:remove var="Msg" scope="session"></c:remove>
                </c:if>
                <c:if test="${not empty Failed}">
                  <p style="color: red">${Failed}</p>
                  <c:remove var="Failed" scope="session"></c:remove>
                </c:if>
              </div>
              <div class="col-md-6">
                <label class="form-label">First Name</label>
                <input type="text" class="form-control" required="required" name="fname">
                <label  class="form-label">Street</label>
                <input autocomplete="false" type="text" class="form-control" required="required"
                       name="street" >
              </div>
              <div class="col-md-6">
                <label class="form-label">Last Name</label>
                <input type="text" class="form-control"  required="required" name="lname">
                <label  class="form-label">Address</label>
                <input autocomplete="false" type="text" class="form-control" required="required"
                       name="address" >
              </div>

              <div class="col-md-6">
                <label class="form-label">City</label>
                <input type="text" class="form-control" required="required" name="city">
                <label  class="form-label">Email</label>
                <input autocomplete="false" type="email" class="form-control" required="required"
                       name="email" >
              </div>
              <div class="col-md-6">
                <label class="form-label">State</label>
                <input type="text" class="form-control" required="required" name="state">
                <label  class="form-label">Phone</label>
                <input autocomplete="false" type="text" class="form-control" required="required"
                       name="phone" >
              </div>
              <div class="col-12 text-center">
                <button type="submit" class="btn btn-primary">AddCustomer</button>
              </div>
            </form>
          </div>
        </div>

      </div>

    </div>

  </div>
</div>

</body>
</html>
