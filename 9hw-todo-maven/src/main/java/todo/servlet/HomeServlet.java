package todo.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest r,HttpServletResponse s)
            throws IOException,ServletException{r.getRequestDispatcher("/home.jsp").forward(r,s);
    }
}