package com.example.course.service;

import com.example.course.exception.NotFoundException;
import com.example.course.model.Course;
import com.example.course.repository.CourseRepository;
import com.example.course.repository.UserRepository;
import com.example.course.request.UpsertCourse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    public Course save(UpsertCourse upsertCourse) {
        Course newCourse = new Course(0,
                upsertCourse.getName(),
                upsertCourse.getDescription(),
                upsertCourse.getType(),
                upsertCourse.getTopics(),
                upsertCourse.getThumbnail(),
                upsertCourse.getUserId()
        );
        return courseRepository.save(newCourse);
    }

    public Course updateCourse(UpsertCourse upsertCourse, int id) {
        Course course = courseRepository.findByid(id).orElseThrow(() -> new NotFoundException("This id is not existed, id= " + id));
        if (upsertCourse.getName() != null ) course.setName(upsertCourse.getName());
        if(upsertCourse.getDescription() != null) course.setDescription(upsertCourse.getDescription());
        if(upsertCourse.getThumbnail() != null) course.setThumbnail(upsertCourse.getThumbnail());
        if (upsertCourse.getTopics() != null) course.setTopics(upsertCourse.getTopics());
        if (upsertCourse.getType() != null) course.setType(upsertCourse.getType());
        if (upsertCourse.getUserId() != null) course.setUserId(upsertCourse.getUserId());

        return course;
    }

    public ResponseEntity<Void> deleteCourse(int id) {
        courseRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}