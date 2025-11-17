<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = (String) request.getAttribute("error");
    String name = (String) request.getAttribute("name");
    String priority = (String) request.getAttribute("priority");
%>
<html>
<head>
    <title>Create Task</title>
</head>
<body>
<a href="home">Home</a> |
<a href="create-task">Add new Task</a> |
<a href="tasks-list">Show all Tasks</a>

<h1>Create Task</h1>

<% if (error != null) { %>
<p style="color:red"><%= error %></p>
<% } %>

<form method="post" action="create-task">
    <p>
        Name:
        <input type="text" name="name" value="<%= name != null ? name : "" %>">
    </p>
    <p>
        Priority:
        <select name="priority">
            <option value="LOW" <%= "LOW".equals(priority) ? "selected" : "" %>>Low</option>
            <option value="MEDIUM" <%= "MEDIUM".equals(priority) ? "selected" : "" %>>Medium</option>
            <option value="HIGH" <%= "HIGH".equals(priority) ? "selected" : "" %>>High</option>
        </select>
    </p>
    <p>
        <input type="submit" value="Create">
        <input type="reset" value="Clear">
    </p>
</form>
</body>
</html>