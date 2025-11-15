package todo.servlet;
import todo.storage.*;
import todo.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/read-task")
public class ReadTaskServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest r,HttpServletResponse s)
            throws IOException,ServletException
    {
        int id=Integer.parseInt(r.getParameter("id"));
        r.setAttribute("task",TaskStorage.findById(id));
        r.getRequestDispatcher("/read-task.jsp").forward(r,s);
    }
}