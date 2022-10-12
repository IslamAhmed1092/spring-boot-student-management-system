package com.example.springboot.studentmanagementsystem.facade;

import com.example.springboot.studentmanagementsystem.dto.CourseAttendanceDTO;
import com.example.springboot.studentmanagementsystem.entity.CourseAttendance;
import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;
import com.example.springboot.studentmanagementsystem.service.CourseAttendanceService;
import com.example.springboot.studentmanagementsystem.service.CourseService;
import com.example.springboot.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseAttendanceFacadeImpl implements CourseAttendanceFacade {

    private CourseAttendanceService courseAttendanceService;
    private CourseService courseService;
    private StudentService studentService;

    @Autowired
    public CourseAttendanceFacadeImpl(CourseAttendanceService courseAttendanceService, CourseService courseService, StudentService studentService) {
        this.courseAttendanceService = courseAttendanceService;
        this.courseService = courseService;
        this.studentService = studentService;
    }


    @Override
    public void add(CourseAttendanceDTO courseAttendanceDTO) {
        CourseAttendance courseAttendance = convertToEntity(courseAttendanceDTO);
        courseAttendance.setId(0);
        courseAttendanceService.save(courseAttendance);
        courseAttendanceDTO.setId(courseAttendance.getId());
    }

    @Override
    public void update(CourseAttendanceDTO courseAttendanceDTO) {

        CourseAttendance dbCourseAttendance = courseAttendanceService.findById(courseAttendanceDTO.getId());

        if(dbCourseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + courseAttendanceDTO.getId());
        }

        CourseAttendance courseAttendance = convertToEntity(courseAttendanceDTO);
        courseAttendanceService.save(courseAttendance);
    }

    @Override
    public void addAll(List<CourseAttendanceDTO> courseAttendanceDTOs) {

        List<CourseAttendance> courseAttendances = courseAttendanceDTOs.stream().map(this::convertToEntity)
                .collect(Collectors.toList());

        courseAttendances = courseAttendances.stream().peek(courseAttendance -> courseAttendance.setId(0))
                .collect(Collectors.toList());

        courseAttendanceService.saveAll(courseAttendances);

        for (int i = 0; i < courseAttendances.size(); i++) {
            courseAttendanceDTOs.get(i).setId(courseAttendances.get(i).getId());
        }
    }

    @Override
    public void deleteById(int id) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(id);

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + id);
        }

        courseAttendanceService.deleteById(id);
    }

    @Override
    public List<CourseAttendanceDTO> findAll() {
        return courseAttendanceService.findAll().stream().map(CourseAttendanceDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseAttendanceDTO findById(int id) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(id);

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + id);
        }

        return CourseAttendanceDTO.convertToDTO(courseAttendance);
    }

    private CourseAttendance convertToEntity(CourseAttendanceDTO courseAttendanceDTO) {

        Course course = courseService.findById(courseAttendanceDTO.getCourseId());

        if(course == null) {
            throw new RuntimeException("Course id not found - " + courseAttendanceDTO.getCourseId());
        }

        Student student = studentService.findById(courseAttendanceDTO.getStudentId());

        if(student == null) {
            throw new RuntimeException("Student id not found - " + courseAttendanceDTO.getStudentId());
        }

        CourseAttendance courseAttendance = new CourseAttendance(courseAttendanceDTO);
        courseAttendance.setCourse(course);
        courseAttendance.setStudent(student);

        return courseAttendance;
    }
}
