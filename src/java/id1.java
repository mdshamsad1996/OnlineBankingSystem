
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
public class id1 extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
    {
        res.setContentType("text/html"); //sends the data in term of html type..
        PrintWriter pw1=res.getWriter(); //Printwriter is used to print in servlet...
        String s1=req.getParameter("id"); //takes the value from field named as "id"...
       
        
         try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Type-4 driver reg..
           //connecting with the child database..
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","password");
            Statement stmt=con.createStatement(); //statement reference creation it is req for query execution..
            String q1="insert into id values('"+s1+"')";
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
                pw1.println("insert successful");
            }
            
            else
            {
                pw1.println("Insert unsuccessful");
            }
            
            con.close();
        }
        catch(Exception e)
        {
                      pw1.println(e);
        }
                    
                    
                
           
      }

    }
    
    
    


          



        
       
        
        
        
        
        
        
        
        
       