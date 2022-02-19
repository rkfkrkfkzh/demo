package com.example.demo.reply;

public class Reply {
	private int num;
	private int img_num;
	private String content;
	private String writer_id;
	public Reply(){}
	public Reply(int num, int img_num, String content, String writer_id) {
		this.num = num;
		this.img_num = img_num;
		this.content = content;
		this.writer_id = writer_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getImg_num() {
		return img_num;
	}
	public void setImg_num(int img_num) {
		this.img_num = img_num;
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
	@Override
	public String toString() {
		return "Reply [num=" + num + ", img_num=" + img_num + ", content=" + content + ", writer_id=" + writer_id + "]";
	}
	
	
}
