package Student.Management.Student.Management.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Student.Management.Student.Management.Dto.StudentDto;
import Student.Management.Student.Management.Entity.Student;
import Student.Management.Student.Management.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
    private StudentRepository studentRepository;
	
	
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	// Create a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Retrieve all students
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getEmail()
                ))
                .collect(Collectors.toList());
    }

    // Retrieve a single student by ID
    public StudentDto getStudentById(Long id) {
    	Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(this::convertToDto).orElse(new StudentDto());
    }
    private StudentDto convertToDto(Student student) {
        // Perform conversion logic here
        // For example:
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        return studentDto;
    }
    // Update an existing student
    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setFirstName(studentDetails.getFirstName());
            existingStudent.setLastName(studentDetails.getLastName());
            existingStudent.setEmail(studentDetails.getEmail());
            existingStudent.setPassword(studentDetails.getPassword());
            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

    // Delete a student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
