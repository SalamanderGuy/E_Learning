package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static servlets.StudentLog.id;
import students.Students;
import students.StudentsDAO;


public class statistics extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter(); 
        try{
        response.setContentType("text/html");  
        
        out.println("<form action=\"statistics\" method=\"get\">");
        Students st=StudentsDAO.getStudentStats(id);
        
        if(st.getFirstname()!= null){
            out.println("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "\n" +
            "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\n" +
            "        integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n" +
            "        crossorigin=\"anonymous\"></script>\n" +
            "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js\"\n" +
            "        integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\n" +
            "        crossorigin=\"anonymous\"></script>\n" +
            "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js\"\n" +
            "        integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\n" +
            "        crossorigin=\"anonymous\"></script>\n" +
            "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
            "        integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
            "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
            "    <title>e-Learning</title>\n" +
            "    <link rel=\"icon\" type=\"image/x-icon\" href=\"icon.png\">\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "    <div class=\"container\">\n" +
            "        <nav class=\"navbar navbar-expand-sm\" style=\"border-bottom: 1px solid #aaa\">\n" +
            "            <a class=\"navbar-brand\" href=\"homepage.html\">\n" +
            "                <img src=\"icon.png\" width=\"40\" height=\"40\" class=\"d-inline-block align-top\" alt=\"\">\n" +
            "                e-Learning\n" +
            "            </a>\n" +
            "            <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n" +
            "                <ul class=\"navbar-nav\">\n" +
            "                    <li class=\"nav-item dropdown\">\n" +
            "                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" data-toggle=\"dropdown\"\n" +
            "                            role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
            "                            Κεφάλαια\n" +
            "                        </a>\n" +
            "                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n" +
            "                            <a class=\"dropdown-item\" href=\"chapter_1.html\">Κεφάλαιο 1 - Εισαγωγή στους Αλγορίθμους</a>\n" +
            "                            <a class=\"dropdown-item\" href=\"chapter_2.html\">Κεφάλαιο 2 - Εισαγωγή στην C</a>\n" +
            "                            <a class=\"dropdown-item\" href=\"chapter_3.html\">Κεφάλαιο 3 - Η γλώσσα C σε βάθος</a>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li class=\"nav-item dropdown\">\n" +
            "                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\"\n" +
            "                            aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
            "                            Διαγωνίσματα\n" +
            "                        </a>\n" +
            "                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n" +
            "                            <a class=\"dropdown-item\" href=\"quiz1.html\">Διαγώνισμα 1 - Εισαγωγή στους Αλγορίθμους</a>\n" +
            "                            <a class=\"dropdown-item\" href=\"quiz2.html\">Διαγώνισμα 2 - Εισαγωγή στην C</a>\n" +
            "                            <a class=\"dropdown-item\" href=\"quiz3.html\">Διαγώνισμα 3 - Η γλώσσα C σε βάθος</a>\n" +
            "                            <div class=\"dropdown-divider\"></div>\n" +
            "                            <a class=\"dropdown-item\" href=\"quiz4.html\">Τελικό Διαγώνισμα - Επαναληπτικό</a>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li class=\"nav-item\">\n" +
            "                        <a class=\"nav-link\" href=\"statistics\">Στατιστικά</a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </nav>");
            
            

        
        out.println("<div class=\"typewriter\"> <h2>My stats</h2>\n" +
"</div>");  
        
        //Δημιουργούμε το πίνακα εμφάνισης των στοιχείων
        out.print("<table class=\"table\" ");  
        out.print("<tr><th>First Name</th><th>Last Name</th><th>Username</th><th>Quiz 1</th><th>Quiz 2</th><th>Quiz 3</th><th>Final Quiz</th></tr>");  
      
        out.print("<tr><td>"
                 + st.getFirstname() + "</td><td>"
                 + st.getLastname() + "</td><td>"
                 + st.getUsername() + "</td><td>"
                 + st.get1Grade() +  "</td><td>" 
                 + st.getGrade2() + "</td><td>"
                 + st.getGrade3() +  "</td><td>"
                 +st.getfinalGrade()+  "</td><td>");  
        }  
        out.print("</table>");
            
        }catch(Exception e){
            e.printStackTrace();
        } 
        out.close();  
    }

}