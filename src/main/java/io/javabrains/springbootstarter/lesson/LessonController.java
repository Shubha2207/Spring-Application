package io.javabrains.springbootstarter.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.course.Course;
import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class LessonController {
	
	
	@Autowired
	private LessonService lessonService;
	
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String topicId, @PathVariable String courseId) {
		return lessonService.getAllLessons(topicId, courseId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getLesson(@PathVariable String topicId, @PathVariable String courseId, @PathVariable String lessonId) {
		return lessonService.getLesson(lessonId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@PathVariable String topicId, @PathVariable String courseId, @RequestBody Lesson lesson) {
		lesson.setCourse(new Course(courseId, "","",""));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void updateLesson(@RequestBody Lesson lesson,@PathVariable String lessonId) {
		lessonService.updateLesson(lessonId, lesson);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}/courses/{courseId}/lessons/{lessonId}")
	public void deleteLesson(@PathVariable String lessonId) {
		lessonService.deleteLesson(lessonId);
	}
	
}
