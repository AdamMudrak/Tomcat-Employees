<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Employees List</title>
    <style>
        .greenButton {
            box-shadow: 0px 0px 15px 0px #3dc21b;
            background:linear-gradient(to bottom, #44c767 5%, #5cbf2a 100%);
            background-color:#44c767;
            border-radius:42px;
            border:3px solid #18ab29;
            display:inline-block;
            cursor:pointer;
            color:#ffffff;
            font-family:Arial;
            font-size:17px;
            padding:20px 50px;
            text-decoration:none;
            text-shadow:0px 1px 0px #2f6627;
        }
        .greenButton:hover {
            background:linear-gradient(to bottom, #5cbf2a 5%, #44c767 100%);
            background-color:#5cbf2a;
        }
        .greenButton:active {
            position:relative;
            top:1px;
        }
        .redButton {
            box-shadow: 0px 0px 15px 0px #ff0000;
            background:linear-gradient(to bottom, #ff0000 5%, #b50000 100%);
            background-color:#ff0000;
            border-radius:42px;
            border:3px solid #ff0044;
            display:inline-block;
            cursor:pointer;
            color:#ffffff;
            font-family:Arial;
            font-size:17px;
            padding:20px 50px;
            text-decoration:none;
            text-shadow:1px 0px 0px #000000;
            &:hover {
            background:linear-gradient(to bottom, #b50000 5%, #ff0000 100%);
            background-color:#b50000;
        }
         &:active {
            position:relative;
            top:1px;
        }
         }

         .yellowButton {
         	box-shadow: 0px 0px 15px 0px #ffff00;
         	background:linear-gradient(to bottom, #d9d320 5%, #ffcc00 100%);
         	background-color:#d9d320;
         	border-radius:42px;
         	border:3px solid #ffd900;
         	display:inline-block;
         	cursor:pointer;
         	color:#ffffff;
         	font-family:Arial;
         	font-size:17px;
         	padding:20px 50px;
         	text-decoration:none;
         	text-shadow:0px 1px 0px #000000;
         }
         .yellowButton:hover {
         	background:linear-gradient(to bottom, #ffcc00 5%, #d9d320 100%);
         	background-color:#ffcc00;
         }
         .yellowButton:active {
         	position:relative;
         	top:1px;
         }

         .purpleButton {
         	box-shadow: 0px 0px 15px 0px #ff00bf;
         	background:linear-gradient(to bottom, #d920d0 5%, #7300ff 100%);
         	background-color:#d920d0;
         	border-radius:42px;
         	border:3px solid #f700ff;
         	display:inline-block;
         	cursor:pointer;
         	color:#ffffff;
         	font-family:Arial;
         	font-size:17px;
         	padding:20px 50px;
         	text-decoration:none;
         	text-shadow:0px 1px 0px #000000;
         }
         .purpleButton:hover {
         	background:linear-gradient(to bottom, #7300ff 5%, #d920d0 100%);
         	background-color:#7300ff;
         }
         .purpleButton:active {
         	position:relative;
         	top:1px;
         }
    </style>
</head>
<body>
    <center>
        <h1>Employees list</h1>
        <h3>
        <!-- <a href="<%=request.getContextPath()%>/new">Add New Employee</a> -->
            <a href="<%=request.getContextPath()%>/new" class="greenButton">Add Employee</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/list" class="purpleButton">List Employees</a>
        </h3>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Employees</h2></caption>
            <tr>
                <th>ID</th>
                <th>first_name</th>
                <th>last_name</th>
                <th>position</th>
                <th>phone</th>
            </tr>
            <c:forEach var="employee" items="${listEmployees}">
                <tr>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.first_name}" /></td>
                    <td><c:out value="${employee.last_name}" /></td>
                    <td><c:out value="${employee.position}" /></td>
                    <td><c:out value="${employee.phone}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/edit?id=<c:out value='${employee.id}' />" class="yellowButton">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/delete?id=<c:out value='${employee.id}' />" class="redButton">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>