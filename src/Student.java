public class Student {
    public int studentId;
    public String studentName;
    public String phoneNo;
    public String department;
    public Address homeLocation;
    public Semester[] semester;
    public stayLocation stayLocation;
    Student(int studentId,String studentName,String phoneNo,stayLocation stayLocation,String department,Address homeLocation,Semester[] semester){
        this.studentId=studentId;
        this.studentName=studentName;
        this.phoneNo=phoneNo;
        this.stayLocation = stayLocation;
        this.department=department;
        this.homeLocation=homeLocation;
        this.semester=semester;
    }
    public String toString(){
        return "***********************************"+
                " \n"+"Student Id :" + studentId+
                " \n"+"Student Name :"+studentName+
                " \n"+"Student PhoneNO. :"+phoneNo+
                " \n"+"Student RoomNo :"+stayLocation.toString()+
                " \n"+"Student Department :"+department+
                " \n"+"*********************************";
    }
}
