import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class forgot extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
    {
        res.setContentType("text/html"); //sends the data in term of html type..
        PrintWriter pw1=res.getWriter(); //Printwriter is used to print in servlet...
        String a1=req.getParameter("email"); //takes the value from field named as "email"...
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Type-4 driver reg..
           //connecting with the child database..
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","password");
            Statement stmt=con.createStatement(); //statement reference creation,it is req for query execution..
            String q1="select * from user_reg where email='"+a1+"'";
            ResultSet rs=stmt.executeQuery(q1);
            if(rs.next())
            {
               
                pw1.println("Valid email id<br>");
                pw1.println("Security question was:");
               String que=rs.getString(16);
                //pw1.println("The security que is:"+rs.getString(4)); //1 is for column 1..
               pw1.println(que);
             
               pw1.println("<form method=\"post\" action=\"check\">");
               
               
               pw1.println("<br>Enter email id:");
              
               pw1.println("<br><input type=\"email\" name=\"email\" value=\"\">");
               
               
               pw1.println("<br>Enter the answer:");
              // pw1.println("<form method=\"post\" action=\"check\">");
               
              pw1.println("<br><input type=\"text\" name=\"ans\">");
              
              pw1.println("<br><br><input type=\"submit\" name=\"btnsub\" action=\"check\" value=\"submit\">");
              pw1.println("</form>");
            
            } 
            
            else
            {
                pw1.println("invalid user,please try again...");
            }
            
            con.close();
        }
        catch(Exception e)
        {
                      pw1.println(e);
        }
                    
                    
                
           
      }

    }
    
    
    


          



        
       