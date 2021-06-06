package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		
		return courses;
	}
	
	public Course getCourse(String CourseId) {
		return courseRepository.findOne(CourseId);
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(String courseId, Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String courseId) {
		courseRepository.delete(courseId);
	}
	
}
