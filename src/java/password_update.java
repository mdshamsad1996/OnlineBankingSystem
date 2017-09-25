import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class password_update extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
    {
        res.setContentType("text/html"); //sends the data in term of html type..
        PrintWriter pw1=res.getWriter(); //Printwriter is used to print in servlet...
        String a1=req.getParameter("email"); //takes the value from field named as "email"...
        String a2=req.getParameter("newpwd");
        //String a3=req.getParameter("que");
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Type-4 driver reg..
           //connecting with the child database..
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","password");
            Statement stmt=con.createStatement(); //statement reference creation,it is req for query execution..
           String q1="update user_reg set pwd='"+a2+"' where email='"+a1+"'";
            //pw1.println(q1);
            
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
                pw1.println("update successful");
            }
            
            else
            {
                pw1.println("update unsuccessful");
            }
            
            con.close();
        }
        catch(Exception e)
        {
                      pw1.println(e);
        }
                    
                    
                
           
      }

    }
    
    
    


          



        
       