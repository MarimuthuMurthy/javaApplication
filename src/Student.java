public class Student {
    public int studentId;
    public String studentName;
    public String phoneNo;
    public String department;
    public Address add;
    public Semester[] semester;
    public stayLocation transport;
    Student(int studentId,String studentName,String phoneNo,stayLocation transport,String department,Address add,Semester[] semester){
        this.studentId=studentId;
        this.studentName=studentName;
        this.phoneNo=phoneNo;
        this.transport = transport;
        this.department=department;
        this.add=add;
        this.semester=semester;
    }
    public String toString(){
        return "***********************************"+
                " \n"+"Student Id :" + studentId+
                " \n"+"Student Name :"+studentName+
                " \n"+"Student PhoneNO. :"+phoneNo+
                " \n"+"Student RoomNo :"+transport.toString()+
                " \n"+"Student Department :"+department+
                " \n"+"*********************************";
    }
}
