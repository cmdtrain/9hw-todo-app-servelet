package todo.servlet;
import todo.storage.*;
import todo.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/edit-task")
public class EditTaskServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest r,HttpServletResponse s)
            throws IOException,ServletException
    {
        int id=Integer.parseInt(r.getParameter("id"));
        r.setAttribute("task",TaskStorage.findById(id));
        if(r.getParameter("error")!=null)r.setAttribute("error","Task with a given name already exists!");
        r.getRequestDispatcher("/edit-task.jsp").forward(r,s);
    }
    protected void doPost(HttpServletRequest r,HttpServletResponse s)
            throws IOException
    {
        int id=Integer.parseInt(r.getParameter("id"));
        String n=r.getParameter("name");
        String p=r.getParameter("priority");
        if(!TaskStorage.updateTask(id,n,Priority.valueOf(p)))s.sendRedirect(r.getContextPath()+"/edit-task?error=1&id="+id+"&name="+n+"&priority="+p);
        else s.sendRedirect(r.getContextPath()+"/tasks-list");
    }
}