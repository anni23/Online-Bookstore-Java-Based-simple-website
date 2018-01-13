import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Search extends HttpServlet
{
DBConnect d;
PrintWriter pw;
ResultSet rs;
String x;
String b,p;
boolean t=true;
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
x=req.getParameter("search");
rs=d.s.executeQuery("select * from commerce where (book='"+x+"')");
if(rs.next())
{
b=rs.getString("book");
pw.println("book: ");
pw.println(b);
pw.println("<br>");
p=rs.getString("price");
pw.println("price: ");
pw.println(p);
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/cart1?bk="+b+"&pr="+p+"&rem=rem>");
pw.println("add to cart");
pw.println("</a>");
t=false;
}
else
{
rs.close();
}
rs=d.s.executeQuery("select * from fe where (book='"+x+"')");
if(rs.next())
{
b=rs.getString("book");
pw.println("book: ");
pw.println(b);
pw.println("<br>");
p=rs.getString("price");
pw.println("price: ");
pw.println(p);
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/cart1?bk="+b+"&pr="+p+"&rem=rem>");
pw.println("add to cart");
pw.println("</a>");
t=false;
}
else
{
rs.close();
}
rs=d.s.executeQuery("select * from novels where (book='"+x+"')");
if(rs.next())
{
b=rs.getString("book");
pw.println("book: ");
pw.println(b);
pw.println("<br>");
p=rs.getString("price");
pw.println("price: ");
pw.println(p);
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/cart1?bk="+b+"&pr="+p+"&rem=rem>");
pw.println("add to cart");
pw.println("</a>");
t=false;
}
else
{
rs.close();
}
rs=d.s.executeQuery("select * from medical where (book='"+x+"')");
if(rs.next())
{
b=rs.getString("book");
pw.println("book: ");
pw.println(b);
pw.println("<br>");
p=rs.getString("price");
pw.println("price: ");
pw.println(p);
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/cart1?bk="+b+"&pr="+p+"&rem=rem>");
pw.println("add to cart");
pw.println("</a>");
t=false;
}
else
{
rs.close();
}
rs=d.s.executeQuery("select * from post where (book='"+x+"')");
if(rs.next())
{
pw.println("book: ");
pw.println(rs.getString("book"));
pw.println("<br>");
pw.println("author: ");
pw.println(rs.getString("author"));
pw.println("<br>");
pw.println("publisher: ");
pw.println(rs.getString("publisher"));
pw.println("<br>");
pw.println("edition: ");
pw.println(rs.getString("edition"));
pw.println("<br>");
pw.println("price: ");
pw.println(rs.getString("price"));
pw.println("<br>");
pw.println("contact_no: ");
pw.println(rs.getString("contact_no"));
t=false;
}
else
{
rs.close();
}
if(t==true)
{
pw.println("NO RESULT FOUND");
}
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/first.html>");
pw.println("BACK");
pw.println("</a>");
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