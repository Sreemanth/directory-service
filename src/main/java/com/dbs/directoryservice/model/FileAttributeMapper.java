package com.dbs.directoryservice.model;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributeMapper {

	private FileAttributeMapper() {
	}

	public static FileInfo prepareFileInfo(Path path, BasicFileAttributes fileAttributes) {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setName(path.toString());
		fileInfo.setSize(fileAttributes.size());
		fileInfo.setDirectory(fileAttributes.isDirectory());
		fileInfo.setSymbolicLink(fileAttributes.isSymbolicLink());
		return fileInfo;
	}

}
