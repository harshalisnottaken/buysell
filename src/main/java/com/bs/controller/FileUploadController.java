package com.bs.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/img")
public class FileUploadController {

	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	public ResponseEntity<?> uploadMultipleFileHandler(
			@RequestParam("file") MultipartFile[] files) throws IOException {
	
		List<String> fileNamesList = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			byte[] bytes = file.getBytes();

			String rootPath = System.getProperty("user.dir");
			File dir = new File(rootPath + "/src/main/webapp/images/");
			
			File serverFile = new File(dir.getAbsolutePath() + File.separator
					+ file.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			fileNamesList.add("http://localhost:8086/buysellapp/images/"+file.getOriginalFilename());
			stream.write(bytes);
			stream.close();

			System.out.println("Server File Location="
					+ serverFile.getAbsolutePath());
		}
		return new ResponseEntity<List<String>>(fileNamesList, HttpStatus.OK);
	}
}