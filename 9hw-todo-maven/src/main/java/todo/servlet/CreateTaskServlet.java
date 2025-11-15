package todo.servlet;

import todo.model.*;
import todo.storage.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet
        ("/create-task")
public class CreateTaskServlet extends HttpServlet{protected void doGet(HttpServletRequest r,HttpServletResponse s)
        throws IOException,ServletException{if(r.getParameter("error")!=null)r.setAttribute("error","Task with a given name already exists!");
    r.getRequestDispatcher("/create-task.jsp").forward(r,s);
}
protected void doPost(HttpServletRequest r,HttpServletResponse s)
        throws IOException{String n=r.getParameter("name");
    String p=r.getParameter("priority");
    if(TaskStorage.addTask(n,Priority.valueOf(p))==null)s.sendRedirect(r.getContextPath()+"/create-task?error=1&name="+n+"&priority="+p);
    else s.sendRedirect(r.getContextPath()+"/tasks-list");
}
}