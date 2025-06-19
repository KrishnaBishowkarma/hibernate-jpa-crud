package np.com.krishnabk.cruddemo;

import np.com.krishnabk.cruddemo.dao.StudentDAO;
import np.com.krishnabk.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
//            createStudent(studentDAO);

            createMultipleStudent(studentDAO);
        };
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
