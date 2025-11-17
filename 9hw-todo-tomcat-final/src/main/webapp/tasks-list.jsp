<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="todo.model.Task" %>
<%
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
%>
<html>
<head>
    <title>Tasks List</title>
</head>
<body>
<a href="home">Home</a> |
<a href="create-task">Add new Task</a> |
<a href="tasks-list">Show all Tasks</a>

<h1>List of Tasks</h1>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>No.</th>
        <th>Name</th>
        <th>Priority</th>
        <th>Operations</th>
    </tr>
    <%
        if (tasks != null) {
            int index = 1;
            for (Task t : tasks) {
    %>
    <tr>
        <td><%= index++ %></td>
        <td><%= t.getName() %></td>
        <td><%= t.getPriority() %></td>
        <td>
            <a href="read-task?id=<%= t.getId() %>">Read</a>
            <a href="edit-task?id=<%= t.getId() %>">Edit</a>
            <a href="delete-task?id=<%= t.getId() %>">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>