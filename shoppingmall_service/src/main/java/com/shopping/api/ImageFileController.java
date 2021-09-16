package com.shopping.api;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import com.shopping.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageFileController {
    @Autowired ProductService service;

    @GetMapping("/image/{uri}")
    public ResponseEntity<Resource> getImage(@PathVariable String uri, HttpServletRequest request) throws Exception{
        Path folderLocation = Paths.get("/shopping/images");

        String fileName = service.getProductImageFileName(uri);
        if(fileName == null){
            return null;
        }
        // 파일의 실제 경로 생성
        Path filePath = folderLocation.resolve(fileName).normalize();
        // exception
        Resource r = null;
        try {
            r = new UrlResource(filePath.toUri());
        } catch(Exception e){
            System.out.println("Resoource Exception");
        }

        //exception
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(r.getFile().getAbsolutePath());
        } catch(Exception e){
            System.out.println("File not fount Exception");
        }

        if(contentType == null){
        contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=\""+r.getFile()+"\"")
        .body(r);
    }
}
