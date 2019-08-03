package com.topica.restapi.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topica.restapi.model.Course;
import com.topica.restapi.model.User;
import com.topica.restapi.service.CourseService;
import com.topica.restapi.service.UserServiceUpdate;

@RestController
public class CourseController {

	@Autowired
	private CourseService CourseService;

	@Autowired
	private UserServiceUpdate userServiceUpdate;

	@RequestMapping(path = "/api/getcoursebyid", method = RequestMethod.GET)
	public List<Course> getCourseById(@RequestParam String id) {
		return CourseService.findCourseById(Integer.parseInt(id));
	}

	// manager course
	@RequestMapping(path = "/api/getcoursebyname", method = RequestMethod.GET)
	public List<Course> getCourseByName(@RequestParam String name) {
		return CourseService.findCourseByName(name);
	}

	@RequestMapping(path = "/api/getallcourse", method = RequestMethod.GET)
	public List<Course> getAllCourse() {
		return CourseService.findAll();
	}

	@RequestMapping(path = "/api/deletebyname", method = RequestMethod.GET)
	@Transactional
	public List<Course> deleteCourseByName(@RequestParam String name) {
		CourseService.deleteByName(name);
		return getAllCourse();
	}

	@RequestMapping(path = "/api/deletebyid", method = RequestMethod.GET)
	@Transactional
	public List<Course> deleteCourseById(@RequestParam String id) {
		CourseService.deleteCourseById(Integer.parseInt(id));
		return getAllCourse();
	}

	@RequestMapping(path = "/api/addcourse", method = RequestMethod.GET)
	@Transactional
	public List<Course> addCourse(@RequestParam String name, @RequestParam String decreption) {
		CourseService.save(new Course(name, decreption));
		return getAllCourse();
	}

}
