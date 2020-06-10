package com.dbs.directoryservice.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.directoryservice.model.FileInfo;
import com.dbs.directoryservice.model.PathDTO;
import com.dbs.directoryservice.services.FileService;

@RestController
public class FileController {
	public static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private FileService fileService;

	@GetMapping("/myhealth")
	public String myhealth() {
		return "OK";
	}

	@GetMapping("/listFiles")
	public PathDTO listFiles(@RequestParam("directoryPath") String directoryPath) throws IOException {
		return fileService.listFiles(directoryPath);
	}

	@GetMapping("/getFileInformation")
	public FileInfo getFileInformation(@RequestParam("fileName") String fileName) {
		return fileService.getFileInformation(fileName);
	}
}
