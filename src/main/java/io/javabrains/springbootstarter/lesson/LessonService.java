package io.javabrains.springbootstarter.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;

	
	public List<Lesson> getAllLessons(String topicId, String courseId){
		List<Lesson> lessons = new ArrayList<>();
		lessonRepository.findByCourseId(courseId)
		.forEach(lessons::add);
		
		return lessons;
	}
	
	public Lesson getLesson(String lessonId) {
		return lessonRepository.findOne(lessonId);
	}
	
	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}
	
	public void updateLesson(String lessonId, Lesson lesson) {
		lessonRepository.save(lesson);
	}
	
	public void deleteLesson(String lessonId) {
		lessonRepository.delete(lessonId);
	}
	
}
