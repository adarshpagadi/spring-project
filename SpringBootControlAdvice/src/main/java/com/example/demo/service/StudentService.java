package com.example.demo.service;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	
	@Autowired
	 StudentRepo studentRepo ;

	public Student getStudentById(int id) throws StudentNotFoundException {
		Optional<Student> findById = studentRepo.findById(id);
		if (!findById.isPresent()) {
			throw new StudentNotFoundException(String.format("Student not found with id %s", id));
		}
		return findById.get();
	}

	public Student saveStudent(Student student) {
		Student savedStudent = studentRepo.save(student);
		return savedStudent;
	}

	public Student updateStudent(Student student) throws StudentNotFoundException {
		Optional<Student> findById = studentRepo.findById(student.getId());
		if (!findById.isPresent()) {
			throw new StudentNotFoundException(String.format("Student not found with id %s", student.getId()));
		}
		Student studentToSave = findById.get();
		BeanUtils.copyProperties(student, studentToSave);
        Student saved = studentRepo.save(studentToSave);
        return saved;
	}

	public void deleteStudent(int id) throws StudentNotFoundException{
		Optional<Student> findById = studentRepo.findById(id);
		Student student = findById.orElseThrow(() -> new StudentNotFoundException(String.format("Student not found with id %s", id)));
		studentRepo.delete(student);
	}

}
