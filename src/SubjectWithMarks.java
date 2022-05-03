public class SubjectWithMarks extends Subject{
    int subjectMarks;
    SubjectWithMarks(String subjectName, String department, int semester,int marks) {
        super(subjectName, department, semester);
        this.subjectMarks=-1;
    }
}
