package com.devbridge.sourcery.myscrap.controller;

import com.devbridge.sourcery.myscrap.service.ImageService;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/images")
@AllArgsConstructor
public class ImageController {

  public final ImageService imageService;

  @PostMapping(value = "upload")
  public ResponseEntity<String> uploadImage(@RequestParam MultipartFile file) {
    String fileUrl = imageService.uploadImage(file);
    return new ResponseEntity<>(fileUrl, HttpStatus.OK);
  }


  @GetMapping(
    value = "getImage/{imageName}",
    produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE}
  )
  public @ResponseBody byte[] getImageWithMediaType(@PathVariable(name = "imageName") String fileName)
    throws IOException {
    return imageService.getImage(fileName);
  }


}
