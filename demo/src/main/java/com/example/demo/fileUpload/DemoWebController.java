package com.example.demo.fileUpload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.fileUpload.MyFile;

@Controller
public class DemoWebController {

	@GetMapping("/file/uploadForm")
	public String uploadForm() {
		return "file/form";
	}
	@GetMapping("/file/test")
	public String test() {
		return "file/list";
	}
	@PostMapping("/file/upload")
	public String upload(@RequestParam("file") MultipartFile f) {
//		int idx = f.getOriginalFilename().lastIndexOf('\\');
//		String fname = f.getOriginalFilename().substring(idx + 1);
		String fname = f.getOriginalFilename();
		try {
			f.transferTo(new File(fname));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/file/list";
	}

	@PostMapping("/file/upload2")
	public String upload2(MyFile mf) {
		MultipartFile f = mf.getFile();
//		int idx = f.getOriginalFilename().lastIndexOf('\\');
//		String fname = f.getOriginalFilename().substring(idx + 1);
//		System.out.println(fname);
		String fname = f.getOriginalFilename();
		try {
			f.transferTo(new File(fname));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/file/list";
	}
	
	@RequestMapping("/file/list")
	public ModelAndView flist() {
		File dir = new File("C:\\img\\");
		String[] fnames = dir.list();
		ModelAndView mv = new ModelAndView("file/list");
		mv.addObject("list", fnames);
		return mv;
	}
	@RequestMapping("/file/img")
	public ResponseEntity<byte[]> getImg(String fname){
		File f = new File("C:\\img\\"+fname);
		//response header 
		HttpHeaders header  = new HttpHeaders();
		ResponseEntity<byte[]> result = null;
		try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
