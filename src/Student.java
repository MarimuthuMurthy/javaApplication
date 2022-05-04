public class Student implements StudentScoreCard{
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

    @Override
    public void scoreCard(int semNumber) {
        for(int i=0;i<semNumber;i++){
            System.out.println("******* SEMESTER "+(i+1)+" MARKS*******");
            for (SubjectWithMarks subject : semester[i].subject) {
                if(subject.subjectMarks!=-1) {
                    System.out.println("Subject Name " + subject.subjectName + " SubjectScore :" + subject.subjectMarks);
                }else {
                    System.out.println("Subject " + subject.subjectName + " marks are not added");
                }
            }
            System.out.println("*************************************");
        }
    }
}
