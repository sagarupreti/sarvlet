<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Students</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Contact No</th>
                <th>Date</th>
                <th>Status</th>
            </tr>
            <c:forEach var="s" items="${requestScope.students}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.firstName} ${s.lastName}</td>
                    <td>${s.email}</td>
                    <td>${s.contactNo}</td>
                    <td>${s.addedDate}</td>
                    <td>${s.status}</td>
                </tr>
            </c:forEach>
        </table>
        
        <div>
            <h1>Student Detail</h1>
            <h2>Name:${requestScope.student.firstName} ${requestScope.student.lastName}</h2>
        </div>
        
    </body>
</html>
   