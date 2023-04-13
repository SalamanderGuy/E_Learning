package students;


public class Students {
    
    private int id;
    private String firstname,lastname,username,password;
    private float grade1,grade2,grade3,finalgrade;
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float get1Grade() {
        return grade1;
    }

    public void setGrade1(float grade) {
        this.grade1 = grade;
    }
    
    public float getGrade2() {
        return grade2;
    }

    public void setGrade2(float grade) {
        this.grade2 = grade;
    }
    
    public float getGrade3() {
        return grade3;
    }

    public void setGrade3(float grade) {
        this.grade3 = grade;
    }
    
    public float getfinalGrade() {
        return finalgrade;
    }

    public void setfinalGrade(float grade) {
        this.finalgrade = grade;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String usern) {
        this.username = usern;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }
    
}

