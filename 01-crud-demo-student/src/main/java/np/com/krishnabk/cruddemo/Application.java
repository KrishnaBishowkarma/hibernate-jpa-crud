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
            createStudent(studentDAO);
        };
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
