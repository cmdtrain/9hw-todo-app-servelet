package todo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import todo.storage.TaskStorage;

@WebServlet("/tasks-list")
public class TaskListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("tasks", TaskStorage.getAll());
        req.getRequestDispatcher("/tasks-list.jsp").forward(req, resp);
    }
}