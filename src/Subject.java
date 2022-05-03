public class Subject{
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