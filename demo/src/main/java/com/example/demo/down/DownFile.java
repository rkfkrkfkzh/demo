package com.example.demo.down;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class DownFile {
	private int num;
	private String path;
	private String title;
	private String content;
	private String writer_id;
	private Date up_date;
	private int hit;
	private MultipartFile file;
	
	public DownFile(){}
	public DownFile(int num, String path, String title, String content, String writer_id, Date up_date, int hit) {
		this.num = num;
		this.path = path;
		this.title = title;
		this.content = content;
		this.writer_id = writer_id;
		this.up_date = up_date;
		this.hit = hit;
	}
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public Date getUp_date() {
		return up_date;
	}
	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "DownFile [num=" + num + ", path=" + path + ", title=" + title + ", content=" + content + ", writer_id="
				+ writer_id + ", up_date=" + up_date + ", hit=" + hit + "]";
	}
	
}
