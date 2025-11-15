package todo.servlet;
import todo.storage.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/delete-task")
public class DeleteTaskServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest r,HttpServletResponse s)
            throws IOException{TaskStorage.deleteTask(Integer.parseInt(r.getParameter("id")));
        s.sendRedirect(r.getContextPath()+"/tasks-list");
    }
}