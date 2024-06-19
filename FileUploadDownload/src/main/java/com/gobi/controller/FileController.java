package com.gobi.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gobi.service.FileService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class FileController {
	
	private final FileService fileService;
	
	@PostMapping(value="/uploadFile", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
		return ResponseEntity.ok(fileService.saveFile(multipartFile));
	}
	
	@PostMapping(value="/uploadFiles", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> uploadFiles(@RequestParam("files") MultipartFile[] multipartFiles) {
		List<Boolean> fileList = Arrays.stream(multipartFiles).map(f -> fileService.saveFile(f)).collect(Collectors.toList());
		return ResponseEntity.ok(fileList);
	}
	
	@GetMapping(value="/downloadFile/{fileName:.+}")
	public ResponseEntity<?> downloadFile(@PathVariable("fileName") String fileName) {
		Resource resource = fileService.getFile(fileName);
		
		return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	            .body(resource);
	}

}
