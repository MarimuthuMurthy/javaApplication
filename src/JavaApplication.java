
import java.util.*;
class StudentException extends Exception{
    StudentException(String hostel)
    {
        super(hostel);
    }
}
final class Validation
{
    final private String email1="vtu15892@veltech.edu.in";
    final private String password1="abc@1";
    final private String email2="vtu15893veltech.edu.in";
    final private String password2="abc@12";
    final private String email3="vtu15894@veltech.edu.in";
    final private String password3="abc@123";
    final private String email4="vtu15895@veltech.edu.in";
    final private String password4="abc@1234";
    final private String email5="vtu15896@veltech.edu.in";
    final private String password5="abc@12345";
    final private HashMap<String,String> lhs=new LinkedHashMap<>();
    final private String authorization="5656";
    Validation()
    {
        lhs.put(email1,password1);
        lhs.put(email2,password2);
        lhs.put(email3,password3);
        lhs.put(email4,password4);
        lhs.put(email5,password5);
    }
    Set<String> keys=lhs.keySet();
    public int checkCredentials(String email,String password)
    {
        for(String key:keys)
        {
            if(key.equals(email) && lhs.get(key).equals(password))
            {
                return 1;
            }
        }
        return 0;
    }
    public int checkAuthorization(String updateAuthorization)
    {
        if(updateAuthorization.equals(authorization)){return 1;}else{return 0;}
    }
}
public class JavaApplication {
    public static int studentId =0;
    static int count=0;
    static boolean checking=true;
    static boolean end=true;
    public static Scanner sc=new Scanner(System.in);
    public static ArrayList<Faculty> faculty = new ArrayList<>();

