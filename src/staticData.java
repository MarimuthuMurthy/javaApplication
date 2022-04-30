import java.util.ArrayList;
import java.util.List;
class CseSubjectsAndFaculty {
    static String[] cseSubjectsSemester1 = {"java", "html", "datastructures", "python", "c"};
    static String[] cseSubjectsSemester2 = {"Fundamentals of Computer Programming", "Data Structures", "Computer Networks", "Object Oriented Programming", "Design and Analysis of Algorithms"};
    static String[] cseSubjectsSemester3 = {"Computer Architecture and Organisation", "Discrete Mathematics", "Database Management Systems", "Operating Systems", "Software Engineering"};
    static String[] cseSubjectsSemester4 = {"Theory of Computation", "Introduction to Communication Systems", "Multi-device Programming", "Advanced Java Programming", "Artificial Intelligence"};
    static String[] cseSubjectsSemester5 = {"Artificial Neural Network", "Introduction to Soft Computing", "Introduction to Internet-Of-Things", "Statistical Modeling for Data Science", "Advanced Communication Networks"};
    static String[] cseSubjectsSemester6 = {"High Performance Computing", "Introduction to Linear and Nonlinear Optimisation", "Wireless Sensor Networks and Applications", "Computer Vision", "Mobile Platform Programming"};
    static String[] cseSubjectsSemester7 = {"Web Intelligence and Algorithms", "Machine Learning", "Computational Geometry and Applications", "Cyber Security", "Game Theory"};
    static String[] cseSubjectsSemester8 = {"Introduction to Information Security", "Modeling and Simulation", "Information Retrieval", "Natural Language Processing", "Compiler Design"};
}
class CseDepartment{
    static String[][] cseSubjects = {CseSubjectsAndFaculty.cseSubjectsSemester1, CseSubjectsAndFaculty.cseSubjectsSemester2, CseSubjectsAndFaculty.cseSubjectsSemester3, CseSubjectsAndFaculty.cseSubjectsSemester4, CseSubjectsAndFaculty.cseSubjectsSemester5, CseSubjectsAndFaculty.cseSubjectsSemester6, CseSubjectsAndFaculty.cseSubjectsSemester7, CseSubjectsAndFaculty.cseSubjectsSemester8};
    static Faculty[][] cseFaculties= new Faculty[8][];
}
    class EceSubjectsAndFaculty {
        static String[] eceSubjectsSemester1 = {"analog", "system", "communication", "wireless", "networks"};
        static String[] eceSubjectsSemester2 = {"Analog Electronics", "Signal & System", "Electromagnetic Theory", "Digital Signal Processing", "Analog and Digital Communications"};
        static String[] eceSubjectsSemester3 = {"Integrated Electronics", "Communication Network", "Antenna and Microwave Propagation", "Microprocessor & Microcontroller", "Fiber-Optic and Satellite Communications Systems"};
        static String[] eceSubjectsSemester4 = {"Control Theory", "Coding and Information Theory", "Advanced Embedded Systems", "Advanced Digital Signal Processing", "Digital Image Processing+"};
        static String[] eceSubjectsSemester5 = {"Wireless Broadband Communications", "Optical Networks", "Non-Linear Optical Communication", "Satellite Communications", "Advanced VLSI"};
        static String[] eceSubjectsSemester6 = {"Internet of Things", "Computer Vision", "Power Electronics", "Radar Engineering", "Cellular and Mobile Communications"};
        static String[] eceSubjectsSemester7 = {"Advanced Wireless Broadband Communications", "Networks", "Embedded", "Microprocessor", "Fiber"};
        static String[] eceSubjectsSemester8 = {"Electronics", "Information", "Electromagnetic", "Digital", "Processing"};
    }
