package com.example.springboot.studentmanagementsystem.facade;

import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.dto.CourseDTO;
import com.example.springboot.studentmanagementsystem.entity.Teacher;
import com.example.springboot.studentmanagementsystem.service.CourseService;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;
import com.example.springboot.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseFacadeImpl implements CourseFacade {

    private CourseService courseService;
    private TeacherService teacherService;

    @Autowired
    public CourseFacadeImpl(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @Override
    public void add(CourseDTO courseDTO) {
        Course course = convertToEntity(courseDTO);
        course.setId(0);
        courseService.save(course);
        courseDTO.setId(course.getId());
    }

    @Override
    public void update(CourseDTO courseDTO) {
        Course dbCourse = courseService.findById(courseDTO.getId());

        if(dbCourse == null) {
            throw new RuntimeException("Course id not found - " + courseDTO.getId());
        }

        Course course = convertToEntity(courseDTO);
        courseService.save(course);
    }


    @Override
    public void deleteById(int id) {
        Course course = courseService.findById(id);

        if(course == null) {
            throw new RuntimeException("Course id not found - " + id);
        }

        courseService.deleteById(id);
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseService.findAll().stream().map(CourseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(int id) {
        Course course = courseService.findById(id);

        if(course == null) {
            throw new RuntimeException("Course id not found - " + id);
        }

        return new CourseDTO(course);
    }

    @Override
    public List<Student> getStudentsInCourse(int courseId) {
        return courseService.getStudentsInCourse(courseId);
    }

    @Override
    public List<AssignmentDTO> getAssignmentsInCourse(int courseId) {
        return courseService.getAssignmentsInCourse(courseId).stream().map(AssignmentDTO::new).collect(Collectors.toList());
    }

    private Course convertToEntity(CourseDTO courseDTO) {

        Teacher teacher = teacherService.findById(courseDTO.getTeacherId());

        if(teacher == null) {
            throw new RuntimeException("Teacher id not found - " + courseDTO.getTeacherId());
        }

        Course course = new Course(courseDTO);
        course.setTeacher(teacher);

        return course;
    }
}
