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
    static int fees=200000;
    static String[] cseSubjects={"JAVA","HTML","DATASTRUCTURES","PYTHON","C"};
    static String[] cseFaculty={"cseFaculty1","cseFaculty2","cseFaculty3","cseFaculty4","cseFaculty5"};
}
class EceDepartment{
    static int fees=150000;
    static String[] eceSubjects={"ANALOG","SYSTEM","COMMUNICATION","WIRELESS","NETWORKS"};
    static String[] ecefaculty={"eceFaculty1","eceFcaulty2","eceFaculty3","eceFaculty4","eceFaculty5"};
}
class MechanicalDepartment{
    static int fees=125000;
    static String[] mechanicalSubjects={"THERMODYNAMICS","MACHINEDESIGN","FLUIDMECHANICS","SOLIDMECHANICS","THEORYOFMACHINES"};
    static String[] mechfaculty={"mechFaculty1","mechfaculty2","mechfaculty3","mechFaculty4","mechFaculty5"};
}
class ItDepartment{
    static int fees=120000;
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
    public Address add;
    public Semester[] semester;
    Student(int studentId,String studentName,String phoneNo,int roomNo,String hostelName,String department,SubjectDetails[] subjectDetails,Address add,Semester[] semester){
        this.studentId=studentId;
        this.studentName=studentName;
        this.phoneNo=phoneNo;
        this.hostelName=hostelName;
        this.roomNo=roomNo;
        this.department=department;
        this.subjectDetails =subjectDetails;
        this.add=add;
        this.semester=semester;
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
                " \n"+"*********************************";
    }
}
class Address{
    String doorNo;
    String street;
    String city;
    String state;
    Address(String doorNo,String street,String city,String state){
        this.doorNo=doorNo;
        this.state=state;
        this.street=street;
        this.city=city;
    }
    public String toString(){
        return  "*******ADDRESS*******"+
                "\n"+"Door number : "+doorNo+
                "\n"+"street Name : "+street+
                "\n"+"city Name   : "+city+
                "\n"+"state       : "+state+
                "\n"+"********************";
    }
}
class Semester{
    int semesterNumber;
    int semesterMarks;
    double semesterFee;
    Semester(int semesterNumber,int semesterMarks)
    {
        this.semesterNumber=semesterNumber;
        this.semesterMarks=semesterMarks;
    }
    public void setSemesterFee(double semesterFee){
        this.semesterFee=semesterFee;
    }
    public String toString(){
        return  "_____________________________________________"+
                "\n"+"Semester number : "+semesterNumber+" semester marks "+semesterMarks;
    }
}

