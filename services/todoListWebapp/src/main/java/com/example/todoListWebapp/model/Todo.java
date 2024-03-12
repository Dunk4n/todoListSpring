package com.example.todoListWebapp.model;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo {
	private Long id;

	private String title = "";
	
	private String description = "";

	private Date onDate;

	private String cardColor = "#20d8ee";

	private boolean isCompleted;

	private Timestamp createdOn;

	private Timestamp modifiedOn;

	private Timestamp completedOn;
}
