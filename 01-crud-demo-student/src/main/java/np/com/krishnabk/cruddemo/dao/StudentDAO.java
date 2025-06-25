package np.com.krishnabk.cruddemo.dao;

import np.com.krishnabk.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastname);
}
