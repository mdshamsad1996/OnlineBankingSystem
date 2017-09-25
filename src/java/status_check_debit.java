
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class status_check_debit extends HttpServlet{

    public void doPost(HttpServletRequest req,
            HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String a1=req.getParameter("check");       
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:"+"thin:@localhost:1521:XE","admin","password"); 
            Statement stmt=con.createStatement(); 
            String f1="select * from  debit_card where id ='"+a1+"'";
           
            ResultSet rs=stmt.executeQuery(f1);
            if(rs.next())
            {
               pw1.println(rs.getString(14));
                   
              
            }
            else
            {
                pw1.println("error");
            }
            
            
            
            con.close();
        }
        catch(Exception e)
        { 
            pw1.println(e);
        }
                    
    }
}
