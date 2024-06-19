package com.gobi.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileService {
	
	@Value("${upload.file.path}")
	private String folderPath;
	
	@SneakyThrows
	private void init() {
		Path path = Paths.get(folderPath);
		Files.createDirectories(path);
		log.info("Folder Created Successfully!!");
	}

	@SneakyThrows
	public boolean saveFile(MultipartFile multipartFile) {
		boolean writeStatus = false;
		
		if (Objects.nonNull(multipartFile)) {
			String originalFilename = multipartFile.getOriginalFilename();
			log.info("Original File Name :: {}",originalFilename);
			long fileSize = multipartFile.getSize();
			log.info("File Size :: {}",fileSize);
			String contentType = multipartFile.getContentType();
			log.info("Content Type :: {}",contentType);
			byte[] content = multipartFile.getBytes();
			
			Files.write(Paths.get(folderPath + originalFilename), content);
			writeStatus = true;
		}
		return writeStatus;
	}

	@SneakyThrows
	public Resource getFile(String fileName) {
		Resource resource = null;
		File file = new File(folderPath + fileName);
		
		if (file.exists()) {
			resource = new UrlResource(file.toURI());
		}
		return resource;
	}

}
