package com.dbs.directoryservice.model;

public class FileInfo {

	private String name;
	private long size;
	private boolean isDirectory;
	private boolean isSymbolicLink;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public boolean isDirectory() {
		return isDirectory;
	}

	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

	public boolean isSymbolicLink() {
		return isSymbolicLink;
	}

	public void setSymbolicLink(boolean isSymbolicLink) {
		this.isSymbolicLink = isSymbolicLink;
	}

	@Override
	public String toString() {
		return "FileInfo [name=" + name + ", size=" + size + ", isDirectory=" + isDirectory + ", isSymbolicLink="
				+ isSymbolicLink + "]";
	}

}
