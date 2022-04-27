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
class CseSubjectsAndFaculty {
    static String[] cseSubjectsSemester1 = {"java", "html", "datastructures", "python", "c"};
    static String[] cseFacultySemester1 = {"cseFaculty 11", "cseFaculty 12", "cseFaculty 13", "cseFaculty 14", "cseFaculty 15"};
    static String[] cseSubjectsSemester2 = {"Fundamentals of Computer Programming", "Data Structures", "Computer Networks", "Object Oriented Programming", "Design and Analysis of Algorithms"};
    static String[] cseFacultySemester2 = {"cseFaculty 21", "cseFaculty 22", "cseFaculty 23", "cseFaculty 24", "cseFaculty 25"};
    static String[] cseSubjectsSemester3 = {"Computer Architecture and Organisation", "Discrete Mathematics", "Database Management Systems", "Operating Systems", "Software Engineering"};
    static String[] cseFacultySemester3 = {"cseFaculty 31", "cseFaculty 32", "cseFaculty 33", "cseFaculty 34", "cseFaculty 35"};
    static String[] cseSubjectsSemester4 = {"Theory of Computation", "Introduction to Communication Systems", "Multi-device Programming", "Advanced Java Programming", "Artificial Intelligence"};
    static String[] cseFacultySemester4 = {"cseFaculty 41", "cseFaculty 42", "cseFaculty 43", "cseFaculty 44", "cseFaculty 45"};
    static String[] cseSubjectsSemester5 = {"Artificial Neural Network", "Introduction to Soft Computing", "Introduction to Internet-Of-Things", "Statistical Modeling for Data Science", "Advanced Communication Networks"};
    static String[] cseFacultySemester5 = {"cseFaculty 51", "cseFaculty 52", "cseFaculty 53", "cseFaculty 54", "cseFaculty 55"};
    static String[] cseSubjectsSemester6 = {"High Performance Computing", "Introduction to Linear and Nonlinear Optimisation", "Wireless Sensor Networks and Applications", "Computer Vision", "Mobile Platform Programming"};
    static String[] cseFacultySemester6 = {"cseFaculty 61", "cseFaculty 62", "cseFaculty 63", "cseFaculty 64", "cseFaculty 65"};
    static String[] cseSubjectsSemester7 = {"Web Intelligence and Algorithms", "Machine Learning", "Computational Geometry and Applications", "Cyber Security", "Game Theory"};
    static String[] cseFacultySemester7 = {"cseFaculty 71", "cseFaculty 72", "cseFaculty 73", "cseFaculty 74", "cseFaculty 75"};
    static String[] cseSubjectsSemester8 = {"Introduction to Information Security", "Modeling and Simulation", "Information Retrieval", "Natural Language Processing", "Compiler Design"};
    static String[] cseFacultySemester8 = {"cseFaculty 81", "cseFaculty 82", "cseFaculty 83", "cseFaculty 84", "cseFaculty 85"};
}
class CseDepartment{
    static String[][] cseSubjects={CseSubjectsAndFaculty.cseSubjectsSemester1,CseSubjectsAndFaculty.cseSubjectsSemester2,CseSubjectsAndFaculty.cseSubjectsSemester3,CseSubjectsAndFaculty.cseSubjectsSemester4,CseSubjectsAndFaculty.cseSubjectsSemester5,CseSubjectsAndFaculty.cseSubjectsSemester6,CseSubjectsAndFaculty.cseSubjectsSemester7,CseSubjectsAndFaculty.cseSubjectsSemester8};
    static String[][] cseFaculties={CseSubjectsAndFaculty.cseFacultySemester1,CseSubjectsAndFaculty.cseFacultySemester2,CseSubjectsAndFaculty.cseFacultySemester3,CseSubjectsAndFaculty.cseFacultySemester4,CseSubjectsAndFaculty.cseFacultySemester5,CseSubjectsAndFaculty.cseFacultySemester6,CseSubjectsAndFaculty.cseFacultySemester7,CseSubjectsAndFaculty.cseFacultySemester8};
}
class EceSubjectsAndFaculty {
    static String[] eceSubjectsSemester1 = {"analog", "system", "communication", "wireless", "networks"};
    static String[] ecefacultySemester1 = {"eceFaculty 11", "eceFaculty 12", "eceFaculty 13", "eceFaculty 14", "eceFaculty 15"};
    static String[] eceSubjectsSemester2 = {"Analog Electronics", "Signal & System", "Electromagnetic Theory", "Digital Signal Processing", "Analog and Digital Communications"};
    static String[] ecefacultySemester2 = {"eceFaculty 21", "eceFaculty 22", "eceFaculty 23", "eceFaculty 24", "eceFaculty 25"};
    static String[] eceSubjectsSemester3 = {"Integrated Electronics", "Communication Network", "Antenna and Microwave Propagation", "Microprocessor & Microcontroller", "Fiber-Optic and Satellite Communications Systems"};
    static String[] ecefacultySemester3 = {"eceFaculty 31", "eceFaculty 32", "eceFaculty 33", "eceFaculty 34", "eceFaculty 35"};
    static String[] eceSubjectsSemester4 = {"Control Theory", "Coding and Information Theory", "Advanced Embedded Systems", "Advanced Digital Signal Processing", "Digital Image Processing+"};
    static String[] ecefacultySemester4 = {"eceFaculty 41", "eceFaculty 42", "eceFaculty 43", "eceFaculty 44", "eceFaculty 45"};
    static String[] eceSubjectsSemester5 = {"Wireless Broadband Communications", "Optical Networks", "Non-Linear Optical Communication", "Satellite Communications", "Advanced VLSI"};
    static String[] ecefacultySemester5 = {"eceFaculty 51", "eceFaculty 52", "eceFaculty 53", "eceFaculty 54", "eceFaculty 55"};
    static String[] eceSubjectsSemester6 = {"Internet of Things", "Computer Vision", "Power Electronics", "Radar Engineering", "Cellular and Mobile Communications"};
    static String[] ecefacultySemester6 = {"eceFaculty 61", "eceFaculty 62", "eceFaculty 63", "eceFaculty 64", "eceFaculty 65"};
    static String[] eceSubjectsSemester7 = {"Advanced Wireless Broadband Communications", "Networks", "Embedded", "Microprocessor", "Fiber"};
    static String[] ecefacultySemester7 = {"eceFaculty 71", "eceFaculty 72", "eceFaculty 73", "eceFaculty 74", "eceFaculty 75"};
    static String[] eceSubjectsSemester8 = {"Electronics", "Information", "Electromagnetic", "Digital", "Processing"};
    static String[] ecefacultySemester8 = {"eceFaculty 81", "eceFaculty 82", "eceFaculty 83", "eceFaculty 84", "eceFaculty 85"};
}
class EceDepartment{
    static String[][] eceSubjects={EceSubjectsAndFaculty.eceSubjectsSemester1,EceSubjectsAndFaculty.eceSubjectsSemester2,EceSubjectsAndFaculty.eceSubjectsSemester3,EceSubjectsAndFaculty.eceSubjectsSemester4,EceSubjectsAndFaculty.eceSubjectsSemester5,EceSubjectsAndFaculty.eceSubjectsSemester6,EceSubjectsAndFaculty.eceSubjectsSemester7,EceSubjectsAndFaculty.eceSubjectsSemester8};
    static String[][] eceFaculties={EceSubjectsAndFaculty.ecefacultySemester1,EceSubjectsAndFaculty.ecefacultySemester2,EceSubjectsAndFaculty.ecefacultySemester3,EceSubjectsAndFaculty.ecefacultySemester4,EceSubjectsAndFaculty.ecefacultySemester5,EceSubjectsAndFaculty.ecefacultySemester6,EceSubjectsAndFaculty.ecefacultySemester7,EceSubjectsAndFaculty.ecefacultySemester8};
}
class MechanicalSubjectsAndFaculty {
    static String[] mechanicalSubjectsSemester1 = {"Thermodynamics", "Solid Mechanics - I", "Engineering Materials", "HSS Elective - I", "Machine Drawing"};
    static String[] mechfacultySemester1 = {"mechFaculty 11", "mechfaculty 12", "mechfaculty 13", "mechFaculty 14", "mechFaculty 15"};
    static String[] mechanicalSubjectsSemester2 = {"Fluid Mechanics - I", "Manufacturing Technology - I", "Solid Mechanics - II", "Kinematics of Machinery", "HSS Elective  - II"};
    static String[] mechfacultySemester2 = {"mechFaculty 21", "mechfaculty 22", "mechfaculty 23", "mechFaculty 24", "mechFaculty 25"};
    static String[] mechanicalSubjectsSemester3 = {"Workshop  - II", "Mechanical Lab - I", "Fluid Mechanics - II", "Manufacturing Technology - II", "Dynamics of Machinery"};
    static String[] mechfacultySemester3 = {"mechFaculty 31", "mechfaculty 32", "mechfaculty 33", "mechFaculty 34", "mechFaculty 35"};
    static String[] mechanicalSubjectsSemester4 = {"Design of Machine Elements", "Electrical Machines", "HSS Elective - III", "Mechanical Lab -  II", "Applied Thermodynamics - I"};
    static String[] mechfacultySemester4 = {"mechFaculty 41", "mechfaculty 42", "mechfaculty 43", "mechFaculty 44", "mechFaculty 45"};
    static String[] mechanicalSubjectsSemester5 = {"Machine Design", "Mechanical Measurements", "Heat and Mass Transfer", "Control Systems", "Mechanical Lab - III"};
    static String[] mechfacultySemester5 = {"mechFaculty 51", "mechfaculty 52", "mechfaculty 53", "mechFaculty 54", "mechFaculty 55"};
    static String[] mechanicalSubjectsSemester6 = {"Design", "Mechanical", "Elective", "Workshop", "Applied"};
    static String[] mechfacultySemester6 = {"mechFaculty 61", "mechfaculty 62", "mechfaculty 63", "mechFaculty 64", "mechFaculty 65"};
    static String[] mechanicalSubjectsSemester7 = {"Fluid", "Design", "Measurements", "Technology", "theoryofmachines"};
    static String[] mechfacultySemester7 = {"mechFaculty 71", "mechfaculty 72", "mechfaculty 73", "mechFaculty 74", "mechFaculty 75"};
    static String[] mechanicalSubjectsSemester8 = {"Kinematics-1", "Dynamics ", "Elective", "Mass", "Systems"};
    static String[] mechfacultySemester8 = {"mechFaculty 81", "mechfaculty 82", "mechfaculty 83", "mechFaculty 84", "mechFaculty 85"};
}
class MechanicalDepartment{
    static String[][] mechSubjects={MechanicalSubjectsAndFaculty.mechanicalSubjectsSemester1,MechanicalSubjectsAndFaculty.mechanicalSubjectsSemester2,MechanicalSubjectsAndFaculty.mechanicalSubjectsSemester3,MechanicalSubjectsAndFaculty.mechanicalSubjectsSemester4,MechanicalSubjectsAndFaculty.mechanicalSubjectsSemester5,MechanicalSubjectsAndFaculty.mechanicalSubjectsSemester6,MechanicalSubjectsAndFaculty.mechanicalSubjectsSemester7,MechanicalSubjectsAndFaculty.mechanicalSubjectsSemester8};
    static String[][] mechFaculties={MechanicalSubjectsAndFaculty.mechfacultySemester1,MechanicalSubjectsAndFaculty.mechfacultySemester2,MechanicalSubjectsAndFaculty.mechfacultySemester3,MechanicalSubjectsAndFaculty.mechfacultySemester4,MechanicalSubjectsAndFaculty.mechfacultySemester5,MechanicalSubjectsAndFaculty.mechfacultySemester6,MechanicalSubjectsAndFaculty.mechfacultySemester7,MechanicalSubjectsAndFaculty.mechfacultySemester8};
}
class ItSubjectsAndFaculty {
    static String[] itSubjectsSemester1 = {"Computer", "Architecture", "Organization", "object", "orineted"};
    static String[] itfacultySemester1 = {"itFaculty 11", "itFaculty 12", "itfaculty 13", "itFaculty 14", "itFaculty 15"};
    static String[] itSubjectsSemester2 = {"programming", "Operating ", "Systems", "computer", "networks"};
    static String[] itfacultySemester2 = {"itFaculty 21", "itFaculty 22", "itfaculty 23", "itFaculty 24", "itFaculty 25"};
    static String[] itSubjectsSemester3 = {"Java", "Programming", "Website", "Design", "data"};
    static String[] itfacultySemester3 = {"itFaculty 31", "itFaculty 32", "itfaculty 33", "itFaculty 34", "itFaculty 35"};
    static String[] itSubjectsSemester4 = {"warehouse", "metadata", "datamining", "system", "software"};
    static String[] itfacultySemester4 = {"itFaculty 41", "itFaculty 42", "itfaculty 43", "itFaculty 44", "itFaculty 45"};
    static String[] itSubjectsSemester5 = {"Software", "Engineering", "e-commerce", "Database", "Systems"};
    static String[] itfacultySemester5 = {"itFaculty 51", "itFaculty 52", "itfaculty 53", "itFaculty 54", "itFaculty 55"};
    static String[] itSubjectsSemester6 = {"Design", "Analysis", "Algorithms", "Database", "Management"};
    static String[] itfacultySemester6 = {"itFaculty 61", "itFaculty 62", "itfaculty 63", "itFaculty 64", "itFaculty 65"};
    static String[] itSubjectsSemester7 = {"Systems", "multimedia", "communiaction", "oose", "microcontroller"};
    static String[] itfacultySemester7 = {"itFaculty 71", "itFaculty 72", "itfaculty 73", "itFaculty 74", "itFaculty 75"};
    static String[] itSubjectsSemester8 = {"engineering mathematics", "engineering", "graphics", "agile", "scrum"};
    static String[] itfacultySemester8 = {"itFaculty 81", "itFaculty 82", "itfaculty 83", "itFaculty 84", "itFaculty 85"};
}
class ItDepartment{
    static String[][] itTotalSubjects = {ItSubjectsAndFaculty.itSubjectsSemester1,ItSubjectsAndFaculty.itSubjectsSemester2,ItSubjectsAndFaculty.itSubjectsSemester3,ItSubjectsAndFaculty.itSubjectsSemester4,ItSubjectsAndFaculty.itSubjectsSemester5,ItSubjectsAndFaculty.itSubjectsSemester6,ItSubjectsAndFaculty.itSubjectsSemester7,ItSubjectsAndFaculty.itSubjectsSemester8};
    static String[][] itTotalFaculty  = {ItSubjectsAndFaculty.itfacultySemester1,ItSubjectsAndFaculty.itfacultySemester2,ItSubjectsAndFaculty.itfacultySemester3,ItSubjectsAndFaculty.itfacultySemester4,ItSubjectsAndFaculty.itfacultySemester5,ItSubjectsAndFaculty.itfacultySemester6,ItSubjectsAndFaculty.itfacultySemester6,ItSubjectsAndFaculty.itfacultySemester7,ItSubjectsAndFaculty.itfacultySemester8};

}
class Student
{
    public int studentId;
    public String studentName;
    public String phoneNo;
    public int roomNo;
    public String hostelName;
    public String department;
    public Address add;
    public Semester[] semester;
    Student(int studentId,String studentName,String phoneNo,int roomNo,String hostelName,String department,Address add,Semester[] semester){
        this.studentId=studentId;
        this.studentName=studentName;
        this.phoneNo=phoneNo;
        this.hostelName=hostelName;
        this.roomNo=roomNo;
        this.department=department;
        this.add=add;
        this.semester=semester;
    }
    public void scoreCard(){
        for(int i=0;i<semester.length && semester[i]!=null;i++){
            System.out.println("******* SEMESTER "+(i+1)+" MARKS*******");
            for (SubjectDetails subjectDetail : semester[i].subjectDetails) {
                if(!(subjectDetail.subjectMark==-1)) {
                    System.out.println("Subject Name " + subjectDetail.subjectName + " SubjectScore :" + subjectDetail.subjectMark);
                }else {
                    System.out.println("Subject " + subjectDetail.subjectName + " marks are not added");
                }
            }
            System.out.println("*************************************");
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
    SubjectDetails[] subjectDetails;
    Semester(int semesterNumber,SubjectDetails[] subjectDetails)
    {
        this.semesterNumber=semesterNumber;
        this.subjectDetails=subjectDetails;
    }
    public String toString(){
        return  "_____________________________________________"+
                "\n"+"Semester number : "+semesterNumber;
    }
}

