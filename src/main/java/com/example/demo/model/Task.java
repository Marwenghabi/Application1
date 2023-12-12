package com.example.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task implements Serializable {
	
    private Long id;
    @JsonProperty("description")
    private String description;

    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Task() {
    }

    public Task(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
