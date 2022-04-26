import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
class SubjectDetails{
    String subjectName;
    String subjectFaculty;
    int subjectMark;
    SubjectDetails(String subjectName,String subjectFaculty,int mark){
        this.subjectName=subjectName;
        this.subjectFaculty=subjectFaculty;
        this.subjectMark=-1;
    }
    public void setSubjectMark(int subjectMark)
    {
        if(subjectMark>=0)
        {
            this.subjectMark=subjectMark;
        }
    }
}
class CseDepartment{
    static int fees=2000000;
    static String[] cseSubjects={"JAVA","HTML","DATASTRUCTURES","PYTHON","C"};
    static String[] cseFaculty={"cseFaculty1","cseFaculty2","cseFaculty3","cseFaculty4","cseFaculty5"};
}
class EceDepartment{
    static int fees=1500000;
    static String[] eceSubjects={"ANALOG","SYSTEM","COMMUNICATION","WIRELESS","NETWORKS"};
    static String[] ecefaculty={"eceFaculty1","eceFcaulty2","eceFaculty3","eceFaculty4","eceFaculty5"};
}
class MechanicalDepartment{
    static int fees=1250000;
    static String[] mechanicalSubjects={"THERMODYNAMICS","MACHINEDESIGN","FLUIDMECHANICS","SOLIDMECHANICS","THEORYOFMACHINES"};
    static String[] mechfaculty={"mechFaculty1","mechfaculty2","mechfaculty3","mechFaculty4","mechFaculty5"};
}
class ItDepartment{
    static int fees=1200000;
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
    public int academicFee;
    Student(int studentId,String studentName,String phoneNo,int roomNo,String hostelName,String department,String[] subject,String[] faculty,SubjectDetails[] subjectDetails,int academicFee){
        this.studentId=studentId;
        this.studentName=studentName;
        this.phoneNo=phoneNo;
        this.hostelName=hostelName;
        this.roomNo=roomNo;
        this.department=department;
        this.subjectDetails =subjectDetails;
        this.academicFee=academicFee;
    }
    public void ScoreCard()
    {
        for (SubjectDetails subjectDetail : subjectDetails) {
            if(!(subjectDetail.subjectMark==-1)) {
                System.out.println("Subject Name " + subjectDetail.subjectName + " SubjectScore :" + subjectDetail.subjectMark);
            }else{System.out.println("Subject " + subjectDetail.subjectName + " marks are not added");}

        }
    }
    public String toString(){
        return "***********************************"+
                " \n"+"Student Id :" + studentId+
                " \n"+"Student Name :"+studentName+
                " \n"+"Student PhoneNO. :"+phoneNo+
                " \n"+"Student RoomNo :"+roomNo+" "+
                " \n"+"Student Hostel :"+hostelName+
                " \n"+"Student Department :"+department+
                " \n"+"Student paid fees :"+academicFee+
                " \n"+"*********************************";
    }
}
