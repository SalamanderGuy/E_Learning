package students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static servlets.StudentLog.id;
import static servlets.StudentLog.username;
public class StudentsDAO {
    
    public static Connection getConnection() {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db?autoReconnect=true&useSSL=false", "adm", "1234");
        } catch (ClassNotFoundException | SQLException ex) { 
            System.out.println("Connection exception");
        }
        return con;
    }
    
    public static int getStudentId(String usern,String pass){
        int id=-1;
        Connection con = StudentsDAO.getConnection();
      try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student_data WHERE username=? and pass=?");
            ps.setString(1,usern);
            ps.setString(2,pass); 
            ResultSet rs=ps.executeQuery();
            if(rs.next()){  
            id=rs.getInt(1);
            }
            
      }catch (SQLException ex) {    
        }
        return id;
    }
    
    public static Boolean getStudentbyUsername(String usern,String pass){
        boolean found=false;
        Students student = new Students();
        Connection con = StudentsDAO.getConnection();        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student_data WHERE username=? and pass=?");
            ps.setString(1,usern);
            ps.setString(2,pass);  
            ResultSet rs = ps.executeQuery();  
            if(rs.next()){  
                found=true;
            }  
            else{
                found=false;
            }
            con.close();  
        } catch (SQLException ex) {            
        }
        return found;
    } 
    
    public static int SaveGrade(int exam,float grade){
        int status = 0;
        Connection con = StudentsDAO.getConnection();
        try {
            if(exam==1){
                PreparedStatement ps = con.prepareStatement("UPDATE student_data SET exam1=? WHERE account_id=?");
                ps.setFloat(1,grade);
                ps.setInt(2,id);
                
                status=ps.executeUpdate();                
                con.close();
            }else if(exam==2){
                PreparedStatement ps = con.prepareStatement("UPDATE student_data SET exam2=? WHERE account_id=?");
                ps.setFloat(1,grade);
                ps.setInt(2,id);
                
                status=ps.executeUpdate();                
                con.close();
            }else if(exam==3){
                PreparedStatement ps = con.prepareStatement("UPDATE student_data SET exam3=? WHERE account_id=?");
                ps.setFloat(1,grade);
                ps.setInt(2,id);
                
                status=ps.executeUpdate();                
                con.close();
            }else if(exam==4){
                PreparedStatement ps = con.prepareStatement("UPDATE student_data SET finalexam=? WHERE account_id=?");
                ps.setFloat(1,grade);
                ps.setInt(2,id);
                
                status=ps.executeUpdate();                
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error while saving a grade");
        }
        return status;
    }
    
        public static Students getStudentStats(int iden) {
        Students st = new Students();
        Connection con = StudentsDAO.getConnection();      
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student_data WHERE account_id=?");
            ps.setInt(1,iden);  
            ResultSet rs = ps.executeQuery();  
            if(rs.next()){  
                st.setFirstname(rs.getString(2));
                st.setLastname(rs.getString(3));
                st.setUsername(rs.getString(4));
                st.setGrade1(rs.getFloat(6));
                st.setGrade2(rs.getFloat(7));
                st.setGrade3(rs.getFloat(8));
                st.setfinalGrade(rs.getFloat(9));
            }  
            con.close();  
        } catch (SQLException ex) {            
        }
        return st;
    } 
}
