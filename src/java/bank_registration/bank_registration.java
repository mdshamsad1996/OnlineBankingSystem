
import java.util.Random;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
public class bank_registration extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
    {
        res.setContentType("text/html"); //sends the data in term of html type..
        PrintWriter pw1=res.getWriter(); //Printwriter is used to print in servlet...
        String s1=req.getParameter("customer_type"); //takes the value from field named as "name"...
        String s2=req.getParameter("prefix");//takes the value from field named as "email"...
        String s3=req.getParameter("firstname");//takes the value from field named as "pwd"...
        String s4=req.getParameter("middlename");//takes the value from field named as "que"...   
        String s5=req.getParameter("lastname");//takes the value from field named as "ans"...
        String s6=req.getParameter("gurdian_prefix"); //takes the value from field named as "name"...
        String s7=req.getParameter("gurdian_name");//takes the value from field named as "email"...
        String s8=req.getParameter("dob");//takes the value from field named as "pwd"...
        String s9=req.getParameter("gender");//takes the value from field named as "que"...   
        String s10=req.getParameter("nationality");//takes the value from field named as "ans"...
        
        String s11=req.getParameter("landmark"); //takes the value from field named as "name"...
        String s12=req.getParameter("district");//takes the value from field named as "email"...
        String s13=req.getParameter("state");//takes the value from field named as "pwd"...
        String s14=req.getParameter("phone_no");//takes the value from field named as "que"...   
        String s15=req.getParameter("email");//takes the value from field named as "ans"...
        String s16=req.getParameter("que"); //takes the value from field named as "name"...
        String s17=req.getParameter("ans");//takes the value from field named as "email"...
        
        
        
        
        
        
        
        
        
        
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Type-4 driver reg..
           //connecting with the child database..
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","password");
            Statement stmt=con.createStatement(); //statement reference creation it is req for query execution..
           
            String q2="insert into user_reg values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+s12+"','"+s13+"','"+s14+"','"+s15+"','"+s16+"','"+s17+"')";
            int x=stmt.executeUpdate(q2);
            if(x>0)
            {
                //pw1.println("insert successful");
                Random rand=new Random();
                pw1.println(rand.nextInt(5));
                
                
               
                
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

    
    
    


          



        
       