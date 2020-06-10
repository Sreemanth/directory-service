package com.dbs.directoryservice.services;

import com.dbs.directoryservice.model.FileInfo;
import com.dbs.directoryservice.model.PathDTO;

public interface FileService {

	public PathDTO listFiles(String directoryName);

	public FileInfo getFileInformation(String fullPathFileName);
}
