
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
    final private int authorization=5656;
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
    public int checkAuthorization(int updateAuthorization){
        if(updateAuthorization==authorization){return 1;}else{return 0;}
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
        while (!(studentName.matches("^[A-Za-z'.'\\s]*"))) {
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
        int studentRoom = sc.nextInt();
        while (!(Integer.toString(studentRoom).matches("[0-9]+"))) {
            System.out.println("Invalid Room Number! please enter again");
            studentRoom = sc.nextInt();
        }
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
        studentId += 1;
        String[] subject=null;
        String[] faculty=null;
        if(departmentName.equals("cse")){
            subject=CseDepartment.cseSubjects;
            faculty=CseDepartment.faculty;
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
        s1 = new Student(studentId, studentName, studentPhone, studentRoom, studentHostel,departmentName,subject,faculty );
        return s1;
    }
    public static void process()
    {
        Scanner sc=new Scanner(System.in);
        List<Student> studentDetails=new ArrayList<>();

        System.out.println("\n 1.ADD STUDENT DETAILS: " +
                "\n 2.SEE STUDENT DETAILS: " +
                "\n 3.REMOVE STUDENT DETAILS: " +
                "\n 4.SEARCH RECORD: " +
                "\n 5.UPDATE DETAILS: " +
                "\n 6.ADD MARKS OF STUDNET: "+
                "\n 7.SHOW THE MARKS OF STUDENT"+
                "\n END THE PROCESS:");
        while(end)
        {
            System.out.println("<<<<<type>>>>");
            System.out.println(" add want remove search update score addmarks end:");
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            String user=sc.next().toLowerCase();
            if(!(user.equals("add") || user.equals("want")||user.equals("end")||user.equals("remove")||user.equals("search")||user.equals("update")||user.equals("marks")||user.equals("show")||user.equals("addmarks")||user.equals("score")))
            {
                System.out.println("Input is invalid!please Try again");
            }
            else if(user.equals("add"))
            {
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
                        for (Student detail:studentDetails) {
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
                }catch(HostelNameException e){
                    System.out.println(e.getMessage());
                }

            }
            else if(user.equals("want")) {
                if (studentDetails.isEmpty()) {
                    System.out.println("NO RECORDS FOUND");
                } else {
                    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                    System.out.println("press 1:for all student details");
                    System.out.println("press 2:for departmentwise students");
                    int selection = sc.nextInt();
                    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                    switch (selection) {
                        case 2:
                            System.out.println("Enter the department: ");
                            String dept = sc.next();
                            for (Student detail : studentDetails) {
                                if (detail.department.equals(dept)) {
                                    System.out.println(detail);
                                }
                            }
                            break;
                        case 1:
                            for (Student detail : studentDetails) {
                                System.out.println(detail);
                                checking=false;
                            }
                            break;
                        default:
                            System.out.println("TYPE CORRECTLY");
                    }
                }
            }
            else if(user.equals("remove")) {
                System.out.println("Enter student id for removal:");
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
                int remove = sc.nextInt();
                if (studentDetails.isEmpty()) {
                    System.out.println("NO RECORDS FOUND");
                } else {
                    for (Student detail : studentDetails) {
                        if (detail.studentId == remove) {
                            studentDetails.remove(detail);
                            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                            System.out.println(remove + " Id record removed succesfully");
                            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                            break;
                        }
                    }
                }
            }
            else if (user.equals("update")) {
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
                System.out.println("******PLEASE ENTER YOUR PIN*******");
                int pin=sc.nextInt();
                if(v1.checkAuthorization(pin)==1) {
                    if (studentDetails.isEmpty()) {
                        System.out.println("NO RECORDS FOUND");
                    } else {
                        System.out.print("Enter StudentId:");
                        int id = sc.nextInt();
                        for (Student detail:studentDetails) {
                            if (detail.studentId == id) {
                                System.out.print("Do you like to change Name:(Y/N)");
                                String wantChangeName = sc.next().toLowerCase();
                                if (wantChangeName.equals("y") || wantChangeName.equals("yes")) {
                                    System.out.print("Enter new Name:");
                                    detail.studentName=sc.next();
                                }
                                System.out.print("Do you like to change Phone Number:(Y/N)");
                                String wantChangePhone = sc.next().toLowerCase();
                                if (wantChangePhone.equals("y")||wantChangePhone.equals("yes")) {
                                    System.out.print("Enter new Phone Number:");
                                    detail.phoneNo=sc.next();
                                }
                                System.out.print("Do you like to change roomNo:(Y/N)");
                                String wantChangeRoomNo = sc.next();
                                if(wantChangeRoomNo.equals("y")||wantChangeRoomNo.equals("yes")) {
                                    System.out.print("Enter new roomNumber:");
                                    detail.roomNo=sc.nextInt();
                                }
                                System.out.print("Do you like to change Hostel:(Y/N)");
                                String wantChangeHostel = sc.next().toLowerCase();
                                if (wantChangeHostel.equals("y")||wantChangeHostel.equals("yes")) {
                                    detail.hostelName=sc.next();
                                }
                            }
                        }
                        System.out.println("*******SUCESSFULLY UPDATED********");
                    }
                }
                else{System.out.println("INCORRECT PIN");}
            }
            else if(user.equals("addmarks"))
            {
                System.out.println("Enter StudentId :");
                int studentId=sc.nextInt();
                for(Student student:studentDetails){
                   if(student.studentId==studentId && student.marksAddorNot){
                       student.marks= getMarks(student);
                       System.out.println("Marks successfully added");
                       checking=false;
                       break;
                    }
                }if(checking){
                System.out.println("Marks are already Added");
            }else{checking=true;}
            }
            else if(user.equals("search"))
            {
                System.out.println("Please enter student Id:");
                int search=sc.nextInt();
                for(Student detail:studentDetails){
                    if(search==detail.studentId){
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
                System.out.println("type 1 : all subjects score");
                System.out.println("type 2 : particular subject score");
                int switch1 = sc.nextInt();
                switch (switch1)
                {
                        case 1:
                        for(Student detail:studentDetails){
                            if(detail.studentId==academics && !detail.marksAddorNot){
                                detail.getScore();
                                checking=false;
                                break;
                            }
                        }if(checking){System.out.println("Marks are not added");}else {checking=true;}
                        break;
                        case 2:
                            ArrayList<String> checkSubjects=new ArrayList<>();
                            for(Student detail:studentDetails){
                                if(detail.studentId==academics){
                                    for(int i=0;i<detail.subject.length;i++){
                                        System.out.println("Subject  "+detail.subject[i]+" \n");
                                    }
                                    checkSubjects.addAll(Arrays.asList(detail.subject));
                                    break;
                                }
                            }
                            System.out.println("Enter subject name:");
                            String subject=sc.next();
                            if(checkSubjects.contains(subject)) {
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
                                    } else {
                                        checking = true;
                                    }
                                    break;
                                }
                            }else{
                                System.out.println("Subject not Found!!! type correctly");
                            }
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


