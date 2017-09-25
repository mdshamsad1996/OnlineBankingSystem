import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class bank_money_transfer extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
    {
        res.setContentType("text/html"); //sends the data in term of html type..
        PrintWriter pw1=res.getWriter(); //Printwriter is used to print in servlet...
        String a1=req.getParameter("id"); 
        String a2=req.getParameter("acc_no");
        String a3=req.getParameter("amount");
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Type-4 driver reg..
           //connecting with the child database..
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","password");
            Statement stmt=con.createStatement(); //statement reference creation,it is req for query execution..
                   
            String q1="select * from user_reg where id='"+a1+"'";
            
            
            ResultSet rs=stmt.executeQuery(q1);
            
            if(rs.next())
            {
                
                
                int x=Integer.parseInt(rs.getString(20));
                int y=Integer.parseInt(a3);
                //int nb=x+y;
                //pw1.println(x);
                //pw1.println(y);
                
                if(x>y)
                {
                
                
                    String q2="select * from user_reg where id='"+a2+"'";
                    ResultSet rs1=stmt.executeQuery(q2);
                    if(rs1.next())
                    {
                         int x1=Integer.parseInt(rs1.getString(20));
                         //pw1.println(x1);
                         int fb=x1+y;
                         String q3="update user_reg set balance='"+fb+"' where id='"+a2+"'";
                     
                         int result=stmt.executeUpdate(q3);
                     
                     
                     
                         if(result>0)
                         {
                             pw1.println("update success");
                         
                             int fb1=x-y;
                             String q4="update user_reg set balance='"+fb1+"' where id='"+a1+"'";
                             int final1=stmt.executeUpdate(q4);
                             if(final1>0)
                             {
                             
                                pw1.println("SUCCESS");
                             
                             }
                         
                              else
                              {
                                pw1.println("Sorry,an error occured");
                              }
                          }
                     
                          else
                          {
                               pw1.println("update unsuccess");
                          }
                     
                      }    
                     
                      else
                      {
                    
                          pw1.println("");
                    
                      }
                     
                     
                     
                }
               else
                {
                    pw1.println("Sorry,insufficient balance..Please check your account<a href=\"bank_login.html\">Login</a>");
                }
                   
        }
            
            else
            {
                pw1.println("Sorry Login failed,please provide correct details...");
                
                
                
 
            }
            
            
           
           
           
            
            con.close();
        }
        catch(Exception e)
        {
                      pw1.println(e);
        }
                    
                    
                
           
      }

    }
    
    
    


          



        
       