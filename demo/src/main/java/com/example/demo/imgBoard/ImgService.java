package com.example.demo.imgBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgService {
	
	@Autowired
	private ImgMapper mapper;
	
	public void addArticle(ImgArticle i) {
		mapper.insert(i);
	}
	public ImgArticle getArticle(int num) {
		return mapper.select(num);
	}
	public List getAll() {
		return mapper.selectAll();
	}
	public void delArticle(int num) {
		mapper.delete(num);
	}
}
