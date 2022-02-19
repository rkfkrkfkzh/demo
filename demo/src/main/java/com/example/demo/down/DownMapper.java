package com.example.demo.down;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DownMapper {
	void addFile(DownFile f);
	DownFile getFile(int num);
	List getAll();
	void editFile(DownFile f);
	void editHit(int num);
	void delFile(int num);
}
