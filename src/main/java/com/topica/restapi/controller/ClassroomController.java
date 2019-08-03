package com.topica.restapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topica.restapi.model.Classroom;
import com.topica.restapi.service.ClassroomService;
import com.topica.restapi.service.UserServiceUpdate;

@RestController
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;

	@RequestMapping(path = "/api/getlistclassromm", method = RequestMethod.GET)
	public List<Classroom> getListClassroom(@RequestParam String courseid, @RequestParam String kidid,
			@RequestParam String teacherid) {
		long courseId = Long.parseLong(courseid);
		long kidId = Long.parseLong(kidid);
		long teacherId = Long.parseLong(teacherid);
		return classroomService.getClassroomByCourseIdAndKidIdAndTeacherId(courseId, kidId, teacherId);
	}

	@RequestMapping(path = "/api/getlistclassrommwithtime", method = RequestMethod.GET)
	public List<Classroom> getListClassroomWithTime() {
		return classroomService.findClassroom();

	}

}
