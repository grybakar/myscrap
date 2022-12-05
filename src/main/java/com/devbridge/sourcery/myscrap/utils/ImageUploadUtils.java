package com.devbridge.sourcery.myscrap.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
@Slf4j
public class ImageUploadUtils {

  private final Path storageDirectory = Paths.get("images");

  public String uploadImage(MultipartFile file) {
    try {
      byte[] data = file.getBytes();
      Path filePath = Paths.get(storageDirectory + "\\" + file.getOriginalFilename());
      Files.write(filePath, data);
    } catch (IOException e) {
      log.error("Error in uploading an image: {}", e.getMessage());
    }
    return ServletUriComponentsBuilder
      .fromCurrentContextPath()
      .path("/images/getImage/")
      .path(file.getOriginalFilename())
      .toUriString();
  }

  public byte[] getImage(String fileName) {
    Path filePath = Paths.get(storageDirectory + "\\" + fileName);
    try {
      return IOUtils.toByteArray(filePath.toUri());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
