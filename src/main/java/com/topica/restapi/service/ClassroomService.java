package com.topica.restapi.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.topica.restapi.model.Classroom;

public interface ClassroomService extends JpaRepository<Classroom, Long> {
    List<Classroom> getClassroomByCourseIdAndKidIdAndTeacherId(long courseId,long kidId,long teacherId);


    @Query("from Classroom where  (starttime - CURRENT_TIME)  < '00:30:00' and starttime > CURRENT_TIME or status=1")
    List<Classroom> findClassroom();
}
