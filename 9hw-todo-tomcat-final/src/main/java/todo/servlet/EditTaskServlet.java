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

@WebServlet("/edit-task")
public class EditTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            req.setAttribute("task", TaskStorage.findById(id));
        }

        String error = req.getParameter("error");
        if (error != null) {
            req.setAttribute("error", "Task with this name already exists!");
        }

        String name = req.getParameter("name");
        String priority = req.getParameter("priority");
        if (name != null) {
            req.setAttribute("nameParam", name);
        }
        if (priority != null) {
            req.setAttribute("priorityParam", priority);
        }

        req.getRequestDispatcher("/edit-task.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String idParam = req.getParameter("id");
        String name = req.getParameter("name");
        String p = req.getParameter("priority");

        if (idParam == null || name == null || name.trim().isEmpty() || p == null) {
            resp.sendRedirect("tasks-list");
            return;
        }

        int id = Integer.parseInt(idParam);
        name = name.trim();
        Priority priority = Priority.valueOf(p);

        boolean updated = TaskStorage.update(id, name, priority);

        if (!updated) {
            String url = "edit-task?error=1&id=" + id
                    + "&name=" + URLEncoder.encode(name, StandardCharsets.UTF_8)
                    + "&priority=" + priority.name();
            resp.sendRedirect(url);
        } else {
            resp.sendRedirect("tasks-list");
        }
    }
}