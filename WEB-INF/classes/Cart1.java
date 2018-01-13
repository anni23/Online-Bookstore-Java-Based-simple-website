import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Cart1 extends HttpServlet
{
PrintWriter pw;
String x,y;
String z;
int m;
int j;
String s,a,r;
Integer i;
HttpSession hs;
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
hs=req.getSession(true);
res.setContentType("text/html");
pw=res.getWriter();
x=req.getParameter("bk");
y=req.getParameter("pr");
z=req.getParameter("rem");
i=(Integer)hs.getAttribute("cnt");
if(i==null)
{
i=new Integer(0);
}
if(!((x.equals("bk"))&(y.equals("pr"))))
{
if(i<10)
i=new Integer(i.intValue()+1);
hs.setAttribute("book"+i,x);
hs.setAttribute("price"+i,y);
}
hs.setAttribute("cnt",i);
pw.println("SHOPING CART");
pw.println("<hr>");
j=i.intValue();
if(!(z.equals("rem")))
{
hs.removeAttribute("book"+j);
hs.removeAttribute("price"+j);
j=j-1;
i=new Integer(j);
hs.setAttribute("cnt",i);
}
for(m=1;m<=j;m++)
{
pw.println("<br><br>");
pw.println("BOOK : ");
pw.println(hs.getAttribute("book"+m));
pw.println("<br>");
pw.println("PRICE");
pw.println(hs.getAttribute("price"+m));
}
pw.println("<hr>");
pw.println("No of items=");
pw.println(hs.getAttribute("cnt"));
pw.println("<br>");
pw.println("<hr>");
pw.println("<br>");
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/cart1?bk=bk&pr=pr&rem=re target=_top>");
pw.println("REMOVE RECENT ITEM FROM CART");
pw.println("</a>");
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/buy?j="+j+" target=_top>");
pw.println("BUY");
pw.println("</a>");
pw.println("<br>");
pw.println("<a href=http://localhost:8080/ANI/onlinestore1.html target=_top>");
pw.println("BACK");
pw.println("</a>");
pw.println("<br>");
pw.println("<br>");
pw.println("NOTE : ");
pw.println("YOU CAN BUY AT MOST 10 ITEMS IN ONE TRANSACTION");
}
}