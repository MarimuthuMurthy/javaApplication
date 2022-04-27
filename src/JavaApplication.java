
import java.util.*;
class StudentException extends RuntimeException{
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
    public static Student s1;
    public static Student s2;
    public static Validation v1;
    public static Scanner sc;
    public static int studentId=0;
    static int count=0;
    static boolean checking=true;
    static boolean end=true;

    static List<Student> studentDetails=new ArrayList<>();

    public static boolean checkName(String name){
        return name.matches("[A-Za-z.\\s]*");
    }
    public static boolean checkPhoneNumber(String phoneNo){
        return phoneNo.matches("\\d{10}");
    }
   public static boolean checkRoomNo(String roomNo){
        return roomNo.matches("\\d{1,9}");}
    public static int checkArrear(){
        System.out.println("press 1 : I have arrears ");
        System.out.println("press 2 : I dont have arrears ");
        String select = sc.next();
        while(!(select.matches("[1-2]"))){
            System.out.println("Invalid selection, select the options");
            select=sc.next();
        }
        if(select.equals("1")){return -2;}
        else{
            System.out.println("Enter the marks");
            return sc.nextInt();
        }
    }
    public static  String checkStudentId(String studentId){
        while(!(studentId.matches("\\d+"))){
            System.out.print("StudentId is Invalid , Re enter studentId : ");
            studentId=sc.next();
        }return studentId;
    }
    public static Student checkStudent(int id){
        for(Student student:studentDetails){
            if(student.studentId==id){
                return student;
            }
        }return null;
    }
//    public static void findStudentUnderFaculty(String Faculty){
//        if(studentDetails.isEmpty()){
//            System.out.println("**STUDENTS RECORDS NOT FOUND**");
//        }else {
//            int countStudents=0;
//            for (Student student : studentDetails) {
//                for (int i = 0; i < student.subjectDetails.length; i++) {
//                    if (student.subjectDetails[i].subjectFaculty.equals(Faculty)) {
//                        System.out.println(student);
//                        countStudents++;
//                    }
//                }
//            }if(countStudents==0){
//                System.out.println("***FACULTY DOESNT ALLOCATE STUDENTS***");
//            }
//        }
//    }
    public static SubjectDetails[] matchSemesterAndDepartment(String departmentName,int semester){
        SubjectDetails[] subjectDetails=new SubjectDetails[5];
        if(departmentName.equals("cse")){
            String[] subject=CseDepartment.cseSubjects[semester];
            String[] faculty=CseDepartment.cseFaculties[semester];
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
            return subjectDetails;
        }
        else if(departmentName.equals("ece")){
            String[] subject=EceDepartment.eceSubjects[semester];
            String[] faculty=EceDepartment.eceFaculties[semester];
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
            return subjectDetails;
        }
        if(departmentName.equals("mech")){
            String[] subject=MechanicalDepartment.mechSubjects[semester];
            String[] faculty=MechanicalDepartment.mechFaculties[semester];
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
            return subjectDetails;
        }
        else{
            String[] subject=ItDepartment.itTotalSubjects[semester];
            String[] faculty=ItDepartment.itTotalFaculty[semester];
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
            return subjectDetails;
        }
    }
    public static Student getDetails()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter student name:");
        String studentName = sc.nextLine();

