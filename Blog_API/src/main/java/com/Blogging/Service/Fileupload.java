package com.Blogging.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface Fileupload {
	
	String uploadImage(String path,MultipartFile File) throws IOException;
 InputStream getResource(String path ,String fileName) throws FileNotFoundException;
}
