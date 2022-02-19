package com.example.demo.imgBoard;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImgMapper {
	void insert(ImgArticle i);

	ImgArticle select(int num);

	List selectAll();

	void delete(int num);

}
