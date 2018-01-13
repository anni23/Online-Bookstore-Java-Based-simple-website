import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Login extends GenericServlet
{
DBConnect d;
PrintWriter pw;
ResultSet rs;
String x,y;
public void init()
{
d=new DBConnect();
}
public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException
{
try
{
res.setContentType("text/html");
pw=res.getWriter();
x=req.getParameter("lid");
y=req.getParameter("lpwd");
rs=d.s.executeQuery("select id,password from users where (id='"+x+"')and(password='"+y+"')");
if(rs.next())
{
pw.println("<html>");
pw.println("<head>");
pw.println("</head>");
pw.println("<body>");
pw.println("<a href=http://localhost:8080/ANI/first.html>");
pw.println("click here");
pw.println("</a>");
pw.println("to continue");
pw.println("</body>");
pw.println("</html>");
}
else
{
pw.println("<html>");
pw.println("<head>");
pw.println("</head>");
pw.println("<body>");
pw.println("you have entered invalid login id or password");
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/home.html>");
pw.println("click here");
pw.println("</a>");
pw.println("to login");
pw.println("</body>");
pw.println("</html>");
}
}
catch(Exception e)
{
e.printStackTrace();     
}
}
}