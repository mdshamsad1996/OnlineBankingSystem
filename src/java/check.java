import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class check extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
    {
        res.setContentType("text/html"); //sends the data in term of html type..
        PrintWriter pw1=res.getWriter(); //Printwriter is used to print in servlet...
        String a1=req.getParameter("email"); //takes the value from field named as "email"...
        String a2=req.getParameter("ans");
        //String a3=req.getParameter("que");
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Type-4 driver reg..
           //connecting with the child database..
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","password");
            Statement stmt=con.createStatement(); //statement reference creation,it is req for query execution..
            String q1="select * from user_reg where email='"+a1+"' and ans='"+a2+"'";
            //pw1.println(q1);
            ResultSet rs=stmt.executeQuery(q1);
            if(rs.next())
            {
               
                pw1.println("Valid user");
                pw1.println("<form method=\"post\" action=\"password_update\">");
                pw1.println("<br><input type=\"email\" name=\"email\" value="+a1+" readonly>");
                pw1.println("<br>Enter new password:");
              
               pw1.println("<br><input type=\"password\" name=\"newpwd\">");
                
               pw1.println("<br><br><input type=\"submit\" name=\"btnsub\" action=\"\" value=\"submit\">");
               pw1.println("</form>");
            }
            
            else
            {
                pw1.println("Invalid email id");
            }
            
            con.close();
        }
        catch(Exception e)
        {
                      pw1.println(e);
        }
                    
                    
                
           
      }

    }
    
    
    


          



        
       