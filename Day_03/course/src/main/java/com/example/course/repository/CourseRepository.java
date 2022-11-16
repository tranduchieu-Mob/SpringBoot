package com.example.course.repository;

import com.example.course.exception.NotFoundException;
import com.example.course.model.Course;
import com.example.course.model.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class CourseRepository {
    private List<Course> courses;
    private final Faker faker;

    private final UserRepository userRepository ;

    public CourseRepository(Faker faker,UserRepository userRepository){
        this.faker = faker;
        this.userRepository = userRepository;
        initCourse();
    }

    private void initCourse(){
        courses = new ArrayList<>();

        Random rd = new Random();

        List<String> topics = List.of("fontend","backend","database","devops","AWS","basic","mobile");
        List<User> users = userRepository.findAll();
        for (int i = 0; i < 21; i++){
            //Random topic
            List<String> rdTopics = new ArrayList<>();
            for (int j = 0; j < 3 ; j++){
                String rdTopic = topics.get(rd.nextInt(topics.size()));
                if (!rdTopics.contains(rdTopic)){
                    rdTopics.add(rdTopic);
                }
            }
            //Random user


            User rdUser = users.get(rd.nextInt(users.size()));
            //Tạo khóa học
            Course course = new Course(i
                    ,faker.funnyName().name()
                    ,faker.lorem().sentence(20)
                    ,rd.nextInt(2) == 1 ? "online" : "onlab"
                    ,rdTopics
                    ,faker.avatar().image()
                    ,rdUser.getId());
            courses.add(course);
        }

    }

    public List<Course> findAll(){
        return courses;
    }
    public Optional<Course> findByid(int id) {
        Optional<Course> course = courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        return course;
    }

    public Course save(Course course) {
        int id = courses.get(courses.size() - 1).getId() + 1;
        course.setId(id);
        courses.add(course);
        return course;
    }

    public void deleteById(int id) {
        Course course = findByid(id).
                orElseThrow(() -> new NotFoundException("Id is not existed " + id));
        courses.remove(course);
    }
}
