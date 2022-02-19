package com.example.demo.imgBoard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.reply.RepService;
import com.example.demo.reply.Reply;

@Controller
public class ImgController {
	
	@Autowired
	private ImgService imgService;
	
	@Autowired
	private RepService repService;
	
	@RequestMapping(value = "/img/form")
	public void form() {
		
	}

	@RequestMapping(value = "/img/write")
	public String write(ImgArticle i) {
		String fileName = i.getFile().getOriginalFilename();
		String path = "C:\\img\\" + fileName;
		File f = new File(path);
		try {
			i.getFile().transferTo(f);
			i.setPath(path);
			imgService.addArticle(i);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/img/list";
	}

	@RequestMapping(value = "/img/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("img/list");
		ArrayList<ImgArticle> list = (ArrayList<ImgArticle>) imgService.getAll();
		for (int i = 0; i < list.size(); i++) {
			ImgArticle a = list.get(i);
			ArrayList<Reply> reps = 
					(ArrayList<Reply>) repService.getByImgNum(a.getNum());
			a.setReps(reps);
		}
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/img/del")
	public String del(@RequestParam(value = "num") int num) {
		ImgArticle i = imgService.getArticle(num);
		File f = new File(i.getPath());
		f.delete();
		imgService.delArticle(num);
		return "redirect:/img/list";
	}
	
	@RequestMapping("/img/img_read")
	public ResponseEntity<byte[]> getImg(int num){ //byte 단위로 읽어서 
		ImgArticle i = imgService.getArticle(num);//이미지 번호를 받아서 
		File f = new File(i.getPath());//이미지 경로를 받아오고 
		HttpHeaders header  = new HttpHeaders();//response header 
		ResponseEntity<byte[]> result = null; //응답 객체 형태로 반환 
		try {
			header.add("Content-Type", Files.probeContentType(f.toPath())); //파일의 종류(이미지, 메모장 )
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);//파일 내용을 읽어서 byte 배열 형태로 변환
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
