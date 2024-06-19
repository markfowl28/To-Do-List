<%--
  Created by IntelliJ IDEA.
  User: markf
  Date: 3/24/2024
  Add Items HTML Page
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To Do List Application</title>
</head>
<body>
    <h1><%= "Add Task" %>
    </h1>
    <form action="AddToList" method="post">
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
