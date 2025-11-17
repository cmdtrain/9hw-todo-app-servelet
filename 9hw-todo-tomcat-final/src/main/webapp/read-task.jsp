<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="todo.model.Task" %>
<%
    Task task = (Task) request.getAttribute("task");
%>
<html>
<head>
    <title>Task details</title>
</head>
<body>
<a href="home">Home</a> |
<a href="create-task">Add new Task</a> |
<a href="tasks-list">Show all Tasks</a>

<h1>Task details</h1>

<% if (task != null) { %>
<p>Name: <%= task.getName() %></p>
<p>Priority: <%= task.getPriority() %></p>
<% } else { %>
<p>Task not found.</p>
<% } %>
</body>
</html>