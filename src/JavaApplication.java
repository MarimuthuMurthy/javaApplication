
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
    final private LinkedHashMap<String ,String> lhs=new LinkedHashMap<>();
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
    public static Validation v1;
    public static Scanner sc;
    public static int studentId=0;
    static int count=0;
    static boolean checking=true;
    static boolean end=true;
    static List<Student> studentDetails=new ArrayList<>();
    public static int[] getMarks(Student s){
        if(s.marksAddorNot) {
            for (int i = 0; i < s.subject.length; i++) {
                System.out.print("Enter " + s.subject[i] + " marks:");
                s.marks[i] = sc.nextInt();
            }
            s.marksAddorNot=false;
        }
        return s.marks;
    }

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
        while (!(studentRoom.matches("[0-9]+"))) {
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
        if(departmentName.equals("cse")){
            subject=CseDepartment.cseSubjects;
            faculty=CseDepartment.cseFaculty;
        }
        if(departmentName.equals("ece")){
            subject=EceDepartment.cseSubjects;
            faculty=EceDepartment.ecefaculty;
        }
        if(departmentName.equals("mech")){
            subject=MechanicalDepartment.mechanicalSubjects;
            faculty=MechanicalDepartment.mechfaculty;
        }
        if(departmentName.equals("it")){
            subject=ItDepartment.itSubjects;
            faculty=ItDepartment.itfaculty;
        }
        studentId += 1;
        s1 = new Student(studentId, studentName, studentPhone, intStudentRoom, studentHostel,departmentName,subject,faculty );
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
    public static void process() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n ***** ADD STUDENT DETAILS: *****" +
                "\n ***** SEE STUDENT DETAILS: *****" +
                "\n ***** REMOVE STUDENT DETAILS: *****" +
                "\n ***** SEARCH RECORD: *****" +
                "\n ***** UPDATE DETAILS: *****" +
                "\n ***** ADD MARKS OF STUDNET: *****" +
                "\n ***** SHOW THE MARKS OF STUDENT: *****" +
                "\n ***** END THE PROCESS: ***** ");
        while (end) {
            System.out.println("<<<<<type>>>>");
            System.out.println(" add want remove search update score addmarks end:");
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            String user = sc.next().toLowerCase();
            if (!(user.equals("add") || user.equals("want") || user.equals("end") || user.equals("remove") || user.equals("search") || user.equals("update") || user.equals("marks") || user.equals("show") || user.equals("addmarks") || user.equals("score")||user.equals("subjectandfaculty"))) {
                System.out.println("Input is invalid!please Try again");
            } else if (user.equals("add")) {
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

            } else if (user.equals("want")) {
                if (studentDetails.isEmpty()) {
                    System.out.println("NO RECORDS FOUND");
                } else {
                    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                    System.out.println("press 1:for all student details");
                    System.out.println("press 2:for departmentwise students");
                    String selection=sc.next();
                    while(!(selection.matches("[1-2]*"))){
                        System.out.println("OPTION IS INVALID!!!!!type correctly");
                        selection= sc.next();
                    }
                    int select=Integer.parseInt(selection);
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
                                    break;
                                }
                            }
                            if (checking) {
                                System.out.println("******" + dept + " students are not found *******");
                            }else{checking=true;}
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
            } else if (user.equals("remove")) {
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
                    for (Student detail : studentDetails) {
                        if (detail.studentId == remove) {
                            studentDetails.remove(detail);
                            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                            System.out.println(remove + " Id record removed succesfully");
                            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                            checking = false;
                            break;
                        }
                    }
                    if (checking) {
                        System.out.println("Student is not present!!!!!!");
                    } else {
                        checking = true;
                    }
                    for (Student detail : studentDetails) {
                        if (detail.studentId > remove) {
                            detail.studentId = detail.studentId - 1;
                        }
                    }
                    studentId -= 1;
                }
            } else if (user.equals("update")) {
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
            } else if (user.equals("addmarks")) {
                if (studentDetails.isEmpty()) {
                    System.out.println("Sorry!!!!! Students are not present");
                } else {
                    System.out.println("Enter StudentId :");
                    int studentId = sc.nextInt();
                    if (studentIdCheck(studentId) == 1) {
                        for (Student student : studentDetails) {
                            if (student.studentId == studentId && student.marksAddorNot) {
                                student.marks = getMarks(student);
                                System.out.println("Marks successfully added");
                                checking = false;
                                break;
                            }
                        }
                        if (checking) {
                            System.out.println("Marks are already Added");
                        } else {
                            checking = true;
                        }
                    } else {
                        System.out.println("Student Id is not present");
                    }
                }
            } else if (user.equals("search")) {
                System.out.println("Please enter student Id:");
                int search = sc.nextInt();
                for (Student detail : studentDetails) {
                    if (search == detail.studentId) {
                        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                        System.out.println("Record Found");
                        System.out.println(detail);
                        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                    }
                }
            }
            else if(user.equals("score")) {
                System.out.println("Enter the studentId: ");
                int academics = sc.nextInt();
                if(studentIdCheck(academics)==1) {
                    System.out.println("type 1 : all subjects score");
                    System.out.println("type 2 : particular subject score");
                    int switch1 = sc.nextInt();
                    switch (switch1) {
                        case 1:
                            for (Student detail : studentDetails) {
                                if (detail.studentId == academics && !detail.marksAddorNot) {
                                    detail.ScoreCard();
                                    checking = false;
                                    break;
                                }
                            }
                            if (checking) {
                                System.out.println("Marks are not added");
                            } else {
                                checking = true;
                            }
                            break;
                        case 2:
                            ArrayList<String> checkSubjects = new ArrayList<>();
                            for (Student detail : studentDetails) {
                                if (detail.studentId == academics) {
                                    for (int i = 0; i < detail.subject.length; i++) {
                                        System.out.println("Subject  " + detail.subject[i]);
                                    }
                                    checkSubjects.addAll(Arrays.asList(detail.subject));
                                    break;
                                }
                            }
                            System.out.println("Enter subject name:");
                            String subject = sc.next().toUpperCase();
                            if (checkSubjects.contains(subject)) {
                                for (Student detail : studentDetails) {
                                    {
                                        if (detail.studentId == academics && !detail.marksAddorNot) {
                                            for (int i = 0; i < detail.subject.length; i++) {
                                                if (detail.subject[i].equals(subject)) {
                                                    checking = false;
                                                    System.out.println(detail.marks[i]);
                                                }
                                            }
                                        }
                                    }
                                    if (checking) {
                                        System.out.println("Marks are not added");
                                    } else {checking = true;}
                                    break;
                                }
                            } else {
                                System.out.println("Subject not Found!!! type correctly");
                            }
                    }
                }else{
                    System.out.println("*********Student is not present*****************");
                }
            }
            else if(user.equals("subjectandfaculty"))
            {
                System.out.println("Enter the student id :");
                int studId=sc.nextInt();
                if(studentIdCheck(studId)==1) {
                    for (Student student : studentDetails) {
                        for (int i = 0; i < student.subject.length; i++) {
                            System.out.println("subject " + student.subject[i] + "|**********| Faculty :" + student.faculty[i]);
                        }
                    }
                }else{
                    System.out.println("Student ID NOT FOUND");
                }
            }
            else if(user.equals("end"))
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


