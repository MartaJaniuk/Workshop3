<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 09.01.2023
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="header.jsp"/>


            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika </a>
                </div>



                <table class = "table">
                    <thead>
                    <tr>
                        <th> Id </th>
                        <th> Nazwa użytkownika </th>
                        <th> Email </th>
                        <th> Akcja </th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
                        <td>${user.email}</td>
                        <td> akcja do zrobienia </td>
                    </tr>
                    </c:forEach>
                    <tbody>

                </table>






                <!-- Content Row -->
                <div class="row">

                </div>

                <!-- Content Row -->

                <div class="row">

                </div>

                <!-- Content Row -->
                <div class="row">

                    <!-- Content Column -->
                    <div class="col-lg-6 mb-4">


                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->


<jsp:include page="footer.jsp"/>



