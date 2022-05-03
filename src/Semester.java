public class Semester{
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
