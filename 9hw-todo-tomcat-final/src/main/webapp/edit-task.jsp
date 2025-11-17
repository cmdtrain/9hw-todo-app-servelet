<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="todo.model.Task" %>
<%
    Task task = (Task) request.getAttribute("task");
    String error = (String) request.getAttribute("error");
    String nameParam = (String) request.getAttribute("nameParam");
    String priorityParam = (String) request.getAttribute("priorityParam");

    String currentName = task != null ? task.getName() : "";
    String currentPriority = task != null ? task.getPriority().name() : "LOW";

    if (nameParam != null) {
        currentName = nameParam;
    }
    if (priorityParam != null) {
        currentPriority = priorityParam;
    }
%>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
<a href="home">Home</a> |
<a href="create-task">Add new Task</a> |
<a href="tasks-list">Show all Tasks</a>

<h1>Edit Task</h1>

<% if (error != null) { %>
<p style="color:red"><%= error %></p>
<% } %>

<% if (task != null) { %>
<form method="post" action="edit-task">
    <input type="hidden" name="id" value="<%= task.getId() %>">
    <p>
        Name:
        <input type="text" name="name" value="<%= currentName %>">
    </p>
    <p>
        Priority:
        <select name="priority">
            <option value="LOW" <%= "LOW".equals(currentPriority) ? "selected" : "" %>>Low</option>
            <option value="MEDIUM" <%= "MEDIUM".equals(currentPriority) ? "selected" : "" %>>Medium</option>
            <option value="HIGH" <%= "HIGH".equals(currentPriority) ? "selected" : "" %>>High</option>
        </select>
    </p>
    <p>
        <input type="submit" value="Save">
    </p>
</form>
<% } else { %>
<p>Task not found.</p>
<% } %>
</body>
</html>