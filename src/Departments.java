import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Scanner;
class SubjectDetails{
    String subjectName;
    String subjectFaculty;
    int subjectMark;
    boolean subjectMarkAddorNOt=true;
    SubjectDetails(String subjectName,String subjectFaculty,int mark){
        this.subjectName=subjectName;
        this.subjectFaculty=subjectFaculty;
    }
    public void setSubjectName(int subjectMark)
    {
        if(subjectMark>=0)
        {
            this.subjectMark=subjectMark;
            subjectMarkAddorNOt=false;
        }
    }
}
class CseDepartment{
    static String[] cseSubjects={"JAVA","HTML","DATASTRUCTURES","PYTHON","C"};
    static String[] cseFaculty={"cseFaculty1","cseFaculty2","cseFaculty3","cseFaculty4","cseFaculty5"};
}
class EceDepartment{
    static String[] eceSubjects={"ANALOG","SYSTEM","COMMUNICATION","WIRELESS","NETWORKS"};
    static String[] ecefaculty={"eceFaculty1","eceFcaulty2","eceFaculty3","eceFaculty4","eceFaculty5"};
}
class MechanicalDepartment{
    static String[] mechanicalSubjects={"THERMODYNAMICS","MACHINEDESIGN","FLUIDMECHANICS","SOLIDMECHANICS","THEORYOFMACHINES"};
    static String[] mechfaculty={"mechFaculty1","mechfaculty2","mechfaculty3","mechFaculty4","mechFaculty5"};
}
class ItDepartment{
    static String[] itSubjects={"SYSTEMSOFTWARE","INTERNETPROGRAMMING","OPERATINGSYSTEM","OBJECTORIENTEDPROGRAMMING","DATAWAREHOUSING"};
    static String[] itfaculty={"itFcaulty1","itfcaulty2","itfaculty3","itFaculty4","itFaculty5"};
}
class Student
{
    public int studentId;
    public String studentName;
    public String phoneNo;
    public int roomNo;
    public String hostelName;
    public String department;
    public  SubjectDetails[] subjectDetails;
    Student(int studentId,String studentName,String phoneNo,int roomNo,String hostelName,String department,String[] subject,String[] faculty,SubjectDetails[] subjectDetails){
        this.studentId=studentId;
        this.studentName=studentName;
        this.phoneNo=phoneNo;
        this.hostelName=hostelName;
        this.roomNo=roomNo;
        this.department=department;
        this.subjectDetails =subjectDetails;
    }
    public void ScoreCard()
    {
        for (SubjectDetails subjectDetail : subjectDetails) {
            if(!subjectDetail.subjectMarkAddorNOt) {
                System.out.println("Subject Name " + subjectDetail.subjectName + " SubjectScore :" + subjectDetail.subjectMark);
            }else{System.out.println("Subject " + subjectDetail.subjectName + " marks are not added");}

        }
    }
    public String toString(){return
                            "**********************************"+
                            " \n"+"Student Id :" + studentId+
                            " \n"+"Student Name :"+studentName+
                            " \n"+"Student PhoneNO. :"+phoneNo+
                            " \n"+"Student RoomNo :"+roomNo+" "+
                            " \n"+"Student Hostel :"+hostelName+
                            " \n"+"Student Department :"+department+
                            " \n"+"*********************************";
                            }
}
