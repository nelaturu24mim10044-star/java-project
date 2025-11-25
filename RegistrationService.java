import java.util.ArrayList;
import java.util.HashMap;

public class RegistrationService {

    private HashMap<Integer, ArrayList<Course>> registeredCourses = new HashMap<>();

    public void enroll(int studentId, Course course) {
        registeredCourses.putIfAbsent(studentId, new ArrayList<>());

        ArrayList<Course> list = registeredCourses.get(studentId);

        for (Course c : list) {
            if (c.getId() == course.getId()) {
                System.out.println("Already enrolled!");
                return;
            }
        }

        list.add(course);
        System.out.println("Enrollment Successful!");
    }

    public void dropCourse(int studentId, int courseId) {
        if (!registeredCourses.containsKey(studentId)) {
            System.out.println("No courses registered.");
            return;
        }

        ArrayList<Course> list = registeredCourses.get(studentId);

        boolean removed = list.removeIf(c -> c.getId() == courseId);

        if (removed)
            System.out.println("Dropped Successfully!");
        else
            System.out.println("Course not found in your list.");
    }

    public void viewCourses(int studentId) {
        System.out.println("\nYour Registered Courses:");

        if (!registeredCourses.containsKey(studentId)) {
            System.out.println("None");
            return;
        }

        for (Course c : registeredCourses.get(studentId)) {
            System.out.println(c.getId() + " - " + c.getName());
        }
    }
}
