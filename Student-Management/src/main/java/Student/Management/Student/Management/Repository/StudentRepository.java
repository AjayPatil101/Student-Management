package Student.Management.Student.Management.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import Student.Management.Student.Management.Entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
