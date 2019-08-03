package com.topica.restapi.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "classroom")
public class Classroom {

	private long id;
	private Timestamp startTime;
	private long status;
	private long courseId;
	private long kidId;
	private long teacherId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "starttime")
	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Column(name = "status")
	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	@Column(name = "courseid")
	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	@Column(name = "kidid")
	public long getKidId() {
		return kidId;
	}

	public void setKidId(long kidId) {
		this.kidId = kidId;
	}

	@Column(name = "teacherid")
	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
}