import java.sql.*;
public class DBConnect
{
Statement s;
Connection c;
DBConnect()
{
try
{
DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
c=DriverManager.getConnection("jdbc:odbc:ani");
s=c.createStatement();
}
catch(Exception e)
{
e.printStackTrace();
}
}
public static void main(String args[])
{
DBConnect d=new DBConnect();
}
} 