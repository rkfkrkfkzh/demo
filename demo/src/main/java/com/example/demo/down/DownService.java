package com.example.demo.down;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownService {

	@Autowired
	private DownMapper mapper;

	public void upLoadFile(DownFile f) {
		mapper.addFile(f);
	}

	public DownFile getFile(int num) {
		return mapper.getFile(num);
	}

	public List getFiles() {
		return mapper.getAll();
	}

	public void editFileInfo(DownFile f) {
		mapper.editFile(f);
	}

	public void editHit(int num) {
		mapper.editHit(num);
	}

	public void delFile(int num) {
		mapper.delFile(num);
	}
}
