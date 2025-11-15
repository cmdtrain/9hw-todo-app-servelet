package todo.servlet;
import todo.storage.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/tasks-list")
public class TaskListServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest r,HttpServletResponse s)
            throws IOException,ServletException{r.setAttribute("tasks",TaskStorage.getAll());
        r.getRequestDispatcher("/tasks-list.jsp").forward(r,s);
    }
}