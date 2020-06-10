package com.dbs.directoryservice.model;

import java.util.List;

public class PathDTO {

	private String path;
	private List<FileInfo> children;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<FileInfo> getChildren() {
		return children;
	}

	public void setChildren(List<FileInfo> children) {
		this.children = children;
	}

	

}