    static{
        facultyIntializer();
    }
   public static boolean checkRoomNo(String roomNo){
        return roomNo.matches("\\d{1,9}");}
    public static  String checkStudentId(String studentId){
        while(!(studentId.matches("\\d+"))){
            System.out.print("StudentId is Invalid , Re enter studentId : ");
            studentId=sc.next();
        }return studentId;
    }
    public static Student checkStudent(int id){
        for(Student student:StudentDetails.studentDetails){
            if(student.studentId==id){
                return student;
            }
        }return null;
    }
    public static void facultyIntializer(){
        String[] subjects;
        for(int j=0;j<8;j++) {
            subjects = CseDepartment.cseSubjects[j];
            for (String s : subjects) {
                Subject subject = new Subject(s, "cse", j);
                SubjectDetails.subjectDetails.add(subject);
            }
        }
        for(int j=0;j<8;j++) {
            subjects = EceDepartment.eceSubjects[j];
            for (String s : subjects) {
                Subject subject = new Subject(s, "ece", j);
                SubjectDetails.subjectDetails.add(subject);
            }
        }
        for(int j=0;j<8;j++) {
            subjects = MechanicalDepartment.mechanicalSubjects[j];
            for (String s : subjects) {
                Subject subject = new Subject(s, "mech", j);
                SubjectDetails.subjectDetails.add(subject);
            }
        }
        for(int j=0;j<8;j++) {
            subjects = ItDepartment.itTotalSubjects[j];
            for (String s : subjects) {
                Subject subject = new Subject(s, "it", j);
                SubjectDetails.subjectDetails.add(subject);
            }
        }
    }
    public static void facultySelection(String departmentName , int semester){
        Faculty[] faculty;
        String[] subjects;
       if(departmentName.equals("cse")) {
           subjects = CseDepartment.cseSubjects[semester - 1];
           for (int j = 0; j < subjects.length; j++) {
               System.out.println("type.... " + j + " for modifying " + subjects[j] + " faculty");
           }
           int facultySelection = sc.nextInt();
           System.out.println("press 1 : for adding name " + "\n" + "press 2 : for removing name");
           int option = sc.nextInt();
           String facultyName = CseDepartment.cseFaculties[semester - 1][facultySelection].facultyName;
           switch (option) {
               case 1:
                   if (facultyName == null) {
                       System.out.println(" Enter Faculty Name : ");
                       CseDepartment.cseFaculties[semester - 1][facultySelection].facultyName=sc.next();
                       System.out.println(" faculty added successfully ");
                   } else {
                       System.out.println("faculty is already present!!!!we cant add");
                   }
                   break;
               case 2:
                   if (facultyName != null) {
                       CseDepartment.cseFaculties[semester - 1][facultySelection].facultyName=null;
                       System.out.println(" faculty removed successfully ");
                   } else {
                       System.out.println("faculty slot is empty!!!!we cant remove");
                   }
                   break;
           }
       }
        if(departmentName.equals("ece")) {
            subjects = EceDepartment.eceSubjects[semester - 1];
            for (int j = 0; j < subjects.length; j++) {
                System.out.println("type.... " + j + " for modifying " + subjects[j] + " faculty");
            }
            int facultySelection = sc.nextInt();
            System.out.println("press 1 : for adding name " + "\n" + "press 2 : for removing name");
            int option = sc.nextInt();
            String facultyName = EceDepartment.eceFaculties[semester - 1][facultySelection].facultyName;
            switch (option) {
                case 1:
                    if (facultyName == null) {
                        System.out.println(" Enter Faculty Name : ");
                        EceDepartment.eceFaculties[semester - 1][facultySelection].facultyName=sc.next();
                        System.out.println(" faculty added successfully ");
                    } else {
                        System.out.println("faculty is already present!!!!we cant add");
                    }
                    break;
                case 2:
                    if (facultyName != null) {
                        EceDepartment.eceFaculties[semester - 1][facultySelection].facultyName=sc.next();
                        System.out.println(" faculty removed successfully ");
                    } else {
                        System.out.println("faculty slot is empty!!!!we cant remove");
                    }
                    break;
            }
        }
        if(departmentName.equals("mech")) {
            subjects = MechanicalDepartment.mechanicalSubjects[semester - 1];
            for (int j = 0; j < subjects.length; j++) {
                System.out.println("type.... " + j + " for modifying " + subjects[j] + " faculty");
            }
            int facultySelection = sc.nextInt();
            System.out.println("press 1 : for adding name " + "\n" + "press 2 : for removing name");
            int option = sc.nextInt();
            String facultyName = MechanicalDepartment.mechanicalFaculties[semester - 1][facultySelection].facultyName;
            switch (option) {
                case 1:
                    if (facultyName == null) {
                        System.out.println(" Enter Faculty Name : ");
                        MechanicalDepartment.mechanicalFaculties[semester - 1][facultySelection].facultyName=sc.next();
                        System.out.println(" faculty added successfully ");
                    } else {
                        System.out.println("faculty is already present!!!!we cant add");
                    }
                    break;
                case 2:
                    if (facultyName != null) {
                        MechanicalDepartment.mechanicalFaculties[semester - 1][facultySelection].facultyName=null;
                        System.out.println(" faculty removed successfully ");
                    } else {
                        System.out.println("faculty slot is empty!!!!we cant remove");
                    }
                    break;
            }
        }
        if(departmentName.equals("it")) {
            subjects = ItDepartment.itTotalSubjects[semester - 1];
            for (int j = 0; j < subjects.length; j++) {
                System.out.println("type.... " + j + " for modifying " + subjects[j] + " faculty");
            }
            int facultySelection = sc.nextInt();
            System.out.println("press 1 : for adding name " + "\n" + "press 2 : for removing name");
            int option = sc.nextInt();
            String facultyName = ItDepartment.itFaculties[semester - 1][facultySelection].facultyName;
            switch (option) {
                case 1:
                    if (facultyName == null) {
                        System.out.println(" Enter Faculty Name : ");
                        ItDepartment.itFaculties[semester - 1][facultySelection].facultyName=null;
                        System.out.println(" faculty added successfully ");
                    } else {
                        System.out.println("faculty is already present!!!!we cant add");
                    }
                    break;
                case 2:
                    if (facultyName != null) {
                        ItDepartment.itFaculties[semester - 1][facultySelection].facultyName=null;
                        System.out.println(" faculty removed successfully ");
                    } else {
                        System.out.println("faculty slot is empty!!!!we cant remove");
                    }
                    break;
            }
        }
    }
    public static void findStudentUnderFaculty(int FacultyId){
        if(StudentDetails.studentDetails.isEmpty()){
            System.out.println("**STUDENTS RECORDS NOT FOUND**");
        }else {
            for(Student student:StudentDetails.studentDetails){
                for(int i=0;i<8;i++) {
                    int totalSem1Subjects = student.semester[i].subject.length;
                    for(int j=0;j<totalSem1Subjects;j++){
                        if(student.semester[i].subject[j].facultyId==FacultyId){
                            System.out.println(student);
                        }
                    }
                }
            }
        }
    }
    public static int findSemesterNumber(Student s){
        int count=0;
        for(int i=0;i<s.semester.length&&s.semester[i]!=null;i++){
            count++;
        }
        return  count;
    }
    public static void semesterTotalMarks(Student s,int semNumber){
        for(int i=0;i<semNumber;i++){
            if(s.semester[i].marks!=-1 && s.semester[i].marks!=-2){
                System.out.println("Your "+(i+1)+" Semester marks are "+s.semester[i].marks);
            }
            else if(s.semester[i].marks==-1 || s.semester[i].marks==-2){
                System.out.println("Your "+(i+1)+" Semester marks are incomplete REASON: (*****subjects marks are not added or subjects have arrear*****)");
            }
        }
    }
    public static SubjectWithMarks[] matchSemesterAndDepartment(String departmentName,int semester){
        SubjectWithMarks[] subjects;
        switch (departmentName) {
            case "cse": {
                String[] subject = CseDepartment.cseSubjects[semester];
                subjects=new SubjectWithMarks[subject.length];
                for (int i = 0; i < subject.length; i++) {
                    subjects[i] = new SubjectWithMarks( subject[i],departmentName,semester,-1);
                }
                return subjects;
            }
            case "ece": {
                String[] subject = EceDepartment.eceSubjects[semester];
                subjects=new SubjectWithMarks[subject.length];
                for (int i = 0; i < subject.length; i++) {
                    subjects[i] = new SubjectWithMarks(subject[i],departmentName,semester,-1);
                }
                return subjects;
            }
            case "mech": {
                String[] subject = MechanicalDepartment.mechanicalSubjects[semester];
                subjects=new SubjectWithMarks[subject.length];
                for (int i = 0; i < subject.length; i++) {
                    subjects[i] = new SubjectWithMarks(subject[i],departmentName,semester,-1);
                }
                return subjects;
            }
            default: {
                String[] subject = ItDepartment.itTotalSubjects[semester];
                subjects=new SubjectWithMarks[subject.length];
                for (int i = 0; i < subject.length; i++) {
                    subjects[i] = new SubjectWithMarks(subject[i],departmentName,semester,-1);
                }
                return subjects;
            }
        }
    }
    public static void updateSemester(Student student){
        int semNumber = findSemesterNumber(student);
        System.out.println("Your semester marks are recorded till semester number "+(semNumber-1));
        System.out.println("Enter your present semester : ");
        System.out.println(
                "press 1 : semester 1"+"\n"+
                "press 2 : semester 2"+"\n"+
                "press 3 : semester 3"+"\n"+
                "press 4 : semester 4"+"\n"+
                "press 5 : semester 5"+"\n"+
                "press 6 : semester 6"+"\n"+
                "press 7 : semester 7"+"\n"+
                "press 8 : semester 8"+"\n");
        int select = sc.nextInt() ;
        while (select > 8 || select < 0) {
            System.out.println("please select correct semester");
            select = sc.nextInt() - 1;
        }
        if(select==semNumber){
            System.out.println("we_can't_update_because_you_are_studying_same_semester");
        }
        else if(select<semNumber){
            System.out.println("you_cant_select_your_previous_semester ");
        }
        else{
            for(int i=semNumber-1;i<select;i++){
                student.semester[i]=new Semester(i,matchSemesterAndDepartment(student.department,i));
            }
        }
    }
    public static int checkMarks(){
        System.out.print("enter marks :");
        int marks = sc.nextInt();
        while(marks < 0 ||marks >100){
            System.out.println("Invalid marks ......reenter marks again");
            marks=sc.nextInt();
        }
            return marks;
    }
    public static boolean wantAddMarksOrNot(){
        System.out.println("press 1 : if you want to add marks ");
        System.out.println("press 2 : if you dont want to add marks ");
        String option = sc.next();
        while(!option.matches("[1-2]")){
            System.out.println("please enter correct option");
        }
        return option.equals("1");
   }
    public static Student getDetails() throws StudentException
    {
        System.out.println("Welcome!!!!...please Enter the Student Detail....");
        System.out.print("Enter student name:");
        sc.nextLine();
        String studentName = sc.nextLine();

        while (!studentName.matches("[A-Za-z.\\s]*")) {
            System.out.println("Invalid name! please enter again");
            studentName = sc.nextLine();
        }
        System.out.print("Enter student phone number: +91");
        String studentPhone = sc.next();
        while (!studentPhone.matches("[0-9]{10}")) {
            System.out.println(" Invalid Phone Number! please enter again ");
            studentPhone = sc.next();
        }
        System.out.println(" Please Enter Your Address Details ");
        System.out.print("Enter DoorNumber : ");
        sc.nextLine();
        String doorNumber = sc.nextLine();
        System.out.print("Enter StreetName : ");
        String streetName = sc.nextLine();
        System.out.print("Enter city Name : ");
        String cityName = sc.nextLine();
        System.out.print("Enter State Name : ");
        String stateName = sc.nextLine();
        System.out.println(" Select Your Favourite Hostel ");
        System.out.println( "press 1:Prince hostel"+
                           "\n"+"press 2:Leaders hostel");
        String studentHostel = sc.next();
        int studentHostel1=Integer.parseInt(studentHostel);
        switch(studentHostel1){
            case 1:
                studentHostel="prince";
                break;
            case 2:
                studentHostel="leaders";
                break;
            default:
                throw new StudentException(" Sorry! you are not allowed in this institute ");
        }
        System.out.print("Enter student room no:");
        String studentRoom = sc.next();
        while (!checkRoomNo(studentRoom)) {
            System.out.print("Invalid Room Number! please enter again");
            studentRoom = sc.next();
        }
        int intStudentRoom=Integer.parseInt(studentRoom);
        Semester[] semester=new Semester[8] ;
        System.out.println(" Select Current Study Year   ");
        System.out.println("press 1 : 1st year"+"\n"+"press 2 : 2nd year"+"\n"+"press 3 : 3rd year"+"\n"+"press 4 : 4th year");
        int select = sc.nextInt();
        System.out.println("select department "+
                "\n"+"press 1: CSE.........."+
                "\n"+"press 2: ECE.........."+
                "\n"+"press 3: MECH........."+
                "\n"+"press 4: IT...........");
        String departmentName=sc.next();
        int departmentName1=Integer.parseInt(departmentName);
        switch(departmentName1){
            case 1:
                departmentName="cse";
                break;
            case 2:
                departmentName="ece";
                break;
            case 3:
                departmentName="mech";
                break;
            case 4:
                departmentName="it";
                break;
            default:
                throw new StudentException("sorry!!!other departments students are allowed");
        }
        boolean end1=true;
        while(end1) {
            switch (select) {
                case 1:
                    System.out.println("   select semester   ");
                    System.out.println("press 1: 1st semester");
                    System.out.println("press 2: 2nd semester");
                    int selectSem = sc.nextInt();
                    boolean end2= true;
                    while(end2) {
                        switch (selectSem) {
                            case 1:
                                semester[0] = new Semester( 1, matchSemesterAndDepartment(departmentName,0));
                                end2=false;
                                break;
                            case 2:
                                for (int i = 0; i < 2; i++) {
                                    semester[i] = new Semester(i + 1, matchSemesterAndDepartment(departmentName,i));
                                }
                                end2=false;
                                break;
                            default:
                                System.out.println("*****Select Valid Semester*****");
                        }
                    }
                    end1=false;
                    break;
                case 2:
                    System.out.println("    Select Semester   ");
                    System.out.println("press 1 : 3rd semester");
                    System.out.println("press 2 : 4th semester");
                    boolean end3=true;
                    while(end3) {
                        int selectSem1 = sc.nextInt();
                        switch (selectSem1) {
                            case 1:
                                for (int i = 0; i < 3; i++) {
                                    semester[i] = new Semester(i + 1, matchSemesterAndDepartment(departmentName,i));
                                }
                                end3=false;
                                break;
                            case 2:
                                for (int i = 0; i < 4; i++) {
                                    semester[i] = new Semester(i + 1, matchSemesterAndDepartment(departmentName,i));
                                }
                                end3=false;
                                break;
                            default:
                                System.out.println("*******INVALID SEMESTER******");
                        }
                    }
                    end1=false;
                    break;
                case 3:
                    System.out.println("    Select Semester   ");
                    System.out.println("press 1 : 5rd semester");
                    System.out.println("press 2 : 6th semester");
                    boolean end4=true;
                    while (end4) {
                        int selectSem2 = sc.nextInt();
                        switch (selectSem2) {
                            case 1:
                                for (int i = 0; i < 5; i++) {
                                    semester[i] = new Semester(i + 1, matchSemesterAndDepartment(departmentName,i));
                                }
                                end4=false;
                                break;
                            case 2:
                                for (int i = 0; i < 6; i++) {
                                    semester[i] = new Semester(i + 1, matchSemesterAndDepartment(departmentName,i));
                                }
                                end4=false;
                                break;
                            default:
                                System.out.println("*****INVALID SEMESTER*****");
                        }
                    }
                    end1=false;
                    break;
                case 4:
                    System.out.println("    Select Semester   ");
                    System.out.println("press 1 : 7rd semester");
                    System.out.println("press 2 : 8th semester");
                    boolean end5=true;
                    while(end5) {
                        int selectSem3 = sc.nextInt();
                        switch (selectSem3) {
                            case 1:
                                for (int i = 0; i < 7; i++) {
                                    semester[i] = new Semester(i + 1, matchSemesterAndDepartment(departmentName,i));
                                }
                                end5=false;
                                break;
                            case 2:
                                for (int i = 0; i < 8; i++) {
                                    semester[i] = new Semester(i + 1, matchSemesterAndDepartment(departmentName,i));
                                }
                                end5=false;
                                break;
                            default:
                                System.out.println("****INVALID SEMESTER****");
                        }
                    }
                    end1=false;
                    break;
                default:
                    System.out.println("*****Invalid semester*****");
            }
        }
        studentId += 1;
        Address add=new Address(doorNumber,streetName,cityName,stateName);
        return new Student(studentId, studentName, studentPhone, intStudentRoom, studentHostel,departmentName,add,semester);
    }
    public static Faculty facultyDetails() {
        Faculty f;
        System.out.println("Enter faculty id ");
        int facultyId = sc.nextInt();
        System.out.println("Enter Faculty name : ");
        sc.nextLine();
        String facultyName = sc.nextLine();
        ArrayList<Subject> handlingSubjects = new ArrayList<>();
        System.out.println("Enter department : ");
        String department = sc.next();
        for(int i=0;i<8;i++) {
            System.out.println("present!!! you are in"+(i+1)+" semester"+"\n"+"press 1: to enter into current semester....."+"\n"+"press 2: to next semester.....");
            int facultyOpinion = sc.nextInt();
            if(facultyOpinion==1) {
                for (Subject subject : SubjectDetails.subjectDetails) {
                    if (subject.department.equals(department) && subject.facultyId == -1 && subject.semester == i) {
                        System.out.println(subject.subjectName + " has vacancy");
                        System.out.println("press 1 : enroll...." + "\n" + "press 2 : select other");
                        int selection = sc.nextInt();
                        switch (selection) {
                            case 1:
                                subject.facultyId = facultyId;
                                handlingSubjects.add(new Subject(subject.subjectName, subject.department, i));
                                break;
                            case 2:
                                break;
                        }
                    }
                }
            }
        }
        f = new Faculty(facultyId,facultyName,handlingSubjects,department);
        return f;
    }
    public static void facultyProcess(){
       Faculty f2 = facultyDetails();
       FacultyDetails.facultyDetails.add(f2);
    }
    public static void process() {
        while (end) {
            System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
            System.out.println("type 1 : ADD STUDENT DETAILS: " +
                    "\ntype 2 : SEE STUDENT DETAILS: " +
                    "\ntype 3 : REMOVE STUDENT DETAILS: " +
                    "\ntype 4 : UPDATE DETAILS: " +
                    "\ntype 5 : ADD MARKS OF STUDNET: " +
                    "\ntype 6 : SEARCH RECORD: " +
                    "\ntype 7 : SHOW THE MARKS OF STUDENT: " +
                    "\ntype 8 : UPDATE SCORE: "+
                    "\ntype 9 : FIND STUDENT UNDER THE GUIDENCE OF FACULTY"+
                    "\ntype 10 : ALL SEMESTER TOTAL MARKS : "+
                    "\ntype 11 : UPDATE SEMESTER : "+
                    "\ntype 12 : ADD FACULTY :"+
                    "\ntype 13 : END : ");
            System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
            String user = sc.next().toLowerCase();
            if (!(user.matches("\\d+"))) {
                System.out.println("Input is invalid!please Try again");
            } else if (user.equals("1")) {
                Student s2;
                try {
                    s2 = getDetails();
                    int bount = 0;
                    if (count == 0)//for first record purpose only
                    {
                        StudentDetails.studentDetails.add(s2);
                        System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
                        System.out.println("Student id added Successfully");
                        System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
                        count++;
                    } else if (count >= 1) {
                        for (Student detail : StudentDetails.studentDetails) {
                            if (s2.phoneNo.equals(detail.phoneNo) ) {
                                bount++;
                                studentId -= 1;
                                System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
                                System.out.println("Student id already existed");
                                System.out.println("duplicant records not accepted");
                                System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
                                break;
                            }
                        }
                        if (bount == 0) {
                            StudentDetails.studentDetails.add(s2);
                            System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
                            System.out.println("Student id added Successfully");
                            System.out.println("Use the below Services ");
                            System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
                        }
                    }
                } catch (StudentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (user.equals("2")) {
                if (StudentDetails.studentDetails.isEmpty()) {
                    System.out.println("NO RECORDS FOUND");
                } else {
                    System.out.println("__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
                    System.out.println("press 1:for particular student record");
                    System.out.println("press 2:for all student details");
                    System.out.println("press 3:for departmentwise students");
                    String selection = sc.next();
                    while (!(selection.matches("[1-2]*"))) {
                        System.out.println("OPTION IS INVALID!!!!!type correctly");
                        selection = sc.next();
                    }
                    int select = Integer.parseInt(selection);
                    System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
                    switch (select) {
                        case 1:
                            System.out.print("***Enter Student Id : ");
                            String studId = checkStudentId(sc.next());
                            int studentId = Integer.parseInt(studId);
                            Student student = checkStudent(studentId);
                            if(student!=null) {
                                System.out.println("press 1 : for academic details");
                                System.out.println("press 2 : for student personal details");
                                String selector = checkStudentId(sc.next());
                                int selectOption = Integer.parseInt(selector);
                                switch (selectOption) {
                                    case 1:
                                        System.out.println(student);
                                        break;
                                    case 2:
                                        System.out.println(student.add);
                                        break;
                                    default:
                                        System.out.println("Invalid Input");
                                }
                            }else{
                                System.out.println("Student ID not found");
                            }
                            break;

                        case 2:
                            for (Student detail : StudentDetails.studentDetails) {
                                System.out.println(detail);
                                checking = false;
                            }
                            break;
                        case 3:
                            System.out.println("Departments : (cse/ece/mech/it)");
                            System.out.println("Enter the department: ");
                            String dept = sc.next().toLowerCase();
                            while (!(dept.equals("cse") || dept.equals("ece") || dept.equals("mech") || dept.equals("it"))) {
                                System.out.println("Enter Correctly!!!!");
                                dept = sc.next();
                            }
                            for (Student detail : StudentDetails.studentDetails) {
                                if (detail.department.equals(dept)) {
                                    System.out.println(detail);
                                    checking = false;
                                }
                            }
                            if (checking) {
                                System.out.println("******" + dept + " students are not found *******");
                            } else {
                                checking = true;
                            }
                            break;
                        default:
                            System.out.println("INVALID SELECTION");
                    }
                }
            } else if (user.equals("3")) {
                if (StudentDetails.studentDetails.isEmpty()) {
                    System.out.println("NO RECORDS FOUND");
                } else {
                    System.out.println("Enter student id for removal:");
                    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
                    String remover = checkStudentId(sc.next());
                    int remove = Integer.parseInt(remover);
                    Student student = checkStudent(remove);
                    if (student != null) {
                        StudentDetails.studentDetails.remove(student);
                        System.out.println(remove + " Id record removed succesfully");
                    } else {
                        System.out.println("Student not found!!!!!!");
                    }
                }
            } else if (user.equals("4")) {
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
                System.out.println("******PLEASE ENTER YOUR PIN*******");
                String pin = sc.next();
                while (!(pin.matches("[0-9]*"))) {
                    System.out.println("type!!!!numbers between 0-9");
                    pin = sc.next();
                }
                Validation v1=new Validation();
                if (v1.checkAuthorization(pin) == 1) {
                    if (StudentDetails.studentDetails.isEmpty()) {
                        System.out.println("NO RECORDS FOUND");
                    } else {
                        System.out.print("Enter StudentId:");
                        String id = checkStudentId(sc.next());
                        studentId=Integer.parseInt(id);
                        Student s= checkStudent(studentId);
                        if(s!=null) {
                                System.out.print("Do you like to change Name:(Y/N)");
                                String wantChangeName = sc.next().toLowerCase();
                                if (wantChangeName.equals("y") || wantChangeName.equals("yes")) {
                                    System.out.print("Enter new Name:");
                                    String newName=sc.nextLine();
                                    while(!newName.matches("[A-Za-z.\\s]*")){System.out.println("INVALID NAME,REENTER THE NAME");
                                    newName= sc.nextLine();}
                                    s.studentName = newName;
                                }
                                System.out.print("Do you like to change Phone Number:(Y/N)");
                                String wantChangePhone = sc.next().toLowerCase();
                                if (wantChangePhone.equals("y") || wantChangePhone.equals("yes")) {
                                    System.out.print("Enter new Phone Number:");
                                    String newPhoneNumber=sc.next();
                                    while(!newPhoneNumber.matches("[0-9]{10}")){System.out.println("INVALID PHONE NUMBER,REENTER NEW PHONE NUMBER");
                                        newPhoneNumber= sc.next();}
                                    s.phoneNo = newPhoneNumber;
                                }
                                System.out.print("Do you like to change roomNo:(Y/N)");
                                String wantChangeRoomNo = sc.next();
                                if (wantChangeRoomNo.equals("y") || wantChangeRoomNo.equals("yes")) {
                                    System.out.print("Enter new roomNumber:");
                                    String newRoomNo=sc.next();
                                    while(!newRoomNo.matches("[0-9]{3,9}")){System.out.println("INVALID ROOMNUMBER,REENTER NEW ROOMNUMBER");
                                        newRoomNo= sc.next();}
                                    s.roomNo = Integer.parseInt(newRoomNo);
                                }
                            System.out.println("*******SUCESSFULLY UPDATED********");

                        }else{System.out.println("STUDENT ID NOT FOUND");}
                    }
                } else {
                    System.out.println("INCORRECT PIN");
                }
            } else if (user.equals("5")) {

                if (StudentDetails.studentDetails.isEmpty()) {
                    System.out.println("Sorry!!!!! Students are not present");
                } else {
                    System.out.println("Enter StudentId :");
                    int studentId = sc.nextInt();
                    Student s2 = checkStudent(studentId);
                    if (s2 != null) {
                        int semNumber = findSemesterNumber(s2);
                            for (int i = 0; i < semNumber; i++) {
                                System.out.println("PLEASE ENTER SEMESTER " + (i + 1) + " MARKS");
                                System.out.println("********************************************");
                                if(wantAddMarksOrNot()) {
                                    for (int j = 0; j < s2.semester[i].subject.length; j++) {
                                        System.out.println("If you want to add " + s2.semester[i].subject[j].subjectName + " marks: type( 1 for yes / 2 for no)");
                                        String askMarks = sc.next();
                                        while (!(askMarks.matches("[1-2]"))) {
                                            System.out.println("WRONG INPUT");
                                            askMarks = sc.next();
                                        }
                                        if (askMarks.equals("1") && s2.semester[i].subject[j].subjectMarks== -1) {
                                            s2.semester[i].subject[j].subjectMarks = checkMarks();
                                        } else if (askMarks.equals("1") && !(s2.semester[i].subject[j].subjectMarks == -1 && s2.semester[i].subject[j].subjectMarks == -2)) {
                                            System.out.println("marks of " + s2.semester[i].subject[j].subjectName + " is already added");
                                        }
                                    }
                                }
                            }
                    } else {
                        System.out.println("Student Id is not present");
                    }
                }
            } else if (user.equals("6")) {
                System.out.println("Please enter student Id:");
                int search = sc.nextInt();
                if (checkStudent(search) != null) {
                    System.out.println(checkStudent(search));
                } else {
                    System.out.println("ID NOT FOUND");
                }
            } else if (user.equals("7")) {
                System.out.println("Enter the studentId: ");
                String academics1 = checkStudentId(sc.next());
                int academics=Integer.parseInt(academics1);
                Student s;
                s = checkStudent(academics);
                if (s != null) {
                    int semNumber = findSemesterNumber(s);
                    System.out.println("type 1 : all subjects score");
                    System.out.println("type 2 : particular subject score");
                    int switch1 = sc.nextInt();
                    switch (switch1) {
                        case 1:
                            s.scoreCard(semNumber);
                            break;
                        case 2:
                            System.out.println("You are in "+(semNumber) +" semester");
                            System.out.println("   Enter the Semester number ( dont enter  your next semester)  ");
                            int semNumber1 = sc.nextInt()-1;
                            if(semNumber1<semNumber){
                                for(int i=0;i<s.semester[semNumber1].subject.length;i++){
                                    System.out.println("PRESS "+i+" for "+s.semester[semNumber1].subject[i].subjectName+" marks");
                                }
                            System.out.println("TYPE SUBJECT NUMBER:");
                            String subjectNum = sc.next();
                            while(!(subjectNum.matches("[0-4]")))
                            {
                                System.out.println("Enter Correct number");
                                subjectNum= sc.next();
                            }
                            int subjectNumber=Integer.parseInt(subjectNum);
                            if(s.semester[semNumber1].subject[subjectNumber].subjectMarks!=-1 && s.semester[semNumber1].subject[subjectNumber].subjectMarks>=50){
                                System.out.println("the " + s.semester[semNumber1].subject[subjectNumber].subjectName + " marks are :" + s.semester[semNumber1].subject[subjectNumber].subjectMarks);
                            }
                            else if(s.semester[semNumber1].subject[subjectNumber].subjectMarks!=-1 && s.semester[semNumber1].subject[subjectNumber].subjectMarks<50){
                                System.out.println("the " + s.semester[semNumber1].subject[subjectNumber].subjectName + " has arrear , marks are :" + s.semester[semNumber1].subject[subjectNumber].subjectMarks);
                            }
                            else{
                                System.out.println("***********MARKS ARE NOT ADDED*************");
                            }
                            }else{System.out.println("*************Invalid semester number***********");}
                            break;
                            default:
                            System.out.println("Enter subject code!!!!!correctly");
                    }
                }else{
                    System.out.println("STUDENT ID NOT FOUND");
                }
            }
            else if(user.equals("8")) {
                System.out.println("******UPDATE MARKS*********");
                System.out.println("Enter student id : ");
                String studId = checkStudentId(sc.next());
                int studentId = Integer.parseInt(studId);
                Student s = checkStudent(studentId);
                if (s != null) {
                    int semNumber = findSemesterNumber(s);
                        for (int i = 0; i < semNumber; i++) {
                            for (int j = 0; j < s.semester[i].subject.length; j++) {
                                if (s.semester[i].subject[j].subjectMarks != -1 && s.semester[i].subject[j].subjectMarks >=50){
                                System.out.println("Type.... " + j + " for update " + s.semester[i].subject[j].subjectName + " subject {******marks  added and you are passed*****}");}
                                else if (s.semester[i].subject[j].subjectMarks != -1 && s.semester[i].subject[j].subjectMarks <50){
                                    System.out.println("Type.... " + j + " for update " + s.semester[i].subject[j].subjectName + " subject {******marks  added and you are failed*****}");}
                                else if(s.semester[i].subject[j].subjectMarks == -1){
                                    System.out.println("Type.... " + j + " for update " + s.semester[i].subject[j].subjectName + " subject {******marks not added*****}");
                                }
                            }
                            System.out.println("press 1 : Subject Selection "+"\n"+"press 2 : next semester (it exits when you reach your semester)");
                            String option = sc.next();
                            while (!option.matches("[1-3]")) {
                                System.out.println("Enter correct option");
                                option = sc.next();
                            }
                            switch (option) {
                                case "1":
                                    boolean end=true;
                                    while(end) {
                                        System.out.println("Choose any Subject");
                                        int choice = sc.nextInt();
                                        if (choice < s.semester[i].subject.length) {
                                            if (s.semester[i].subject[choice].subjectMarks == -1) {
                                                System.out.println("Subject marks are not added");
                                            } else if(s.semester[i].subject[choice].subjectMarks != -1 && s.semester[i].subject[choice].subjectMarks != -2){
                                                System.out.println("****Your old " + s.semester[i].subject[choice].subjectName + " marks are" + s.semester[i].subject[choice].subjectMarks);
                                                System.out.println("Enter new marks of " + s.semester[i].subject[choice].subjectName);
                                                s.semester[i].subject[choice].subjectMarks=checkMarks();
                                            }
                                            else if(s.semester[i].subject[choice].subjectMarks == -2){
                                                System.out.println("Enter new marks of " + s.semester[i].subject[choice].subjectName);
                                                s.semester[i].subject[choice].subjectMarks=checkMarks();
                                            }
                                        } else {
                                            System.out.println("Subject code not found!!!!!!!!!!!");
                                        }
                                        System.out.println("press 1 : you want to continue update on present semester :");
                                        System.out.println("press 2 : you dont want to continue update on present semester :");
                                        int opt = sc.nextInt();
                                        if(opt==2){
                                            end=false;
                                        }
                                    }
                                    break;
                                case "2":
                                    break;
                                }
                            }
                }else{
                    System.out.println("Student Id not Found");
                }
            }
            else if(user.equals("9")){
                System.out.println("Enter Faculty Id : ");
                int facultyId = sc.nextInt();
                findStudentUnderFaculty(facultyId);
            }
            else if(user.equals("10")){
                System.out.println("Enter student Id");
                String studentId=checkStudentId(sc.next());
                int studId=Integer.parseInt(studentId);
                Student student=checkStudent(studId);
                if(student!=null){
                    int sum=0;
                     int semNumber = findSemesterNumber(student);
                     for(int i=0;i<semNumber;i++){
                         for(int j=0;j<student.semester[i].subject.length;j++){
                             if(student.semester[i].subject[j].subjectMarks!=-1){
                                 sum=sum+student.semester[i].subject[j].subjectMarks;
                             }
                         }
                         student.semester[i].setSemesterTotalMarks(sum);
                         sum=0;
                     }
                     semesterTotalMarks(student,semNumber);
                }
                else{System.out.println("Student Id not Found");}
            }
            else if(user.equals("11")){
                System.out.println("enter student Id : ");
                String studentId=checkStudentId(sc.next());
                int studId=Integer.parseInt(studentId);
                Student student=checkStudent(studId);
                if(student!=null) {
                    updateSemester(student);
                }else{
                    System.out.println("***STUDENT ID NOT FOUND***");
                }
            }
            else if(user.equals("12")){
                facultyProcess();
            }
            else if(user.equals("13"))
            {
                end=false;
                System.out.println("*****************************");
                System.out.println("successfully end the process");
                System.out.println("******************************");

            }
        }
    }
    public static int check()
    {
        sc=new Scanner(System.in);
        System.out.println("Welcome!!!!.....Administrator.....");
        System.out.print("Enter email id : ");
        String adminEmail=sc.next();
        System.out.print("Enter Password : ");
        String adminPassword =sc.next();
        Validation v1=new Validation();
        if(v1.checkCredentials(adminEmail,adminPassword)==1){
            return 1;
        }
        else{return 0;}
    }
    public static void main(String[] args)
    {
        if(check()==1)
        {
            while(end)
            {
                process();
            }
        }else{
            System.out.println("***********Invalid Details*********");
        }
    }
}


