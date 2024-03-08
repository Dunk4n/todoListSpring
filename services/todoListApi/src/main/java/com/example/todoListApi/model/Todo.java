package com.example.todoListApi.model;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "todo")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title")
	private String title = "";
	
	@Column(name="description")
	private String description = "";

	@Column(name="on_date")
	private Date onDate;

	@Column(name="card_color")
	private String cardColor = "#20d8ee";

	@Column(name="is_completed")
	private boolean isCompleted;

	@Column(name="created_on")
	private Timestamp createdOn;

	@Column(name="modified_on")
	private Timestamp modifiedOn;

	@Column(name="completed_on")
	private Timestamp completedOn;

}
