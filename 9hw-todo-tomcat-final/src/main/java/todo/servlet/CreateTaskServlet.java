package todo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import todo.model.Priority;
import todo.storage.TaskStorage;

@WebServlet("/create-task")
public class CreateTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String error = req.getParameter("error");
        String name = req.getParameter("name");
        String priority = req.getParameter("priority");

        if (error != null) {
            req.setAttribute("error", "Task with this name already exists!");
        }
        if (name != null) {
            req.setAttribute("name", name);
        }
        if (priority != null) {
            req.setAttribute("priority", priority);
        }

        req.getRequestDispatcher("/create-task.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter("name");
        String p = req.getParameter("priority");

        if (name == null || name.trim().isEmpty() || p == null) {
            resp.sendRedirect("create-task");
            return;
        }

        name = name.trim();
        Priority priority = Priority.valueOf(p);

        if (TaskStorage.add(name, priority) == null) {
            String url = "create-task?error=1&name="
                    + URLEncoder.encode(name, StandardCharsets.UTF_8)
                    + "&priority=" + priority.name();
            resp.sendRedirect(url);
        } else {
            resp.sendRedirect("tasks-list");
        }
    }
}