import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class Register extends GenericServlet
{
PrintWriter pw;
ResultSet rs;
DBConnect d;
String n,id,pwd,dt,m,y,s,dob,pn;
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
n=req.getParameter("nm");
pn=req.getParameter("phno");
id=req.getParameter("rid");
pwd=req.getParameter("rpwd");
dt=req.getParameter("date");
m=req.getParameter("month");
y=req.getParameter("year");
s=req.getParameter("sex");
dob=(dt+"/"+m+"/"+y);
rs=d.s.executeQuery("select id from users where (id='"+id+"')");
if(rs.next())
{
pw.println("this id is already in use,");
pw.println("please choose some other id");
}
else
{
d.s.execute("insert into users values('"+id+"','"+pwd+"','"+n+"','"+pn+"','"+dob+"','"+s+"')");
pw.println("<html>");
pw.println("<head>");
pw.println("</head>");
pw.println("<body>");
pw.println("you have successfully registered");
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/home.html>");
pw.println("click here");
pw.println("</a>");
pw.println("to login");
pw.println("</body>");
pw.println("</html>");
}
}
catch(Exception ex)
{
ex.printStackTrace();
}
}
}