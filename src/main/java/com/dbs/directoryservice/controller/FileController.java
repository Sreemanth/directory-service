package com.dbs.directoryservice.controller;

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
	public PathDTO listFiles(@RequestParam("directoryPath") String directoryPath) throws Exception {
		try {
			return fileService.listFiles(directoryPath);
		} catch (Exception e) {
			LOGGER.error("Error occured whiel processing listFiles", e);
			throw e;
		}

	}

	@GetMapping("/getFileInformation")
	public FileInfo getFileInformation(@RequestParam("fileName") String fileName) throws Exception {
		try {
			return fileService.getFileInformation(fileName);
		} catch (Exception e) {
			LOGGER.error("Error occured whiel processing getFileInformation", e);
			throw e;
		}

	}
}
