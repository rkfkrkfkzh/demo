package com.example.demo.fileUpload;

import org.springframework.web.multipart.MultipartFile;

public class MyFile {
	private String title;
	private MultipartFile file;

	public MyFile() {
	}

	public MyFile(String title, MultipartFile file) {
		this.title = title;
		this.file = file;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "MyFile [title=" + title + ", file=" + file + "]";
	}

}
