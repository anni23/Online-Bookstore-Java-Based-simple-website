import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Novels extends HttpServlet
{
DBConnect d;
HttpSession hs;
PrintWriter pw;
String m;
ResultSet rs;
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
rs=d.s.executeQuery("select * from novels");
pw.println("<table border=2>");
pw.println("<tr>");
pw.println("<th>book</th>");
pw.println("<th>price</th>");
pw.println("<th>cart</th>");
pw.println("</tr>");
while(rs.next())
{
m=rs.getString("book");
String n=rs.getString("price");
pw.println("<tr>");
pw.println("<td>"+m+"</td>");
pw.println("<td>"+n+"</td>");
pw.println("<td><a href=http://localhost:8080/ANI/cart1?bk="+m+"&pr="+n+"&rem=rem target=_top>add to cart</a></td>");
pw.println("</tr>");
}
pw.println("</table>");
}
catch(Exception ex)
{
ex.printStackTrace();
}
}
}