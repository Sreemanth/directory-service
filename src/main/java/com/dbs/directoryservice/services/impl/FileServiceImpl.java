package com.dbs.directoryservice.services.impl;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dbs.directoryservice.model.FileAttributeMapper;
import com.dbs.directoryservice.model.FileInfo;
import com.dbs.directoryservice.model.PathDTO;
import com.dbs.directoryservice.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public PathDTO listFiles(String directoryPath) {

		Path path = Paths.get(directoryPath);
		final List<FileInfo> children = new ArrayList<FileInfo>();
		try {
			Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

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
		} catch (IOException e) {
			e.printStackTrace();
		}

		PathDTO result = new PathDTO();
		result.setChilds(children);
		result.setPath(path.toString());
		return result;
	}

	@Override
	public FileInfo getFileInformation(String filePath) {

		Path path = Paths.get(filePath);
		FileInfo result = null;
		try {
			BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
			result = FileAttributeMapper.prepareFileInfo(path, fileAttributes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
