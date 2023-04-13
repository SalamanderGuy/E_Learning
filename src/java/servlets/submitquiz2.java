package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import students.StudentsDAO;


public class submitquiz2 extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setCharacterEncoding("UTF-8");
       PrintWriter out=response.getWriter(); 
        try{
        response.setContentType("text/html");  
        
        out.println("<form action=\"submitquiz2\" method=\"get\">");
         
        String gr=request.getParameter("grade");
        int status=StudentsDAO.SaveGrade(2, (float) Double.parseDouble(gr));
        
        if(status>0){  
            response.setCharacterEncoding("UTF-8");
            
            response.setContentType("text/html");  
            //out.print("<p>Επιτυχής αποθήκευση</p>");  
            //request.getRequestDispatcher("homepage.html").include(request, response); 
            response.sendRedirect("homepage.html");
            }
        else{
            out.println("Error saving grade to the database!");
            }
        
        }catch(Exception e){
            e.printStackTrace();
        } 
        out.close();  
    }
}
