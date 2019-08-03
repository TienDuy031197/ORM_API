package com.topica.restapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Course")
public class Course implements Serializable {
	private long id;
	private String name;
	private String description;

	public Course(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Course(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Course() {

	}

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@NotNull
	@Size(max = 50)
	@Column(name = "name", length = 50, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Size(max = 50)
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Course course = (Course) o;
		return id == course.id && Objects.equals(name, course.name) && Objects.equals(description, course.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description);
	}

	@Override
	public String toString() {
		return "Course{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + '}';
	}
}