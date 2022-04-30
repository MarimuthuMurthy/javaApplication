import java.util.*;
class Faculty{
    int facultyId;
    String facultyName;
    String departmentName;
    List<Subject> subject;
    Faculty(int facultyId,String facultyName,List<Subject> subject,String departmentName){
        this.facultyId=facultyId;
        this.facultyName=facultyName;
        this.subject=subject;
        this.departmentName=departmentName;
    }
}
