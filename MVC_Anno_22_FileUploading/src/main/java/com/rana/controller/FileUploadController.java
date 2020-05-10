package com.rana.controller;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.rana.command.UploadCommand;

@Controller
public class FileUploadController {
	
	@GetMapping("/upload.htm")
	public String showForm(@ModelAttribute("uplCmd") UploadCommand cmd) {
		return "file_upload";
	}
	
	@PostMapping("/upload.htm")
	public String upload(
			Map<String, String> map,
			@ModelAttribute("uplCmd") UploadCommand cmd
			) {
		String photo_fileName = null;
		String resume_fileName=null;
		InputStream in = null;
		OutputStream out = null;
		int read =0;
		
		File dir = new File("D:/springfileUploads/");
		if(!dir.exists()) {
			dir.mkdir();
		}
		 MultipartFile ePhoto = cmd.getEphoto();
		 MultipartFile eResume = cmd.getEresume();
		 //get the name of files uploaded
		 if(ePhoto!=null) {
			 photo_fileName = ePhoto.getOriginalFilename();
			 System.out.println("original file name "+photo_fileName );
			 //Handle file content ....
			 				try {
			 					in = ePhoto.getInputStream();
			 					out = new FileOutputStream(new File("D:/springfileUploads/"+photo_fileName));
			 					byte[] buffer = new byte[1024];
			 					while ((read = in.read(buffer))!=-1) {
			 						
			 						out.write(buffer);
			 					}
			 					out.close();
			 					in.close();
			 				} catch(IOException ioe) {
			 					ioe.printStackTrace();
			 				}
		 }
		
		 if(eResume!=null) {
			 resume_fileName = eResume.getOriginalFilename();
			 System.out.println("original file name "+resume_fileName );
			 //Handle file content ....
			 				try {
			 					in = eResume.getInputStream();
			 					out = new FileOutputStream(new File("D:/springfileUploads/"+resume_fileName));
			 					byte[] buffer = new byte[1024];
			 					while ((read = in.read(buffer))!=-1) {
			 						
			 						out.write(buffer);
			 					}
			 					out.close();
			 					in.close();
			 				} catch(IOException ioe) {
			 					ioe.printStackTrace();
			 				}
		 }
		String str = photo_fileName+"   "+resume_fileName;
		map.put("str1", str);
		return "file_upload_success";
	}
}
