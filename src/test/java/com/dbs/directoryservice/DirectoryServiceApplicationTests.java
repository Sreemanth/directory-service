package com.dbs.directoryservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dbs.directoryservice.config.FileServiceProperties;
import com.dbs.directoryservice.controller.FileController;

@SpringBootTest
class DirectoryServiceApplicationTests {

	@Autowired
	private FileController fileController;
	
	@Autowired
	private FileServiceProperties fileServiceProperties;

	@Test
	void contextLoads() {
		
		assertThat(fileController).isNotNull();
		assertThat(fileServiceProperties).isNotNull();
	}

}
