/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static servlets.StudentLog.id;

public class Logout extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setCharacterEncoding("UTF-8");
       PrintWriter out=response.getWriter(); 
        try{
        response.setContentType("text/html");  
        
        out.println("<form action=\"Logout\" method=\"get\">");
        id=0;
        response.sendRedirect("index.html");
        
        }catch(Exception e){
            e.printStackTrace();
        } 
        out.close();  
    }
}
