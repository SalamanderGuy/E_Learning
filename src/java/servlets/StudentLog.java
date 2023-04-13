package servlets;

import students.Students;
import students.StudentsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.sql.Types.NULL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static students.StudentsDAO.getStudentId;


public class StudentLog extends HttpServlet {
public static String username;
public static int id;

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setCharacterEncoding("UTF-8");
       PrintWriter out=response.getWriter(); 
        try{
        response.setContentType("text/html");  
        
        out.println("<form action=\"StudentLog\" method=\"get\">");
         
        String usern=request.getParameter("usname");
        String pass=request.getParameter("pass");
        
        boolean log=StudentsDAO.getStudentbyUsername(usern,pass);  
        
        if(log==true){
           id=StudentsDAO.getStudentId(usern, pass);
           //username=usern;\
           System.out.println(id);
           response.sendRedirect("homepage.html");
        
        }
        else{
            out.println("Λανθασμένο όνομα χρήστη!");   
            out.println("<p><a href=\"index.html\">Προσπαθήστε ξανά</a></p>"); 
        }
        }catch(Exception e){
            e.printStackTrace();
        } 
        out.close();  
    }
}