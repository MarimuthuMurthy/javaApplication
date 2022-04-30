class Semester{
    int semesterNumber;
    int marks;
    SubjectWithMarks[] subject;
    Semester(int semesterNumber,SubjectWithMarks[] subject)
    {
        this.semesterNumber=semesterNumber;
        this.subject = subject;
    }
    public void setSemesterTotalMarks(int marks){
        this.marks=marks;
    }
}
class Subject{
    String subjectName;
    String department;
    int semester;
    int facultyId;
    Subject(String subjectName,String department,int semester ){
        this.subjectName=subjectName;
        this.department = department;
        this.semester = semester;
        this.facultyId=-1;
    }
    public void setFacultyId(int facultyId){
        this.facultyId=facultyId;
    }
}
class SubjectWithMarks extends Subject{
    int subjectMarks;
    SubjectWithMarks(String subjectName, String department, int semester,int marks) {
        super(subjectName, department, semester);
        this.subjectMarks=marks;
    }
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
    public void scoreCard(int semNumber){
        for(int i=0;i<semNumber;i++){
            System.out.println("******* SEMESTER "+(i+1)+" MARKS*******");
            for (SubjectWithMarks subject : semester[i].subject) {
                if(!(semester[i].subject[i].subjectMarks==-1)) {
                    System.out.println("Subject Name " + subject.subjectName + " SubjectScore :" + subject.subjectMarks);
                }else {
                    System.out.println("Subject " + subject.subjectName + " marks are not added");
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


