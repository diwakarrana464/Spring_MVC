package com.rana.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownloadController {
	
	// getting list of all file and download whichone you want to download....
	
	
	@RequestMapping("/display.htm")
	public String displayListOfFile( ) {
		return "file_download";
	}
	
	@RequestMapping("/download.htm")
	public String getDownloadFile(
			@RequestParam("file_name")String fileName,
			HttpServletResponse res
			) {
		InputStream is = null;
		String filePath = "D:/springfileUploads/"+fileName;
		System.out.println("requested file name is "+fileName);
		try {
			is = new FileInputStream(filePath);
			res.setHeader("Content-Disposition", "attachment;  filename="+fileName );
			IOUtils.copy(is, res.getOutputStream());
			res.flushBuffer();
			
		}catch (IOException e) {
			throw new RuntimeException("IO Error while writing file to output stream");
		}
		return null;//page will return to the place request is coming
	}
}
