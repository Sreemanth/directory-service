package com.dbs.directoryservice.services.impl;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.directoryservice.config.FileServiceProperties;
import com.dbs.directoryservice.model.FileAttributeMapper;
import com.dbs.directoryservice.model.FileInfo;
import com.dbs.directoryservice.model.PathDTO;
import com.dbs.directoryservice.services.FileService;

@Service
public class FileServiceImpl implements FileService {
	public static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

	@Autowired
	private FileServiceProperties fileServiceProperties;

	@Override
	public PathDTO listFiles(String directoryPath) throws Exception {

		Path path = Paths.get(directoryPath);
		final List<FileInfo> children = new ArrayList<FileInfo>();
		LOGGER.info("Configured max-depth:{}", fileServiceProperties.getMaxDepth());
		Files.walkFileTree(path, EnumSet.noneOf(FileVisitOption.class), fileServiceProperties.getMaxDepth(),
				new SimpleFileVisitor<Path>() {

					@Override
					public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
						FileInfo info = FileAttributeMapper.prepareFileInfo(dir, attrs);
						children.add(info);
						return FileVisitResult.CONTINUE;
					}

					@Override
					public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
						FileInfo info = FileAttributeMapper.prepareFileInfo(file, attrs);
						children.add(info);
						return FileVisitResult.CONTINUE;
					}

				});

		PathDTO result = new PathDTO();
		result.setChildren(children);
		result.setPath(path.toString());
		return result;
	}

	@Override
	public FileInfo getFileInformation(String filePath) throws Exception {

		Path path = Paths.get(filePath);
		FileInfo result = null;

		BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
		result = FileAttributeMapper.prepareFileInfo(path, fileAttributes);

		return result;
	}

}
