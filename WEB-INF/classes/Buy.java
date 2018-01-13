import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Buy extends HttpServlet
{
String x;
String a,s;
int t=0;
int n,m;
int j;
PrintWriter pw;
HttpSession hs;
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
hs=req.getSession(true);
res.setContentType("text/html");
pw=res.getWriter();
x=req.getParameter("j");
j=Integer.parseInt(x);
for(m=1;m<=j;m++)
{
a=s.valueOf(hs.getAttribute("price"+m));
n=Integer.parseInt(a);
t=t+n;
}
if(j==0)
{
t=0;
}
pw.println("ITEMS YOU HAVE SELECTED FOR PURCHASE");
pw.println("<br>");
pw.println("<hr>");
for(m=1;m<=j;m++)
{
pw.println(hs.getAttribute("book"+m));
pw.println("=");
pw.println(hs.getAttribute("price"+m));
pw.println("<br>");
}
pw.println("<br>");
pw.println("Number of items");
pw.println("=");
pw.println(j);
pw.println("<br>");
pw.println("Total amount");
pw.println("=");
pw.println(t);
pw.println("<br>");
pw.println("<hr>");
pw.println("PLACE AN ORDER BY CASH ON DELIVERY");
pw.println("<hr>");
pw.println("<br>");
pw.println("<form method=post action=http://localhost:8080/ANI/cod?t="+t+">");
pw.println("Enter your account id ");
pw.println("<input type=text name=id>");
pw.println("<br>");
pw.println("Enter your account password ");
pw.println("<input type=password name=pwd>");
pw.println("<br>");
pw.println("Enter your mobile number ");
pw.println("<input type=text name=no>");
pw.println("<br>");
pw.println("Enter your postal address here");
pw.println("<br>");
pw.println("<textarea name=add rows=3 cols=25>");
pw.println("</textarea>");
pw.println("<br>");
pw.println("<input type=submit value=DONE>");
pw.println("</form>");
pw.println("<br>");

pw.println("<a href=http://localhost:8080/ANI/onlinestore1.html target=_top>");
pw.println("BACK");
pw.println("</a>");
t=0;
}
}