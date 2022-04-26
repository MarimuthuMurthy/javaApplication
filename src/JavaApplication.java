
import javax.security.auth.Subject;
import java.util.*;
class HostelNameException extends RuntimeException{
    HostelNameException(String hostel)
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
    public static Student getDetails()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter student name:");
        String studentName = sc.nextLine();

        while (!checkName(studentName)) {
            System.out.println("Invalid name! please enter again");
            studentName = sc.nextLine();
        }
        System.out.print("Enter student phone number:");
        String studentPhone = sc.next();
        while (!checkPhoneNumber(studentPhone)) {
            System.out.println("Invalid Phone Number! please enter again");
            studentPhone = sc.next();
        }
        System.out.print("Enter student room no:");
        String studentRoom = sc.next();
        while (!checkRoomNo(studentRoom)) {
            System.out.println("Invalid Room Number! please enter again");
            studentRoom = sc.next();
        }
        int intStudentRoom=Integer.parseInt(studentRoom);
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
                throw new HostelNameException("Sorry! you are not allowed in this institute");
        }
        System.out.println("\n"+"*********select department*********** "+
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
                throw new HostelNameException("sorry!!!other departments students are allowed");
        }
        String[] subject=null;
        String[] faculty=null;
        SubjectDetails[] subjectDetails=new SubjectDetails[5];
        int academicFee=0;
        if(departmentName.equals("cse")){
            subject=CseDepartment.cseSubjects;
            faculty=CseDepartment.cseFaculty;
            academicFee=CseDepartment.fees;
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
        }
        if(departmentName.equals("ece")){
            subject=EceDepartment.eceSubjects;
            faculty=EceDepartment.ecefaculty;
            academicFee=EceDepartment.fees;
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
        }
        if(departmentName.equals("mech")){
            subject=MechanicalDepartment.mechanicalSubjects;
            faculty=MechanicalDepartment.mechfaculty;
            academicFee=MechanicalDepartment.fees;
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
        }
        if(departmentName.equals("it")){
            subject=ItDepartment.itSubjects;
            faculty=ItDepartment.itfaculty;
            academicFee=ItDepartment.fees;
            for(int i=0;i<subject.length;i++){
                subjectDetails[i]=new SubjectDetails(subject[i],faculty[i],-1);
            }
        }
        System.out.println("*****Your Academic Fees is "+academicFee+" pay atleast 10000 rupees for initial transaction*****");
        int payment = sc.nextInt();
        while(payment<10000 || payment>academicFee){
            if(payment<10000) {
                System.out.println("Sorry!!!you have atleast 10000 rupees");
                System.out.print("Enter amount again: ");
                payment = sc.nextInt();
            }else {
                System.out.println("Sorry!!!you pay more than academic fee");
                System.out.print("Enter amount again: ");
                payment = sc.nextInt();
            }
        }
        studentId += 1;
        s1 = new Student(studentId, studentName, studentPhone, intStudentRoom, studentHostel,departmentName,subject,faculty,subjectDetails,payment);
        return s1;
    }
    public static int checkDueFee(Student s){
        switch (s.department) {
            case "cse":
                if (CseDepartment.fees == s.academicFee) {
                    return 0;
                } else if (s.academicFee < CseDepartment.fees) {
                    return CseDepartment.fees - s.academicFee;
                }
                break;
            case "ece":
                if (EceDepartment.fees == s.academicFee) {
                    return 0;
                } else if (s.academicFee < EceDepartment.fees) {
                    return EceDepartment.fees - s.academicFee;
                }
                break;
            case "mech":
                if (MechanicalDepartment.fees == s.academicFee) {
                    return 0;
                } else if (s.academicFee < MechanicalDepartment.fees) {
                    return MechanicalDepartment.fees - s.academicFee;
                }
                break;
            case "it":
                if (ItDepartment.fees == s.academicFee) {
                    return 0;
                } else if (s.academicFee < ItDepartment.fees) {
                    return ItDepartment.fees - s.academicFee;
                }
                break;
        }
        return 0;
    }
    public static void payAcademicFee(Student s)
    {
        int remainingBalance=checkDueFee(s);
        if(remainingBalance!=0)
        {
            System.out.println("******Your Fees due is " + remainingBalance);
            System.out.println("Enter amount : ");
            int amount = sc.nextInt();
            while(amount>remainingBalance) {
                System.out.println("you pay more than due!!!please correct amount......");
                amount= sc.nextInt();
            }
            s.academicFee=s.academicFee+amount;
            System.out.println("****Payment Successful****");
        }
        else{
            System.out.println("*******There is no Fees due******");
        }
    }
    public static void checkDueStudentRecord(){
        int feeMembers=0;
        if(studentDetails.isEmpty()){
            System.out.println("*******student records are not found*****");
        }else {
            for (Student student : studentDetails) {
                if (checkDueFee(student) != 0) {
                    System.out.println(student);
                    feeMembers++;
                    System.out.println("Fees Due : "+checkDueFee(student));
                    System.out.println("*********************************");
                }
            }if(feeMembers==0){
                System.out.println("*****All students are paid*****");
            }
        }
    }
    public static boolean checkName(String name){
        if(name.matches("[A-Za-z.\\s]*")){return true;}
        else{return false;}
    }
    public static boolean checkPhoneNumber(String phoneNo){
        if(phoneNo.matches("[0-9]{10}")){return true;}
        else{return false;}
    }
    public static boolean checkRoomNo(String roomNo){
        if(roomNo.matches("[0-9]{1,9}")){return true;}
        else{return false;}
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
            System.out.println("\n***** 1. ADD STUDENT DETAILS: *****" +
                    "\n***** 2. SEE STUDENT DETAILS: *****" +
                    "\n***** 3. REMOVE STUDENT DETAILS: *****" +
                    "\n***** 4. UPDATE DETAILS: *****" +
                    "\n***** 5. ADD MARKS OF STUDNET: *****" +
                    "\n***** 6. SEARCH RECORD: *****" +
                    "\n***** 7. SHOW THE MARKS OF STUDENT: *****" +
                    "\n***** 8. SHOW THE STUDENT SUBJECT AND FACULTY: *****" +
                    "\n***** 9. UPDATE SCORE"+
                    "\n***** 10. CHECK FEES DUE"+
                    "\n***** 11. ACADEMICS FEES PAYMENT"+
                    "\n***** 12. STUDENTS DUE LIST"+
                    "\n***** 13. END THE PROCESS: ***** ");
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            String user = sc.next().toLowerCase();
            if (!(user.matches("[0-9]+"))) {
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
                        String id = sc.next();
                        while(!(id.matches("[0-9]*"))){
                            System.out.println("Enter Correct studentId");
                            id=sc.next();
                        }
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
                        for (int i = 0; i < s2.subjectDetails.length; i++) {
                            System.out.println("If you want to add " + s2.subjectDetails[i].subjectName + " marks: type( 1 for yes / 2 for no)");
                            String askMarks = sc.next();
                            while (!(askMarks.matches("[1-2]"))) {
                                System.out.println("WRONG INPUT");
                                askMarks = sc.next();
                            }
                            if (askMarks.equals("1") && s2.subjectDetails[i].subjectMark==-1) {
                                System.out.println("enter marks: ");
                                s2.subjectDetails[i].setSubjectMark(sc.nextInt());
                            }
                            else if(askMarks.equals("1") && !(s2.subjectDetails[i].subjectMark==-1))
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
                                System.out.println("press "+i + " for " + s.subjectDetails[i].subjectName);
                            }
                            System.out.println("TYPE SUBJECT NUMBER:");
                            String subjectNum = sc.next();
                            while(!(subjectNum.matches("[0-4]")))
                            {
                                System.out.println("Enter Correct number");
                                subjectNum= sc.next();
                            }
                            int subjectNumber=Integer.parseInt(subjectNum);
                            if(!(s.subjectDetails[subjectNumber].subjectMark==-1)){
                            System.out.println("the " + s.subjectDetails[subjectNumber].subjectName + " marks are :" + s.subjectDetails[subjectNumber].subjectMark);
                            }
                            else{
                                System.out.println("***********MARKS ARE NOT ADDED*************");
                            }
                        default:
                            System.out.println("Enter subject code!!!!!correctly");
                    }
                }else{
                    System.out.println("STUDENT ID NOT FOUND");
                }
            }
            else if(user.equals("8"))
            {
                System.out.println("Enter the student id :");
                int studId=sc.nextInt();
                Student student;
                student=checkStudent(studId);
                if(student!=null){
                    for(int i=0;i<student.subjectDetails.length;i++){
                        System.out.println("Subject :"+student.subjectDetails[i].subjectName +" "+"Faculty Name :"+student.subjectDetails[i].subjectFaculty);
                    }
                }
                else{
                    System.out.println("Student ID NOT FOUND");
                }
            }
            else if(user.equals("9")) {
                System.out.println("******UPDATE MARKS*********");
                System.out.println("Enter student id : ");
                String studId = sc.next();
                while (!(studId.matches("[0-9]*"))) {
                    System.out.println("Enter student id correctly");
                }
                int studentId = Integer.parseInt(studId);
                Student s = checkStudent(studentId);
                if (s != null) {
                    for (int i = 0; i < s.subjectDetails.length; i++) {
                        System.out.println("Type.... " + i + " for update " + s.subjectDetails[i].subjectName + " subject");
                    }
                    System.out.println("Choose any Subject");
                    int choice = sc.nextInt();
                    if (choice < s.subjectDetails.length) {
                        if (s.subjectDetails[choice].subjectMark==-1) {
                            System.out.println("Subject marks are not added");
                        } else {
                            System.out.println("****Your old "+s.subjectDetails[choice].subjectName+" marks are"+s.subjectDetails[choice].subjectMark);
                            System.out.println("Enter new marks of "+s.subjectDetails[choice].subjectName);
                            s.subjectDetails[choice].setSubjectMark(sc.nextInt());
                        }
                    } else {
                        System.out.println("Subject code not found!!!!!!!!!!!");
                    }
                }else{
                    System.out.println("Student Id not Found");
                }
            }
            else if(user.equals("10")){
                System.out.print("***Enter Student Id : ");
                String studId = sc.next();
                while (!(studId.matches("[0-9]*"))) {
                    System.out.println("Enter student id correctly");
                }
                int studentId = Integer.parseInt(studId);
                Student s = checkStudent(studentId);
                if(s!=null){
                int dueAmount=checkDueFee(s);
                if(dueAmount==0){
                    System.out.println("*******There is no Fees due******");
                }
                else{
                    System.out.println("******Your Fees due is "+dueAmount+" *********");
                }}else{
                    System.out.println("*********Student Id not found********");
                }
            }
            else if(user.equals("11")){
                System.out.print("***Enter Student Id : ");
                String studId = sc.next();
                while (!(studId.matches("[0-9]*"))) {
                    System.out.println("Enter student id correctly");
                }
                int studentId = Integer.parseInt(studId);
                Student s = checkStudent(studentId);
                if(s!=null) {
                    payAcademicFee(s);
                }else{
                    System.out.println("******Student Id Not Found*****");
                }
            }
            else if(user.equals("12")){
                checkDueStudentRecord();
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
        Scanner sc=new Scanner(System.in);
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


