
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class bank_credit_card extends HttpServlet {
   public void doPost(HttpServletRequest req,
            HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String nm1=req.getParameter("n1");
        String nm2=req.getParameter("n2");
        String nm3=req.getParameter("n3");
        String nm4=req.getParameter("n4");
        String nm5=req.getParameter("n5");
        String nm6=req.getParameter("n6");
        String nm7=req.getParameter("n7");
        String nm8=req.getParameter("n8");
        String nm9=req.getParameter("n9");
        String nm10=req.getParameter("n10");
        String nm11=req.getParameter("n11");
        String nm12=req.getParameter("n12");
        
    try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");//registering typ4 driver
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","password");
            //connecting with child database
            Statement stmt=con.createStatement();//creating statement which is actually required to execute query..
            String id=null;
            String q1="select * from credit_id";
            ResultSet rs=stmt.executeQuery(q1);
            //pw1.println(q1);
            if(rs.next())
            {
                String no=rs.getString(1);
                id="CC"+no;
               // pw1.println(id);
                String q2="insert into credit_card values('"+nm1+"','"+nm2+"','"+nm3+"','"+nm4+"','"+nm5+"','"+nm6+"','"+nm7+"','"+nm8+"','"+nm9+"','"+nm10+"','"+nm11+"','"+nm12+"','"+id+"','no')";
                //pw1.println(q2);
                int x=stmt.executeUpdate(q2);
                
                if(x>0)
                {
                    int no1=Integer.parseInt(no);
                    no1++;
                    String q3="update credit_id set id='"+no1+"'";
                    //pw1.println(q3);
                    int x1=stmt.executeUpdate(q3);
                     
                     if(x1>0)
                     {
                         
                      pw1.println("Your id&nbsp;&nbsp;"+id);
                      pw1.println("<br><a href=\"status_check.html\">Check status for approval</a>");
                         
                         
                     }
                     
                     
                }
                
                
                
                
            }
            
            
            
            
            
            
            
            
            
            
            
            
          
            con.close();
        }
      catch(Exception e)
                    { 
                    pw1.println(e);
                    }
    }
}
        
