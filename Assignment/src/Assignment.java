
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Assignment extends HttpServlet
{
public void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException
{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<HEAD><TITLE>My First Servlet</TITLE></HEAD>");
out.println("<BODY>");
out.println(“<H1>Hello, World!</H1>”);
out.println("</BODY>");
out.close();
}
}