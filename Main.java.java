public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        RegistrationService registrationService = new RegistrationService();

        // Add some demo courses
        courseService.addCourse(101, "Object Oriented Programming");
        courseService.addCourse(102, "Data Structures");
        courseService.addCourse(103, "Database Systems");

        Menu menu = new Menu(studentService, courseService, registrationService);
        menu.start();
    }
}
