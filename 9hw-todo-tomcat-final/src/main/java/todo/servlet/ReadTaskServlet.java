package todo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import todo.storage.TaskStorage;

@WebServlet("/read-task")
public class ReadTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            req.setAttribute("task", TaskStorage.findById(id));
        }
        req.getRequestDispatcher("/read-task.jsp").forward(req, resp);
    }
}