class EceDepartment{
    static String[][] eceSubjects = {EceSubjectsAndFaculty.eceSubjectsSemester1, EceSubjectsAndFaculty.eceSubjectsSemester2, EceSubjectsAndFaculty.eceSubjectsSemester3, EceSubjectsAndFaculty.eceSubjectsSemester4, EceSubjectsAndFaculty.eceSubjectsSemester5, EceSubjectsAndFaculty.eceSubjectsSemester6, EceSubjectsAndFaculty.eceSubjectsSemester7, EceSubjectsAndFaculty.eceSubjectsSemester8};
    static Faculty[][] eceFaculties= new Faculty[8][];
}

        class MechanicalSubjectAndFaculty {
            static String[] mechanicalSubjectsSemester1 = {"Thermodynamics", "Solid Mechanics - I", "Engineering Materials", "HSS Elective - I", "Machine Drawing"};
            static String[] mechanicalSubjectsSemester2 = {"Fluid Mechanics - I", "Manufacturing Technology - I", "Solid Mechanics - II", "Kinematics of Machinery", "HSS Elective  - II"};
            static String[] mechanicalSubjectsSemester3 = {"Workshop  - II", "Mechanical Lab - I", "Fluid Mechanics - II", "Manufacturing Technology - II", "Dynamics of Machinery"};
            static String[] mechanicalSubjectsSemester4 = {"Design of Machine Elements", "Electrical Machines", "HSS Elective - III", "Mechanical Lab -  II", "Applied Thermodynamics - I"};
            static String[] mechanicalSubjectsSemester5 = {"Machine Design", "Mechanical Measurements", "Heat and Mass Transfer", "Control Systems", "Mechanical Lab - III"};
            static String[] mechanicalSubjectsSemester6 = {"Design", "Mechanical", "Elective", "Workshop", "Applied"};
            static String[] mechanicalSubjectsSemester7 = {"Fluid", "Design", "Measurements", "Technology", "theoryofmachines"};
            static String[] mechanicalSubjectsSemester8 = {"Kinematics-1", "Dynamics ", "Elective", "Mass", "Systems"};
        }
class MechanicalDepartment {
    static String[][] mechanicalSubjects = {MechanicalSubjectAndFaculty.mechanicalSubjectsSemester1, MechanicalSubjectAndFaculty.mechanicalSubjectsSemester2, MechanicalSubjectAndFaculty.mechanicalSubjectsSemester3, MechanicalSubjectAndFaculty.mechanicalSubjectsSemester4, MechanicalSubjectAndFaculty.mechanicalSubjectsSemester5, MechanicalSubjectAndFaculty.mechanicalSubjectsSemester6, MechanicalSubjectAndFaculty.mechanicalSubjectsSemester7, MechanicalSubjectAndFaculty.mechanicalSubjectsSemester8};
    static Faculty[][] mechanicalFaculties = new Faculty[8][];
}

class ItsubjectsAndFaculty {
        static String[] itSubjectsSemester1 = {"Computer", "Architecture", "Organization", "object", "orineted"};
        static String[] itSubjectsSemester2 = {"programming", "Operating ", "Systems", "computer", "networks"};
        static String[] itSubjectsSemester3 = {"Java", "Programming", "Website", "Design", "data"};
        static String[] itSubjectsSemester4 = {"warehouse", "metadata", "datamining", "system", "software"};
        static String[] itSubjectsSemester5 = {"Software", "Engineering", "e-commerce", "Database", "Systems"};
        static String[] itSubjectsSemester6 = {"Design", "Analysis", "Algorithms", "Database", "Management"};
        static String[] itSubjectsSemester7 = {"Systems", "multimedia", "communiaction", "oose", "microcontroller"};
        static String[] itSubjectsSemester8 = {"engineering mathematics", "engineering", "graphics", "agile", "scrum"};
    }
    class ItDepartment{
        static String[][] itTotalSubjects = {ItsubjectsAndFaculty.itSubjectsSemester1,ItsubjectsAndFaculty.itSubjectsSemester2,ItsubjectsAndFaculty.itSubjectsSemester3,ItsubjectsAndFaculty.itSubjectsSemester4,ItsubjectsAndFaculty.itSubjectsSemester5,ItsubjectsAndFaculty.itSubjectsSemester6,ItsubjectsAndFaculty.itSubjectsSemester7,ItsubjectsAndFaculty.itSubjectsSemester8};
        static Faculty[][] itFaculties= new Faculty[8][];
}
    class StudentDetails{
        static List<Student> studentDetails=new ArrayList<>();
    }
    class SubjectDetails{
    static List<Subject> subjectDetails = new ArrayList<>();
    }
    class FacultyDetails{
    static List<Faculty> facultyDetails = new ArrayList<>();
    }
