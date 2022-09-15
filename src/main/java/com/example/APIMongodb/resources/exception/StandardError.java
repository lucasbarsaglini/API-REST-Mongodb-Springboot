package com.example.APIMongodb.resources.exception;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;

@Data
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public StandardError() {
	}

	public StandardError(long l, Integer status, String error, String message, String path) {
		super();
		this.timestamp = l;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}	
}