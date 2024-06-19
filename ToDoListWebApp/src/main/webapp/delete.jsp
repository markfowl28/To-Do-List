<%--
  Created by IntelliJ IDEA.
  User: markf
  Date: 3/24/2024
  Delete Items HTML Page
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To Do List Application</title>
</head>
<body>
    <h1><%= "Delete Task" %>
    </h1>
    <form action="DeleteFromList" method="post">
        <table>
            <tr>
                <td>Enter Task:</td>
                <td><input type="text" name="entry" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
