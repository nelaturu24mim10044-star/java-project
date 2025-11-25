import java.util.Scanner;

public class Menu {

    private StudentService studentService;
    private CourseService courseService;
    private RegistrationService registrationService;

    private Scanner sc = new Scanner(System.in);

    public Menu(StudentService ss, CourseService cs, RegistrationService rs) {
        this.studentService = ss;
        this.courseService = cs;
        this.registrationService = rs;
    }

    public void start() {
        while (true) {
            System.out.println("\n===== Student Course Registration System =====");
            System.out.println("1. Register Student");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> registerStudent();
                case 2 -> loginStudent();
                case 3 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void registerStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        studentService.addStudent(id, name, pass);
        System.out.println("Registration Successful!");
    }

    private void loginStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        Student st = studentService.login(id, pass);

        if (st == null) {
            System.out.println("Login Failed!");
            return;
        }

        System.out.println("Login Successful! Welcome " + st.getName());
        studentMenu(st);
    }

    private void studentMenu(Student st) {
        while (true) {
            System.out.println("\n===== Student Menu =====");
            System.out.println("1. View Courses");
            System.out.println("2. Enroll in Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> courseService.listCourses();
                case 2 -> {
                    System.out.print("Enter Course ID: ");
                    int cid = sc.nextInt();
                    Course c = courseService.getCourse(cid);
                    if (c != null)
                        registrationService.enroll(st.getId(), c);
                    else
                        System.out.println("Course not found!");
                }
                case 3 -> {
                    System.out.print("Enter Course ID to drop: ");
                    int cid = sc.nextInt();
                    registrationService.dropCourse(st.getId(), cid);
                }
                case 4 -> registrationService.viewCourses(st.getId());
                case 5 -> {
                    System.out.println("Logged out.");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
