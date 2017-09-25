
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class debit_card_approve extends HttpServlet {

    public void doGet(HttpServletRequest req,
            HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String a1=req.getParameter("id");
       pw1.println(a1);
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:"+"thin:@localhost:1521:XE","admin","password"); 
            Statement stmt=con.createStatement(); 
            String q1="update debit_card set status='yes' where email='"+a1+"'";
            pw1.println(q1);
             int x=stmt.executeUpdate(q1);
             if(x>0)
             {
                 pw1.println("Approved");
                 
                 
             }
             
             else
             {
                 pw1.println("Not approved");
                 
             }
        }
        catch(Exception e)
        { 
            pw1.println(e);
        }
                    
    }
}
