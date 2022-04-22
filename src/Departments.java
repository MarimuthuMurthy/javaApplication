import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Scanner;
class CseDepartment{
    static String[] cseSubjects={"java","html","css"};
    static String[] faculty={"A","B","C"};
}
class EceDepartment{
    static String[] cseSubjects={"analog","system","communication"};
    static String[] ecefaculty={"D","E","F"};
}
class MechanicalDepartment{
    static String[] mechanicalSubjects={"weld","shield","mech3"};
    static String[] mechfaculty={"g","h","i"};
}
class ItDepartment{
    static String[] itSubjects={"javait","htmlit","cssit"};
    static String[] itfaculty={"j","k","l"};
}
class Student
{
    public int studentId;
    public String studentName;
    public String phoneNo;
    public int roomNo;
    public String hostelName;
    public String department;
    public String[] subject;
    public String[] faculty;
    public int[] marks;
    boolean marksAddorNot = true;
    Student(int studentId,String studentName,String phoneNo,int roomNo,String hostelName,String department,String[] subject,String[] faculty){
        this.studentId=studentId;
        this.studentName=studentName;
        this.phoneNo=phoneNo;
        this.hostelName=hostelName;
        this.roomNo=roomNo;
        this.department=department;
        this.subject= subject;
        this.faculty=faculty;
        marks=new int[subject.length];
    }
    public void getScore(){
        System.out.println( subject[0]+" "+marks[0]+" \n"+
                subject[1]+" "+marks[1]+" \n"+
                subject[2]+" "+marks[2]+" \n");
    }
    public String toString(){return studentId+" "+studentName+" "+phoneNo+" "+roomNo+" "+hostelName+" "+department;}
}
