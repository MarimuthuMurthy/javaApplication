
import javax.security.auth.Subject;
import java.util.*;
class HostelNameException extends RuntimeException{
    HostelNameException(String hostel){
        super(hostel);
    }
}
final class Validation{
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
    final private HashMap<String ,String> lhs=new LinkedHashMap<>();
    final private String authorization="5656";
    Validation(){
        lhs.put(email1,password1);
        lhs.put(email2,password2);
        lhs.put(email3,password3);
        lhs.put(email4,password4);
        lhs.put(email5,password5);
    }
    Set<String> keys=lhs.keySet();
    public int checkCredentials(String email,String password){
        for(String key:keys){
            if(key.equals(email) && lhs.get(key).equals(password)){
                return 1;
            }
        }
        return 0;
    }
    public int checkAuthorization(String updateAuthorization){
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
    public static Student getDetails()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter student name:");
        String studentName = sc.nextLine();

        while (!(studentName.matches("^[A-Za-z.\\s]*"))) {
            System.out.println("Invalid name! please enter again");
            studentName = sc.nextLine();
        }
        System.out.print("Enter student phone number:");
        String studentPhone = sc.next();
        while (!(studentPhone.matches("[0-9]{10}"))) {
            System.out.println("Invalid Phone Number! please enter again");
            studentPhone = sc.next();
        }
        System.out.print("Enter student room no:");
        String studentRoom = sc.next();
        while (!(studentRoom.matches("[0-9]{1,9}"))) {
            System.out.println("Invalid Room Number! please enter again");
            studentRoom = sc.next();
        }
         int intStudentRoom=Integer.parseInt(studentRoom);
        System.out.print("Enter student HostelName:");
        String studentHostel = sc.next();
        if(!(studentHostel.equalsIgnoreCase("prince")||studentHostel.equalsIgnoreCase("leaders"))){

            throw new HostelNameException("Sorry! you are not allowed in the hostel");
        }
        System.out.print("Enter Department Name: ");
        String departmentName=sc.next().toLowerCase();
        while(!(departmentName.equals("cse") || departmentName.equals("ece") || departmentName.equals("mech") || departmentName.equals("it"))){
            System.out.println("Invalid department");
            departmentName= sc.next();;
        }
        String[] subject=null;
        String[] faculty=null;
        SubjectDetails[] subjectDetails=new SubjectDetails[5];
        if(departmentName.equals("cse")){
            subject=CseDepartment.cseSubjects;
            faculty=CseDepartment.cseFaculty;
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
        }
        if(departmentName.equals("ece")){
            subject=EceDepartment.eceSubjects;
            faculty=EceDepartment.ecefaculty;
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
        }
        if(departmentName.equals("mech")){
            subject=MechanicalDepartment.mechanicalSubjects;
            faculty=MechanicalDepartment.mechfaculty;
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
        }
        if(departmentName.equals("it")){
            subject=ItDepartment.itSubjects;
            faculty=ItDepartment.itfaculty;
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
        }
        studentId += 1;
        s1 = new Student(studentId, studentName, studentPhone, intStudentRoom, studentHostel,departmentName,subject,faculty,subjectDetails);
        return s1;
    }
    public static int studentIdCheck(int x) {
        int present=0;
        for(Student detail:studentDetails) {
            if(detail.studentId==x) {
                present=1;
            }
        }return present;
    }
    public static Student checkStudent(int id){
        for(Student student:studentDetails){
            if(student.studentId==id){
                return student;
            }
        }return null;
    }
    public static void process() {
        Scanner sc = new Scanner(System.in);
        while (end) {
            System.out.println("\n 1. ADD STUDENT DETAILS: *****" +
                    "\n 2. SEE STUDENT DETAILS: *****" +
                    "\n 3. REMOVE STUDENT DETAILS: *****" +
                    "\n 4. UPDATE DETAILS: *****" +
                    "\n 5. ADD MARKS OF STUDNET: *****" +
                    "\n 6. SEARCH RECORD: *****" +
                    "\n 7. SHOW THE MARKS OF STUDENT: *****" +
                    "\n 8. END THE PROCESS: ***** ");
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            String user = sc.next().toLowerCase();
            if (!(user.matches("[0-8]"))) {
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
                        System.out.println("STUDENT RECORD ADDED SUCCESFULLY");
                        System.out.println("_ _ _ _ _ __ _ _ _ _ __ _ _ _ _ __");
                        count++;
                    } else if (count >= 1) {
                        for (Student detail : studentDetails) {
                            if (s2.phoneNo.equals(detail.phoneNo)) {
                                bount++;
                                studentId -= 1;
                                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                                System.out.println("Student id already existed");
                                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                                break;
                            }
                        }
                        if (bount == 0) {
                            studentDetails.add(s2);
                            System.out.println("_ _ _ _ _ __ _ _ _ _ __ _ _ _ _ __");
                            System.out.println("STUDENT RECORD ADDED SUCCESFULLY");
                            System.out.println("_ _ _ _ _ __ _ _ _ _ __ _ _ _ _ __");
                        }
                    }
                } catch (HostelNameException e) {
                    System.out.println(e.getMessage());
                }

            } else if (user.equals("2")) {
                if (studentDetails.isEmpty()) {
                    System.out.println("NO RECORDS FOUND");
                } else {
                    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                    System.out.println("press 1:for all student details");
                    System.out.println("press 2:for departmentwise students");
                    String selection = sc.next();
                    while (!(selection.matches("[1-2]*"))) {
                        System.out.println("OPTION IS INVALID!!!!!type correctly");
                        selection = sc.next();
                    }
                    int select = Integer.parseInt(selection);
                    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                    switch (select) {
                        case 2:
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
                        case 1:
                            for (Student detail : studentDetails) {
                                System.out.println(detail);
                                checking = false;
                            }
                            break;
                        default:
                            System.out.println("TYPE CORRECTLY");
                    }
                }
            } else if (user.equals("3")) {
                if (studentDetails.isEmpty()) {
                    System.out.println("NO RECORDS FOUND");
                } else {
                    System.out.println("Enter student id for removal:");
                    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
                    String remover = sc.next();
                    while (!(remover.matches("[0-9]*"))) {
                        System.out.println("Student Id!!!!!!only in number Format,TYPE!!!correctly");
                        remover = sc.next();
                    }
                    int remove = Integer.parseInt(remover);
                    Student student = checkStudent(remove);
                    if (student != null) {
                        studentDetails.remove(student);
                        System.out.println(remove + " Id record removed succesfully");
                    } else {
                        System.out.println("Student is not present!!!!!!");
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
                        int id = sc.nextInt();
                        for (Student detail : studentDetails) {
                            if (detail.studentId == id) {
                                System.out.print("Do you like to change Name:(Y/N)");
                                String wantChangeName = sc.next().toLowerCase();
                                if (wantChangeName.equals("y") || wantChangeName.equals("yes")) {
                                    System.out.print("Enter new Name:");
                                    detail.studentName = sc.next();
                                }
                                System.out.print("Do you like to change Phone Number:(Y/N)");
                                String wantChangePhone = sc.next().toLowerCase();
                                if (wantChangePhone.equals("y") || wantChangePhone.equals("yes")) {
                                    System.out.print("Enter new Phone Number:");
                                    detail.phoneNo = sc.next();
                                }
                                System.out.print("Do you like to change roomNo:(Y/N)");
                                String wantChangeRoomNo = sc.next();
                                if (wantChangeRoomNo.equals("y") || wantChangeRoomNo.equals("yes")) {
                                    System.out.print("Enter new roomNumber:");
                                    detail.roomNo = sc.nextInt();
                                }
                                System.out.print("Do you like to change Hostel:(Y/N)");
                                String wantChangeHostel = sc.next().toLowerCase();
                                if (wantChangeHostel.equals("y") || wantChangeHostel.equals("yes")) {
                                    detail.hostelName = sc.next();
                                }
                            }
                        }
                        System.out.println("*******SUCESSFULLY UPDATED********");
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
                        for (int i = 0; i < s2.subjectDetails.length; i++) {
                            System.out.println("If you want to add " + s2.subjectDetails[i].subjectName + " marks: type( 1 for yes / 2 for no)");
                            String askMarks = sc.next();
                            while (!(askMarks.matches("[1-2]"))) {
                                System.out.println("WRONG INPUT");
                                askMarks = sc.next();
                            }
                            if (askMarks.equals("1") && s2.subjectDetails[i].subjectMarkAddorNOt) {
                                System.out.println("enter marks: ");
                                s2.subjectDetails[i].setSubjectName(sc.nextInt());
                            }
                            else if(askMarks.equals("1") && !s2.subjectDetails[i].subjectMarkAddorNOt)
                            {
                                System.out.println("marks of "+ s2.subjectDetails[i].subjectName +" is already added");
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
                int academics = sc.nextInt();
                Student s;
                s = checkStudent(academics);
                if (s != null) {
                    System.out.println("type 1 : all subjects score");
                    System.out.println("type 2 : particular subject score");
                    int switch1 = sc.nextInt();
                    switch (switch1) {
                        case 1:
                            s.ScoreCard();
                            break;
                        case 2:
                            for (int i = 0; i < s.subjectDetails.length; i++) {
                                System.out.println(i + " " + s.subjectDetails[i].subjectName);
                            }
                            System.out.println("TYPE SUBJECT NUMBER:");
                            String subjectNum = sc.next();
                            while(!(subjectNum.matches("[0-4]")))
                            {
                                System.out.println("Enter Correct number");
                                subjectNum= sc.next();
                            }
                            int subjectNumber=Integer.parseInt(subjectNum);
                            if(!(s.subjectDetails[subjectNumber].subjectMarkAddorNOt)){
                            System.out.println("the " + s.subjectDetails[subjectNumber].subjectName + " marks are :" + s.subjectDetails[subjectNumber].subjectMark);
                            }
                            else{
                                System.out.println("***********MARKS ARE NOT ADDED*************");
                            }
                    }
                }else{
                    System.out.println("STUDENT ID NOT FOUND");
                }
            }
            else if(user.equals("subjectandfaculty"))
            {
                System.out.println("Enter the student id :");
                int studId=sc.nextInt();
                if(studentIdCheck(studId)==1) {
                    for (Student student : studentDetails) {
//                        for (int i = 0; i < student.subject.length; i++) {
//                            System.out.println("subject " + student.subject[i] + "|**********| Faculty :" + student.faculty[i]);
//                        }
                    }
                }else{
                    System.out.println("Student ID NOT FOUND");
                }
            }
            else if(user.equals("8"))
            {
                end=false;
                System.out.println("*****************************");
                System.out.println("successfully end the process");
                System.out.println("*****************************");

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
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("******Admin Access******");
        if(check()==1){
            while(end) {
                process();
            }
        }
    }
}


