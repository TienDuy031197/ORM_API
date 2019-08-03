package com.topica.restapi.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topica.restapi.model.Course;

public interface CourseService extends JpaRepository<Course, Long> {
	List<Course> findCourseByName(String name);

	List<Course> findCourseById(int id);

	List<Course> deleteByName(String name);

	List<Course> deleteCourseById(int id);
}
