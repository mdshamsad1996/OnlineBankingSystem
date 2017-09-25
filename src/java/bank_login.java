import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class bank_login extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
    {
        res.setContentType("text/html"); //sends the data in term of html type..
        PrintWriter pw1=res.getWriter(); //Printwriter is used to print in servlet...
        String a1=req.getParameter("id"); //takes the value from field named as "id"...
        String a2=req.getParameter("pwd");//takes the value from field named as "pwd"...
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Type-4 driver reg..
           //connecting with the child database..
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","password");
            Statement stmt=con.createStatement(); //statement reference creation,it is req for query execution..
                   
            String q1="select * from user_reg where id='"+a1+"' and pwd='"+a2+"'";
            
            
            ResultSet rs=stmt.executeQuery(q1);
            
            if(rs.next())
            {
                
                pw1.println("Login successful:<br>");
               pw1.println("<html>\n"+
                "<head>\n"+
                "<style type=\"text/css\">\n"+
                "#main{\n"+
                "width:80%;\n"+
                "height:50%;\n"+
                "border:1px solid black;\n"+
                "margin-left:15%;\n"+
                "margin-top:10%;\n"+


                "}\n"+

                "h1{\n"+

                "width:94%;\n"+
                "height:18%;\n"+
                "border:1px solid black;\n"+
                "padding-left:2%;\n"+
                "padding-top:1%;\n"+
                "margin-top:-0.1%;\n"+
                "text-align:center;\n"+
                "background-color:black;\n"+
                "color:white;\n"+
                "}\n"+



                "</style>\n"+
                "</head>\n"+
                "<body>\n"+
                "<div id=\"main\">\n"+
                "<h1>Account Details</h1>"+




                 "</div>\n"+






               " </body>\n"+
                "</html>");

               pw1.println("<html>\n" +
                        "<head>\n" +
                        "<style type=\"text/css\">\n" +
                        "\n" +
                        "#main{\n" +
                        "\n" +
                        "width:80%;\n" +
                        "height:50%;\n" +
                        
                        "margin-left:10%;\n" +
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
                        "margin-top:-240px;\n"+    
                       "color:blue;\n"+
                       "margin-left:700px;\n"+
                        "\n" +
                        "\n" +  
                        "}\n" +
                       
                       "h4{\n"+
                       "margin-left:200px;\n"+
                       "font-size:20px;\n"+
                       "color:green;\n"+
                       
                       
                       
                       
                       "}\n"+
                       
                       
                        
                       "h5{\n"+
                       "margin-left:400px;\n"+
                       "font-size:20px;\n"+
                       "color:green;\n"+
                       "margin-top:-93px;\n"+
                       
                       
                       
                       "}\n"+
                       
                        "h6{\n"+
                       "margin-left:670px;\n"+
                       "font-size:20px;\n"+
                       "color:green;\n"+
                       "margin-top:-100px;\n"+
                       
                       
                       
                       "}\n"+
                       
                       
                        "h7{\n"+
                       "margin-left:150px;\n"+
                       "font-size:20px;\n"+
                       "color:green;\n"+
                       "margin-top:-70px;\n"+
                       
                       
                       
                       "}\n"+
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
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
                        "<body>\n"+
                        "<h3>Welcome:" +rs.getString(2)+rs.getString(3)+"&nbsp"+rs.getString(4)+"&nbsp"+rs.getString(5)+
                       "<h4><u>Account no:</u><br><br>"+rs.getString(18)+
                       "<h5><u>Account Balance:</u><br><br>"+rs.getString(20)+
                       "<h6><u>Contact No:</u><br><br>"+rs.getString(14)+
                       "<h7><u>Email:</u>"+rs.getString(15)+
                       
                       
                       "<br>\n" +
                        
                        "\n" +
                        "<br><br><a href=\"money_transfer.html\">Money Transfer</a>"+        
                        "</div>\n" +
                        "</body>\n" +
                        "</html>");
                                  
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
            
                
                
                
                //pw1.println("welcome "+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
                
            }
            
            else
            {
                pw1.println("Sorry Login failed");
                
                
                
 
            }
            
            
           
           
           
            
            con.close();
        }
        catch(Exception e)
        {
                      pw1.println(e);
        }
                    
                    
                
           
      }

    }
    
    
    


          



        
       