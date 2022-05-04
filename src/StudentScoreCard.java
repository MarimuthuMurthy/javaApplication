class StudentScoreCard
{
    public static void scoreCard(Student s)
     {
         int semNumber = JavaApplication.findSemesterNumber(s);
        for(int i=0;i<semNumber;i++){
            System.out.println("******* SEMESTER "+(i+1)+" MARKS*******");
            for (SubjectWithMarks subject : s.semester[i].subject) {
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
