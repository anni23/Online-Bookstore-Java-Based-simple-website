import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class Cod extends HttpServlet
{
PrintWriter pw;
ResultSet rs;
DBConnect d;
HttpSession hs;
String b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
String x,y;
String t,m;
String a,q;
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
hs=req.getSession(true);
x=req.getParameter("id");
y=req.getParameter("pwd");
rs=d.s.executeQuery("select id,password from users where (id='"+x+"')and(password='"+y+"')");
t=req.getParameter("t");
a=req.getParameter("add");
m=req.getParameter("no");
b1=q.valueOf(hs.getAttribute("book"+1));
b2=q.valueOf(hs.getAttribute("book"+2));
b3=q.valueOf(hs.getAttribute("book"+3));
b4=q.valueOf(hs.getAttribute("book"+4));
b5=q.valueOf(hs.getAttribute("book"+5));
b6=q.valueOf(hs.getAttribute("book"+6));
b7=q.valueOf(hs.getAttribute("book"+7));
b8=q.valueOf(hs.getAttribute("book"+8));
b9=q.valueOf(hs.getAttribute("book"+9));
b10=q.valueOf(hs.getAttribute("book"+10));
if(b1.equalsIgnoreCase("null"))
{
b1="";
}
if(b2.equalsIgnoreCase("null"))
{
b2="";
}
if(b3.equalsIgnoreCase("null"))
{
b3="";
}
if(b4.equalsIgnoreCase("null"))
{
b4="";
}
if(b5.equalsIgnoreCase("null"))
{
b5="";
}
if(b6.equalsIgnoreCase("null"))
{
b6="";
}
if(b7.equalsIgnoreCase("null"))
{
b7="";
}
if(b8.equalsIgnoreCase("null"))
{
b8="";
}
if(b9.equalsIgnoreCase("null"))
{
b9="";
}
if(b10.equalsIgnoreCase("null"))
{
b10="";
}
if(rs.next())
{
d.s.execute("insert into cod values('"+x+"','"+a+"','"+m+"','"+b1+"','"+b2+"','"+b3+"','"+b4+"','"+b5+"','"+b6+"','"+b7+"','"+b8+"','"+b9+"','"+b10+"','"+t+"')");
pw.println("YOU HAVE SUCCESSFULLY PLACED YOUR ORDER, YOUR ORDER WILL REACH YOU WITHIN 3 TO 4 WORKING DAYS");
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/onlinestore1.html>");
pw.println("BACK");
pw.println("</a>");
}
else
{
pw.println("<html>");
pw.println("<head>");
pw.println("</head>");
pw.println("<body>");
pw.println("you have entered invalid login id or password");
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/buy?j="+t+">");
pw.println("click here");
pw.println("</a>");
pw.println("to go back");
pw.println("</body>");
pw.println("</html>");
hs.invalidate();
}
}
catch(Exception ex)
{
ex.printStackTrace();
}
}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
doGet(req,res);
}
}