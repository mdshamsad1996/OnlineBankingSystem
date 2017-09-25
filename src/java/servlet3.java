
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class servlet3 extends HttpServlet {

    public void doGet(HttpServletRequest req,
            HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
               
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:"+"thin:@localhost:1521:XE","admin","password"); 
            Statement stmt=con.createStatement(); // here we are creating a statement which is required to execute the query
            String f1="select * from edu_loan where status='no'";
          ResultSet rs=stmt.executeQuery(f1);
            while(rs.next())
            {
                //pw1.println("fetch successfull<br>");
                String a=rs.getString(10);
                               
                pw1.println("Firstname:&nbsp&nbsp&nbsp"+rs.getString(1));
                pw1.println("Midname:&nbsp&nbsp&nbsp"+rs.getString(2));
                pw1.println("Lastname:&nbsp&nbsp&nbsp"+rs.getString(3));
                pw1.println("Occupation:&nbsp&nbsp&nbsp"+rs.getString(6));
                pw1.println("Qualification:&nbsp&nbsp&nbsp"+rs.getString(7));
                pw1.println("Income:&nbsp&nbsp&nbsp"+rs.getString(8));
                pw1.println("email:&nbsp&nbsp&nbsp"+rs.getString(10));
                pw1.println("<a href=\"edu_loan_approve?id="+a+"\">Approve</a>");
                
                
                
             
                
                
             }
            
            
            
            con.close();
        }
        catch(Exception e)
        { 
            pw1.println(e);
        }
                    
    }
}
