package com.example.demo.down;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownController {

	@Autowired
	private DownService service;

	@RequestMapping(value = "/down/form")
	public void form() {
	}

	@RequestMapping(value = "/down/list")
	public ModelAndView list() {
		ArrayList<DownFile> list = (ArrayList<DownFile>) service.getFiles();
		return new ModelAndView("down/list", "list", list);
	}

	@RequestMapping(value = "/down/upload")
	public String upload(DownFile f) {
		String fileName = f.getFile().getOriginalFilename();
		String path = "C:\\img\\" + fileName;
		File ff = new File(path);
		try {
			f.getFile().transferTo(ff);
			f.setPath(path);
			service.upLoadFile(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/down/list";
	}

	@RequestMapping(value = "/down/read")
	public ModelAndView read(@RequestParam(value = "num") int num) {
		ModelAndView mav = new ModelAndView("down/read");
		DownFile f = service.getFile(num);
		int idx = f.getPath().lastIndexOf('\\');
		String fileName = f.getPath().substring(idx + 1);
		mav.addObject("f", f);
		mav.addObject("fileName", fileName);
		return mav;
	}

	@RequestMapping(value = "/down/preview")
	public ResponseEntity<Resource> preview(@RequestParam(value = "num") int num) {
		try {
			DownFile f = service.getFile(num);
			Path path = Paths.get(f.getPath());
			String contentType = Files.probeContentType(path);
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, contentType);

			Resource resource = new InputStreamResource(Files.newInputStream(path));

			return new ResponseEntity<>(resource, headers, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/down/download")
	public ResponseEntity<Resource> download(@RequestParam(value = "num") int num) {

		Resource resource = null;
		HttpHeaders headers = null;
		try {
			DownFile f = service.getFile(num);
			Path path = Paths.get(f.getPath());
			String contentType = Files.probeContentType(path);
			headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, contentType);
			int idx = f.getPath().lastIndexOf('\\');
			String fileName = f.getPath().substring(idx + 1);
			resource = new InputStreamResource(Files.newInputStream(path));
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");//다운로드 해더 설정
			service.editHit(num);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/down/edit")
	public String edit(DownFile f) {
		DownFile del = service.getFile(f.getNum());
		String delPath = del.getPath();
		// System.out.println("file:"+f.getFile().getOriginalFilename());
		if (f.getFile().getOriginalFilename() != null && !f.getFile().getOriginalFilename().equals("")) {
			String fileName = f.getFile().getOriginalFilename();
			String path = "C:\\img\\" + fileName;
			File ff = new File(path);
			try {
				f.getFile().transferTo(ff);
				f.setPath(path);
				File x = new File(delPath);
				x.delete();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			f.setPath(delPath);
		}
		service.editFileInfo(f);
		return "redirect:/down/list";
	}

	@RequestMapping(value = "/down/del")
	public String del(@RequestParam(value = "num") int num) {
		DownFile del = service.getFile(num);
		String delPath = del.getPath();
		File x = new File(delPath);
		x.delete();
		service.delFile(num);
		return "redirect:/down/list";
	}

}