        while (!checkName(studentName)) {
            System.out.println("Invalid name! please enter again");
            studentName = sc.nextLine();
        }
        System.out.print("Enter student phone number: +91");
        String studentPhone = sc.next();
        while (!checkPhoneNumber(studentPhone)) {
            System.out.println("Invalid Phone Number! please enter again");
            studentPhone = sc.next();
        }
        System.out.println("***********ADDRESS DETAILS**************");
        System.out.print("Enter DoorNumber : ");
        sc.nextLine();
        String doorNumber = sc.nextLine();
        System.out.print("Enter StreetName : ");
        String streetName = sc.nextLine();
        System.out.print("Enter city Name : ");
        String cityName = sc.nextLine();
        System.out.print("Enter State Name : ");
        String stateName = sc.nextLine();
        System.out.print("*********Select HostelName:*********");
        System.out.print("\n"+"press 1:Prince..........."+
                           "\n"+"press 2:Leaders.........."+"\n");
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
                throw new StudentException("Sorry! you are not allowed in this institute");
        }
        System.out.print("Enter student room no:");
        String studentRoom = sc.next();
        while (!checkRoomNo(studentRoom)) {
            System.out.print("Invalid Room Number! please enter again");
            studentRoom = sc.next();
        }
        int intStudentRoom=Integer.parseInt(studentRoom);
        String[] subject=null;
        String[] faculty=null;
        Semester[] semester=new Semester[8] ;
        int academicFee=0;
        System.out.println("select current study year");
        System.out.println("press 1 : 1st year"+"\n"+"press 2 : 2nd year"+"\n"+"press 3 : 3rd year"+"\n"+"press 4 : 4th year"+"\n"+"press 5 : passed out");
        int select = sc.nextInt();
        System.out.println("*********select department*********** "+
                "\n"+"press 1:CSE.........."+
                "\n"+"press 2:ECE.........."+
                "\n"+"press 3:MECH........."+
                "\n"+"press 4:IT...........");
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
                    System.out.println("press 1: 1st semester");
                    System.out.println("press 2: 2nd semester");
                    System.out.println("select current semester");
                    int selectSem = sc.nextInt();
                    boolean end2= true;
                    while(end2) {
                        switch (selectSem) {
                            case 1:
                                System.out.println("******Enjoy your Engineering life*****");
                                end2=false;
                                break;
                            case 2:
                                for (int i = 0; i < 1; i++) {
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
                    System.out.println("press 1 : 3rd semester");
                    System.out.println("press 2 : 4th semester");
                    System.out.println("select current semester");
                    boolean end3=true;
                    while(end3) {
                        int selectSem1 = sc.nextInt();
                        switch (selectSem1) {
                            case 1:
                                for (int i = 0; i < 2; i++) {
                                    semester[i] = new Semester(i + 1, matchSemesterAndDepartment(departmentName,i));
                                }
                                end3=false;
                                break;
                            case 2:
                                for (int i = 0; i < 3; i++) {
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
                    System.out.println("press 1 : 5rd semester");
                    System.out.println("press 2 : 6th semester");
                    System.out.println("select current semester");
                    boolean end4=true;
                    while (end4) {
                        int selectSem2 = sc.nextInt();
                        switch (selectSem2) {
                            case 1:
                                for (int i = 0; i < 4; i++) {
                                    semester[i] = new Semester(i + 1, matchSemesterAndDepartment(departmentName,i));
                                }
                                end4=false;
                                break;
                            case 2:
                                for (int i = 0; i < 5; i++) {
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
                    System.out.println("press 1 : 7rd semester");
                    System.out.println("press 2 : 8th semester");
                    System.out.println("select current semester");
                    boolean end5=true;
                    while(end5) {
                        int selectSem3 = sc.nextInt();
                        switch (selectSem3) {
                            case 1:
                                for (int i = 0; i < 6; i++) {
                                    semester[i] = new Semester(i + 1, matchSemesterAndDepartment(departmentName,i));
                                }
                                end5=false;
                                break;
                            case 2:
                                for (int i = 0; i < 7; i++) {
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
                case 5:
                    for(int i=0;i<8;i++){
                        semester[i] = new Semester(i + 1, matchSemesterAndDepartment(departmentName,i));
                    }
                    end1=false;
                    break;
                default:
                    System.out.println("*****Invalid semester*****");
            }
        }
        studentId += 1;
        Address add=new Address(doorNumber,streetName,cityName,stateName);
        s1 = new Student(studentId, studentName, studentPhone, intStudentRoom, studentHostel,departmentName,add,semester);
        return s1;
    }
    public static void process() {
        Scanner sc = new Scanner(System.in);
        while (end) {
            System.out.println("type 1 )-> ADD STUDENT DETAILS: " +
                    "\ntype 2 )-> SEE STUDENT DETAILS: " +
                    "\ntype 3 )-> REMOVE STUDENT DETAILS: " +
                    "\ntype 4 )-> UPDATE DETAILS: " +
                    "\ntype 5 )-> ADD MARKS OF STUDNET: " +
                    "\ntype 6 )-> SEARCH RECORD: " +
                    "\ntype 7 )-> SHOW THE MARKS OF STUDENT: " +
                    "\ntype 8 )-> SHOW THE STUDENT SUBJECT AND FACULTY: " +
                    "\ntype 9 )-> UPDATE SCORE: "+
                    "\ntype 10 )-> FIND STUDENT UNDER THE GUIDENCE OF FACULTY"+
                    "\ntype 11 )-> SHOW SEMESTER MARKS : "+
                    "\ntype 12 )-> UPDATE SEMESTER MARKS : "+
                    "\ntype 13 )-> END : ");
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
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
                        studentDetails.add(s2);
                        System.out.println("_ _ _ _ _ __ _ _ _ _ __ _ _ _ _ __");
                        System.out.println("**** Student id added Successfully ******");
                        System.out.println("**** Use the below Services ****");
                        System.out.println("_ _ _ _ _ __ _ _ _ _ __ _ _ _ _ __");
                        count++;
                    } else if (count >= 1) {
                        for (Student detail : studentDetails) {
                            if (s2.phoneNo.equals(detail.phoneNo) ) {
                                bount++;
                                studentId -= 1;
                                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                                System.out.println("Student id already existed");
                                System.out.println("**** duplicant records not accepted ****");
                                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                                break;
                            }
                        }
                        if (bount == 0) {
                            studentDetails.add(s2);
                            System.out.println("_ _ _ _ _ __ _ _ _ _ __ _ _ _ _ __");
                            System.out.println("****Student id added Successfully****");
                            System.out.println("**** Use the below Services ****");
                            System.out.println("_ _ _ _ _ __ _ _ _ _ __ _ _ _ _ __");
                        }
                    }
                } catch (StudentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (user.equals("2")) {
                if (studentDetails.isEmpty()) {
                    System.out.println("NO RECORDS FOUND");
                } else {
                    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                    System.out.println("press 1:for particular student record");
                    System.out.println("press 2:for all student details");
                    System.out.println("press 3:for departmentwise students");
                    String selection = sc.next();
                    while (!(selection.matches("[1-2]*"))) {
                        System.out.println("OPTION IS INVALID!!!!!type correctly");
                        selection = sc.next();
                    }
                    int select = Integer.parseInt(selection);
                    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
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
                            for (Student detail : studentDetails) {
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
                            for (Student detail : studentDetails) {
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
                if (studentDetails.isEmpty()) {
                    System.out.println("NO RECORDS FOUND");
                } else {
                    System.out.println("Enter student id for removal:");
                    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
                    String remover = checkStudentId(sc.next());
                    int remove = Integer.parseInt(remover);
                    Student student = checkStudent(remove);
                    if (student != null) {
                        studentDetails.remove(student);
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
                if (v1.checkAuthorization(pin) == 1) {
                    if (studentDetails.isEmpty()) {
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
                                    while(!checkName(newName)){System.out.println("INVALID NAME,REENTER THE NAME");
                                    newName= sc.nextLine();}
                                    s.studentName = newName;
                                }
                                System.out.print("Do you like to change Phone Number:(Y/N)");
                                String wantChangePhone = sc.next().toLowerCase();
                                if (wantChangePhone.equals("y") || wantChangePhone.equals("yes")) {
                                    System.out.print("Enter new Phone Number:");
                                    String newPhoneNumber=sc.next();
                                    while(!checkPhoneNumber(newPhoneNumber)){System.out.println("INVALID PHONE NUMBER,REENTER NEW PHONE NUMBER");
                                        newPhoneNumber= sc.next();}
                                    s.phoneNo = newPhoneNumber;
                                }
                                System.out.print("Do you like to change roomNo:(Y/N)");
                                String wantChangeRoomNo = sc.next();
                                if (wantChangeRoomNo.equals("y") || wantChangeRoomNo.equals("yes")) {
                                    System.out.print("Enter new roomNumber:");
                                    String newRoomNo=sc.next();
                                    while(!checkRoomNo(newRoomNo)){System.out.println("INVALID ROOMNUMBER,REENTER NEW ROOMNUMBER");
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
                if (studentDetails.isEmpty()) {
                    System.out.println("Sorry!!!!! Students are not present");
                } else {
                    System.out.println("Enter StudentId :");
                    int studentId = sc.nextInt();
                    s2 = checkStudent(studentId);
                    if (s2 != null) {
                        if(s2.semester.length>1) {
                            for (int i = 0; i < s2.semester.length - 1 && s2.semester[i]!=null; i++) {
                                System.out.println("PLEASE ENTER SEMESTER " + (i + 1) + " MARKS");
                                System.out.println("********************************************");
                                for (int j = 0; j < s2.semester[i].subjectDetails.length ; j++) {
                                    System.out.println("If you want to add " + s2.semester[i].subjectDetails[j].subjectName + " marks: type( 1 for yes / 2 for no)");
                                    String askMarks = sc.next();
                                    while (!(askMarks.matches("[1-2]"))) {
                                        System.out.println("WRONG INPUT");
                                        askMarks = sc.next();
                                    }
                                    if (askMarks.equals("1") && s2.semester[i].subjectDetails[j].subjectMark == -1) {
                                        System.out.println("enter marks: ");
                                        s2.semester[i].subjectDetails[j].setSubjectMark(sc.nextInt());
                                    } else if (askMarks.equals("1") && !(s2.semester[i].subjectDetails[j].subjectMark == -1 && s2.semester[i].subjectDetails[j].subjectMark == -2)) {
                                        System.out.println("marks of " + s2.semester[i].subjectDetails[j].subjectName + " is already added");
                                    }
                                }
                            }
                        }else{
                            System.out.println("sorry!!!! you are studying first semester only, we cant update marks....");
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
                    System.out.println("type 1 : all subjects score");
                    System.out.println("type 2 : particular subject score");
                    int switch1 = sc.nextInt();
                    switch (switch1) {
                        case 1:
                            s.scoreCard();
                            break;
                        case 2:


                        default:
                            System.out.println("Enter subject code!!!!!correctly");
                    }
                }else{
                    System.out.println("STUDENT ID NOT FOUND");
                }
            }
            else if(user.equals("8"))
            {

            }
            else if(user.equals("9")) {
//                System.out.println("******UPDATE MARKS*********");
//                System.out.println("Enter student id : ");
//                String studId = checkStudentId(sc.next());
//                int studentId = Integer.parseInt(studId);
//                Student s = checkStudent(studentId);
//                if (s != null) {
//                    for (int i = 0; i < s.subjectDetails.length; i++) {
//                        System.out.println("Type.... " + i + " for update " + s.subjectDetails[i].subjectName + " subject");
//                    }
//                    System.out.println("Choose any Subject");
//                    int choice = sc.nextInt();
//                    if (choice < s.subjectDetails.length) {
//                        if (s.subjectDetails[choice].subjectMark==-1) {
//                            System.out.println("Subject marks are not added");
//                        } else {
//                            System.out.println("****Your old "+s.subjectDetails[choice].subjectName+" marks are"+s.subjectDetails[choice].subjectMark);
//                            System.out.println("Enter new marks of "+s.subjectDetails[choice].subjectName);
//                            s.subjectDetails[choice].setSubjectMark(sc.nextInt());
//                        }
//                    } else {
//                        System.out.println("Subject code not found!!!!!!!!!!!");
//                    }
//                }else{
//                    System.out.println("Student Id not Found");
//                }
            }
            else if(user.equals("10")){
//                System.out.println("Enter Faculty Name : ");
//                String faculty=sc.next();
//                findStudentUnderFaculty(faculty);
            }
            else if(user.equals("11")){
//                System.out.println("Enter student Id");
//                String studentId=checkStudentId(sc.next());
//                int studId=Integer.parseInt(studentId);
//                Student student=checkStudent(studId);
//                if(student!=null){
//                semesterMarksShown(student);
//                }
//                else{System.out.println("Student Id not Found");}
            }
            else if(user.equals("12")){
//                System.out.println("enter student Id : ");
//                String studentId=checkStudentId(sc.next());
//                int studId=Integer.parseInt(studentId);
//                Student student=checkStudent(studId);
//                if(student!=null) {
//                    updateSemesterMarks(student);
//                }else{
//                    System.out.println("***STUDENT ID NOT FOUND***");
//                }
            }
            else if(user.equals("13"))
            {
                end=false;
                System.out.println("*****************************");
                System.out.println("successfully end the process");
                System.out.println("******************************");

            }
            else{
                System.out.println("Invalid input");
            }
        }
    }
    public static int check()
    {
        sc=new Scanner(System.in);
        System.out.println("Hello! Admin please Enter your Email:");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ __ _ ");
        String adminEmail=sc.next();
        System.out.println("Enter your password:");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ __ _ ");
        String adminPassword =sc.next();
        v1=new Validation();
        if(v1.checkCredentials(adminEmail,adminPassword)==1){
            return 1;
        }
        else{return 0;}
    }
    public static void main(String[] args)
    {
        System.out.println("******Admin Access******");
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


