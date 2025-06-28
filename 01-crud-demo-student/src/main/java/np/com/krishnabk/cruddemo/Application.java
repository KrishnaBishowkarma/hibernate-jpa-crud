package np.com.krishnabk.cruddemo;

import np.com.krishnabk.cruddemo.dao.StudentDAO;
import np.com.krishnabk.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
            // createStudent(studentDAO);

            // createMultipleStudent(studentDAO);

            // readStudent(studentDAO);

            // queryForStudents(studentDAO);

            // queryForStudentsByLastName(studentDAO);

            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {

        // retrieve student based on the id: Primary Key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name back to "Krishna"
        System.out.println("Updating student ...");
        myStudent.setFirstName("Krishna");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("BK");

        // display list of students
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating student ...");
        Student tempStudent = new Student("Ram", "Ji", "ram@krishna-bk.com.np");

        // save the student
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated ID: " + theId);

        // retrieve student based on the id
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display student
        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudent(StudentDAO studentDAO) {

        // create multiple student
        System.out.println("Creating 3 student objects ...");
        Student tempStudent1 = new Student("Krishna", "Bishowkarma", "contact@krishna-bk.com.np");
        Student tempStudent2 = new Student("Naresh", "BK", "naresh@krishna-bk.com.np");
        Student tempStudent3 = new Student("Bhim", "BK", "bhim@krishna-bk.com.np");

        // save the student object\
        System.out.println("Saving the student objects ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Jon", "Doe", "jon@gmail.com");

        // save the student object
        System.out.println("Saving the student object");
        studentDAO.save(tempStudent);

        // display the id of the saved student
        System.out.println("Saved student. Generated ID: " + tempStudent.getId());
    }
}
