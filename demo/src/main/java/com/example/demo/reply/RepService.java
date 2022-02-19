package com.example.demo.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepService {

	@Autowired
	private RepMapper mapper;

	public void addReply(Reply r) {
		mapper.insert(r);
	}

	public Reply getReply(int num) {
		return mapper.select(num);
	}

	public List getByImgNum(int img_num) {
		return mapper.selectByImgNum(img_num);
	}

	public void delReply(int num) {
		mapper.delete(num);
	}
}
