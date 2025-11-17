package todo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import todo.storage.TaskStorage;

@WebServlet("/delete-task")
public class DeleteTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String idParam = req.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            TaskStorage.delete(id);
        }
        resp.sendRedirect("tasks-list");
    }
}