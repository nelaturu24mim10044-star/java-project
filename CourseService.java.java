import java.util.ArrayList;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(int id, String name) {
        courses.add(new Course(id, name));
    }

    public void listCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course c : courses) {
            System.out.println(c.getId() + " - " + c.getName());
        }
    }

    public Course getCourse(int id) {
        for (Course c : courses) {
            if (c.getId() == id) return c;
        }
        return null;
    }
}
