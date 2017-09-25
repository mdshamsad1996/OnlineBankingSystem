
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;
public class bank_reg extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
    {
        res.setContentType("text/html"); //sends the data in term of html type..
        PrintWriter pw1=res.getWriter(); //Printwriter is used to print in servlet...
        String s1=req.getParameter("customer_type"); 
        String s2=req.getParameter("prefix");
        String s3=req.getParameter("firstname");
        String s4=req.getParameter("middlename");   
        String s5=req.getParameter("lastname");
        String s6=req.getParameter("gurdian_prefix"); 
        String s7=req.getParameter("gurdian_name");
        String s8=req.getParameter("dob");
        String s9=req.getParameter("gender");   
        String s10=req.getParameter("nationality");
        String s11=req.getParameter("landmark"); 
        String s12=req.getParameter("district");
        String s13=req.getParameter("state");
        String s14=req.getParameter("phone_no");   
        String s15=req.getParameter("email");
        String s16=req.getParameter("que"); 
        String s17=req.getParameter("ans");
        String s18=req.getParameter("pwd");
        String s19=req.getParameter("balance");
       try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Type-4 driver reg..
           //connecting with the child database..
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","password");
            Statement stmt=con.createStatement(); //statement reference creation,it is req for query execution..
            String id=null;
            String q1="select * from id";
            ResultSet rs=stmt.executeQuery(q1);
            if(rs.next())
            {
               String no=rs.getString(1);
               id="ACC001"+no;
               
               String q2="insert into user_reg values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+s12+"','"+s13+"','"+s14+"','"+s15+"','"+s16+"','"+s17+"','"+id+"','"+s18+"','"+s19+"')";
   
               int x=stmt.executeUpdate(q2);
               if(x>0)
               {
                   
                  int no1=Integer.parseInt(no);
                  no1++;
                  String q3="update id set id='"+no1+"'";
                  int x1=stmt.executeUpdate(q3);
                  if(x1>0)
                  {
                      pw1.println("<html>\n" +
                        "<head>\n" +
                        "<style type=\"text/css\">\n" +
                        "+body{\n"+
                        "background-color:#E0FFFF;\n"+                               
                        "\n"+
                        "}\n"+
                              
                              
                        "\n" +
                        "#main{\n" +
                        "\n" +
                        "width:50%;\n" +
                        "height:40%;\n" +
                        
                        "background-color:pink;\n" +                              
                        "margin-left:25%;\n" +
                        "margin-top:10%;\n" +
                        "//-webkit-border-radius:20px;\n" +
                        "\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "h1{\n" +
                        "margin-top:-1px;	\n" +
                        "padding-left:6%;\n" +
                        "background-color:LightGray;\n" +
                        "color:black;\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "p{\n" +
                        "\n" +
                        "font-size:25px;\n" +
                        "text-align:center;\n" +
                        "\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "</style>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body bgcolor=\"#E0FFFF\">\n" +
                        "\n" +
                        "<div id=\"main\">\n" +
                        "<h1>Congratulations!!! Registration Successful</h1>\n" +
                        " <p>Thanks for registering with our bank.</p><br>"
                        + "\n" +

                        "<br>\n" +
                        "\n" +
                        "\n" +
                        "</div>\n" +
                        "</body>\n" +
                        "</html>");
                      
                        pw1.println("<html>\n" +
                        "<head>\n" +
                        "<style type=\"text/css\">\n" +
                        "\n" +
                        "#main{\n" +
                        "\n" +
                        "width:50%;\n" +
                        "height:40%;\n" +
                        
                        "margin-left:25%;\n" +
                        "margin-top:10%;\n" +
                        "//-webkit-border-radius:20px;\n" +
                        "\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "h1{\n" +
                        "margin-top:-1px;	\n" +
                        "padding-left:6%;\n" +
                        "background-color:LightGray;\n" +
                        "color:black;\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "h3{\n" +
                        "\n" +
                        "font-size:25px;\n" +
                        "text-align:center;\n" +
                        "margin-top:-140px;\n"+        
                        "\n" +
                        "\n" +  
                        "}\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "</style>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body>\n" +
                        "\n" +

                        
                      
                        "<br>\n" +
                        "<h3>Your account number is:" +id +
                        "\n" +
                        "<br><br><a href=\"bank_login.html\">Login</a>"+        
                        "</div>\n" +
                        "</body>\n" +
                        "</html>");
                  }
                  
                  else
                  {
                      pw1.println("unsucces");
                    
                  }
                
                }
            
           
            
            }
        }
             
        catch(Exception e)
        {
                      pw1.println(e);
        }
                    
                    
                
           
      }

    }
    
    