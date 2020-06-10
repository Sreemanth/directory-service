package com.dbs.directoryservice.services;

import com.dbs.directoryservice.model.FileInfo;
import com.dbs.directoryservice.model.PathDTO;

public interface FileService {

	/**
	 * Lists the files and directories (recursively) for given directory name
	 * 
	 * @param directoryName
	 * @return PathDTO, which contains the information related to all files in the
	 *         directory (recursively)
	 * @throws Exception
	 */
	public PathDTO listFiles(String directoryName) throws Exception;

	/**
	 * Gets the file attributes of a given file. i.e readable, writable, executable,
	 * size of file in bytes, directory and name etc.
	 * 
	 * @param fullPathFileName
	 * @return FileInfo , Contains file attributes for given file.
	 * @throws Exception
	 */
	public FileInfo getFileInformation(String fullPathFileName) throws Exception;
}
