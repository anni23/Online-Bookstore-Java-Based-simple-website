<html>
<head>
<title></title>
<style type="text/css"> 
a
{
color:white;
font-size:25;
text-decoration:none;
font-family:Microsoft Sans Serif;
font-style:bold;
}
input
{
width:100;
}
input.post
{
background-color:#6379ad;
color:white;
border-color:#6379ad;
width:50;
}
div
{
background-color:rgb(0,81,115);
height:110;
}
div.a
{
background-color:rgb(57,178,214);
height:30;
}
a
{
color:white;
font-size:25;
text-decoration:none;
font-family:Microsoft Sans Serif;
font-style:bold;
}
font.bookstore
{
color:white;
position:absolute;
left:50;
font-size:70;
top:30;
font-family:Calibri;
}
</style>
</head>
<body>
<div>
<br>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<font class="bookstore">
<b>
BOOKSTORE
</b>
</font>
</div>
<div class="a">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="Http://localhost:8080/ANI/first.html">Home</a>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="http://localhost:8080/ANI/onlinestore1.html">Online Store</a>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="http://localhost:8080/ANI/post.jsp">buy/sell used books</a>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="http://localhost:8080/ANI/aboutus.html">About us</a>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="http://localhost:8080/ANI/contactus.html">Contact us</a>
</div>

<form method=post action="http://localhost:8080/ANI/post.jsp">
<hr>
<font color="rgb(0,111,111)" face="Microsoft Sans Serif">
Book :
<input type="text" name="book">
&nbsp&nbsp
Author :
<input type="text" name="author">
&nbsp&nbsp
Publisher :
<input type="text" name="publisher">
&nbsp&nbsp
Edition :
<input type="text" name="edition">
&nbsp&nbsp
Price :
<input type="text" name="price">
&nbsp&nbsp
Contact no :
<input type="text" name="contact">
&nbsp
<input class="post" type="submit" value="post">
</font>
<hr>
</form>
<font color=rgb(0,83,166) size=05 face="Microsoft Sans Serif">
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%!
Statement s;
Connection c;
String bk,pr,con,ed,auth,pub;
ResultSet rs;
%>
<%
DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
c=DriverManager.getConnection("jdbc:odbc:ani");
s=c.createStatement();
try
{
rs=s.executeQuery("select * from post");
rs.next();
do
{
%>
<br>
<br>
<font color=black>
Book :
</font>
<%
out.println(rs.getString("book"));
%>
<br>
<font color=black>
Author :
</font>
<%
out.println(rs.getString("author"));
%>
<br>
<font color=black>
Publisher :
</font>
<%
out.println(rs.getString("publisher"));
%>
<br>
<font color=black>
Edition :
</font>
<%
out.println(rs.getString("edition"));
%>
<br>
<font color=black>
Price :
</font>
<%
out.println(rs.getString("price"));
%>
<br>
<font color=black>
Contact no :
</font>
<%
out.println(rs.getString("contact_no"));
%>
<br>
<%
}
while(rs.next());
}
catch(Exception e)
{
e.printStackTrace();
}
bk=request.getParameter("book");
pr=request.getParameter("price");
con=request.getParameter("contact");
ed=request.getParameter("edition");
auth=request.getParameter("author");
pub=request.getParameter("publisher");
try
{
if(bk==null)
{
}
else
{
s.execute("insert into post values('"+bk+"','"+auth+"','"+pub+"','"+ed+"','"+pr+"','"+con+"')");
}
}
catch(Exception e)
{
e.printStackTrace();
}
%>
</body>
</html>
