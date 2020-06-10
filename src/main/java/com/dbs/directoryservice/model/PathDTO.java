package com.dbs.directoryservice.model;

import java.util.List;

public class PathDTO {

	private String path;
	private List<FileInfo> childs;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<FileInfo> getChilds() {
		return childs;
	}

	public void setChilds(List<FileInfo> childs) {
		this.childs = childs;
	}

}
