import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class admin_login extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
    {
        res.setContentType("text/html"); //sends the data in term of html type..
        PrintWriter pw1=res.getWriter(); //Printwriter is used to print in servlet...
        String a1=req.getParameter("username"); //takes the value from field named as "username"...
        String a2=req.getParameter("pwd");//takes the value from field named as "pwd"...
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Type-4 driver reg..
            //connecting with the child database..
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","password");
            Statement stmt=con.createStatement(); //statement reference creation,it is req for query execution..
                   
            String q1="select * from admin where username='"+a1+"' and pwd='"+a2+"'";
            
            
            ResultSet rs=stmt.executeQuery(q1);
            
            if(rs.next())
            {
                
                pw1.println("Login successful:<br>");
                
                pw1.println("<a href='status.html'>Approval pending for credit card</a>");
                pw1.println("<br>");
                pw1.println("<a href='status_debit.html'>Approval pending for debit card</a>");
                pw1.println("<br>");
                pw1.println("<a href='status_hloan.html'>Approval pending for home loan</a>");
                pw1.println("<br>");
                pw1.println("<a href='status_eloan.html'>Approval pending for education loan</a>");
                      
                      
            }
            
            else
            {
                pw1.println("Sorry Login failed");
                
                
                
 
            }
            
            
           
           
           
            
            con.close();
        }
        catch(Exception e)
        {
                      pw1.println(e);
        }
                    
                    
                
           
      }

    }
    
    
    


          



        
       