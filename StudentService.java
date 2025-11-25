import java.util.HashMap;

public class StudentService {

    private HashMap<Integer, Student> students = new HashMap<>();

    public void addStudent(int id, String name, String password) {
        students.put(id, new Student(id, name, password));
    }

    public Student login(int id, String password) {
        Student st = students.get(id);

        if (st == null) return null;
        if (!st.getPassword().equals(password)) return null;

        return st;
    }
}
