import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Pay extends HttpServlet
{
DBConnect d;
PrintWriter pw;
ResultSet rs;
String x,y;
public void init()
{
d=new DBConnect();
}
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
try
{
res.setContentType("text/html");
pw=res.getWriter();
x=req.getParameter("id");
y=req.getParameter("pwd");
rs=d.s.executeQuery("select id,password from users where (id='"+x+"')and(password='"+y+"')");
if(rs.next())
{
pw.println("<html>");
pw.println("<head>");
pw.println("</head>");
pw.println("<body>");
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
pw.println("<a href=http://localhost:8080/ANI/pay>");
pw.println("click here");
pw.println("</a>");
pw.println("to go back");
pw.println("</body>");
pw.println("</html>");
}
}
catch(Exception e)
{
e.printStackTrace();     
}
}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}
}