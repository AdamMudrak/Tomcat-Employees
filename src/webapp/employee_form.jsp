<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Employees list</title>
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
            <a href="<%=request.getContextPath()%>/list"  class="purpleButton">List Employees</a>
        </h3>
    </center>
    <div align="center">
        <c:if test="${employee != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${employee == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h3>
                    <c:if test="${employee != null}">
                        Edit Employee
                    </c:if>
                    <c:if test="${employee == null}">
                        Add New Employee
                    </c:if>
                </h3>
            </caption>
                <c:if test="${employee != null}">
                    <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
                </c:if>
            <tr>
                <th>first_name: </th>
                <td>
                    <input type="text" name="first_name" size="45"
                            value="<c:out value='${employee.first_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>last_name: </th>
                <td>
                    <input type="text" name="last_name" size="45"
                            value="<c:out value='${employee.last_name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>position: </th>
                <td>
                    <input type="text" name="position" size="45"
                            value="<c:out value='${employee.position}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>phone: </th>
                <td>
                   <input type="phone" name="phone" size="45"
                             value="<c:out value='${employee.phone}' />"
                   />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <form action="<%=request.getContextPath()%>/insert">
                        <input type="submit" value="Save" />
                    </form>
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>