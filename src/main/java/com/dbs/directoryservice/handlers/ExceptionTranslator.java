package com.dbs.directoryservice.handlers;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ExceptionTranslator {

	@Autowired
	private Environment env;

	@ExceptionHandler(value = NoSuchFileException.class)
	public ResponseEntity<BaseError> noSuchFileException(NoSuchFileException nsfe) {
		BaseError error = new BaseError();
		error.setCode(ErrorCodes.NO_SUCH_FILE_EXIST.name());
		error.setDescription(env.getProperty(ErrorCodes.NO_SUCH_FILE_EXIST.name(), "No such file exist"));
		error.setStackTrace(NestedExceptionUtils.buildMessage("No such file exists", nsfe));
		return new ResponseEntity<BaseError>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = IOException.class)
	public ResponseEntity<BaseError> inputOutputException(IOException ioe) {
		BaseError error = new BaseError();
		error.setCode(ErrorCodes.IO_ERROR.name());
		error.setDescription(env.getProperty(ErrorCodes.IO_ERROR.name(), "Input error"));
		error.setStackTrace(NestedExceptionUtils.buildMessage("Input error", ioe));
		return new ResponseEntity<BaseError>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = AccessDeniedException.class)
	public ResponseEntity<BaseError> accessDenieDException(AccessDeniedException ade) {
		BaseError error = new BaseError();
		error.setCode(ErrorCodes.ACCESS_DENIED.name());
		error.setDescription(env.getProperty(ErrorCodes.ACCESS_DENIED.name(), "Access Denied"));
		error.setStackTrace(NestedExceptionUtils.buildMessage("Acess denied for file", ade));
		return new ResponseEntity<BaseError>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<BaseError> unknownError(Exception e) {
		BaseError error = new BaseError();
		error.setCode(ErrorCodes.UNKNOWN_ERROR.name());
		error.setDescription(env.getProperty(ErrorCodes.UNKNOWN_ERROR.name(), "Unknown error"));
		error.setStackTrace(NestedExceptionUtils.buildMessage("Unknown error", e));
		return new ResponseEntity<BaseError>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
