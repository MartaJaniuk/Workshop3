<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 09.01.2023
  Time: 22:33
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
        <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników</a>
    </div>


    <h6 class="m-0 font-weight-bold text-primary">Edycja użytkownika<br> <br> </h6>

    <form method="post">
        <input type="hidden" name="id" value=${user.id}/>
        Nazwa: <input type="text" name="name" class="form-control" value="${user.userName}"/>
        Email: <input type="text" name="email" class="form-control" value="${user.email}" />
        Hasło: <input type="text" name="password" class="form-control" value="${user.password}" />
        </br>
        <button type="submit" class="btn btn-primary">Edytuj</button>
    </form>

</div>
<!-- /.container-fluid -->


<jsp:include page="footer.jsp"/>

