package com.example.demo.imgBoard;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.reply.Reply;

public class ImgArticle {
	private int num;
	private String path;
	private String writer_id;
	private String title;
	private MultipartFile file;
	private ArrayList<Reply> reps;
	
	public ImgArticle(){}
	public ImgArticle(int num, String path, String writer_id, String title) {
		this.num = num;
		this.path = path;
		this.writer_id = writer_id;
		this.title = title;
	}
	
	public ArrayList<Reply> getReps() {
		return reps;
	}
	public void setReps(ArrayList<Reply> reps) {
		this.reps = reps;
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
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "ImgArticle [num=" + num + ", path=" + path + ", writer_id=" + writer_id + ", title=" + title + "]";
	}
	
	
}
